package org.pam.service.impl;

import java.util.Date;

import org.pam.model.Annonce;
import org.pam.model.Enfant;
import org.pam.model.Reservation;
import org.pam.model.Statistique;
import org.pam.model.Utilisateur;
import org.pam.repository.RepositoryAnnonce;
import org.pam.repository.RepositoryEnfants;
import org.pam.repository.RepositoryReservation;
import org.pam.repository.RepositoryStatistique;
import org.pam.repository.RepositoryUtilisateurs;
import org.pam.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReservationServiceImpl implements ReservationService {

	@Autowired
	private RepositoryReservation repositoryReservation;
	
	@Autowired
	private RepositoryUtilisateurs repositoryUtilisateurs ;
	
	@Autowired
	private RepositoryEnfants repositoryEnfants;
	
	@Autowired
	private RepositoryAnnonce repositoryAnnonce;
	
	
	@Autowired
	private RepositoryStatistique repositoryStatistique;
	
    private final static int POURCENTAGE=30;

	@Override
	public void ajouterReservation(int iDAnnonce ,int idUtilisateur,int  IdEnfant, Date dateReservation, Double prix, Integer pointUtilise) {
		
		Utilisateur utilisateur =repositoryUtilisateurs.findOne(idUtilisateur);
		Enfant enfant =repositoryEnfants.findOne(IdEnfant);
		Annonce annonce=repositoryAnnonce.findOne(iDAnnonce);
		
		Utilisateur utililateurAnnonceur=annonce.getUtilisateur();		
		
		if(utililateurAnnonceur.getSolde()!= null)
			utililateurAnnonceur.setSolde(utililateurAnnonceur.getSolde()+(prix-calculePourcentage(prix, POURCENTAGE)));
		else
			utililateurAnnonceur.setSolde(prix-calculePourcentage(prix, POURCENTAGE));
		
		Statistique statistique=new Statistique(annonce,new Date() ,calculePourcentage(prix, POURCENTAGE));
		
		Reservation reservation = new Reservation(dateReservation, utilisateur, enfant, prix, pointUtilise,annonce);
		
		repositoryReservation.save(reservation);
		
		repositoryStatistique.save(statistique);
	}
	
	private Double calculePourcentage(Double prix, int pourcentage){
		return (prix * pourcentage)/100;
	}
	

}
