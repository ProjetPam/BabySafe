package org.pam.service.impl;

import java.sql.Timestamp;
import java.util.Collection;
import java.util.Date;

import org.pam.model.Annonce;
import org.pam.model.Reservation;
import org.pam.model.Utilisateur;
import org.pam.repository.RepositoryAnnonce;
import org.pam.repository.RepositoryReservation;
import org.pam.repository.RepositoryUtilisateurs;
import org.pam.service.AnnonceService;
import org.pam.utilisies.Constante;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AnnonceServiceImpl implements AnnonceService  {

	@Autowired
	private RepositoryUtilisateurs repositoryutilisateurs;
	
	@Autowired
	private RepositoryAnnonce repositoryannonce;
	
	@Autowired
	private RepositoryReservation repositoryReservation;
	
	@Override
	public void ajouterAnnonce(Annonce annonce, int idUtilisateur) {

	Utilisateur utilisateur=repositoryutilisateurs.findOne(idUtilisateur);
	annonce.setUtilisateur(utilisateur);
	
	repositoryannonce.save(annonce);
		
	}

	@Override
	public Collection<Annonce> getAllAnnonces() {
		return repositoryannonce.getAllAnonces();
	}

	@Override
	public Annonce getAnnonceByID(int id) {
		
		return repositoryannonce.findOne(id);
	}

	@Override
	public void annulerAnnonce(int idAnnonce) throws Exception {
       
		
		Annonce annonce=repositoryannonce.findOne(idAnnonce);
		Utilisateur utilisateurAnnonceur = annonce.getUtilisateur();
		Collection<Reservation> reservasions =repositoryReservation.getAllReservationByAnnonce(idAnnonce);
		
		for (Reservation reservation : reservasions) {
			Utilisateur utilisateurReserver=repositoryReservation.findOne((long)reservation.getIdReservation()).getUtilisateur();
		//Romboursement pour le reservateur
			if(utilisateurReserver.getSolde()>0){
				utilisateurReserver.setSolde(utilisateurReserver.getSolde()+reservation.getPrix());
				utilisateurReserver.setNombre_points(utilisateurReserver.getNombre_points()+reservation.getPointUtilise());
			}else{
				utilisateurReserver.setSolde(reservation.getPrix());
				utilisateurReserver.setNombre_points(utilisateurReserver.getNombre_points()+reservation.getPointUtilise());
			}
			//débiter le solde de l'annonceur
			utilisateurAnnonceur.setSolde(utilisateurAnnonceur.getSolde() - reservation.getPrix());
			utilisateurAnnonceur.setNombre_points(utilisateurAnnonceur.getNombre_points()-reservation.getPointUtilise());
		

		}
		
		annonce.setStatut(Constante.ANNULEE);
		annonce.setDate_annulation(new Timestamp(new Date().getTime()));
		
		repositoryannonce.save(annonce);
		
		
	}

	@Override
	public Collection<Annonce> getAllAnoncesByUtilisateur(int idUtilisateur) {
		return repositoryannonce.getAllAnoncesByUtilisateur(idUtilisateur);
	}

}
