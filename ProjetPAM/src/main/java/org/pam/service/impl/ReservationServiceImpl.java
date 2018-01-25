package org.pam.service.impl;


import java.sql.Timestamp;
import java.util.Collection;
import java.util.Date;

import org.pam.model.Annonce;
import org.pam.model.Compte;
import org.pam.model.Enfant;
import org.pam.model.Reservation;
import org.pam.model.Statistique;
import org.pam.model.Utilisateur;
import org.pam.model.Virement;
import org.pam.repository.RepositoryAnnonce;
import org.pam.repository.RepositoryCompte;
import org.pam.repository.RepositoryEnfants;
import org.pam.repository.RepositoryReservation;
import org.pam.repository.RepositoryStatistique;
import org.pam.repository.RepositoryUtilisateurs;
import org.pam.repository.RepositoryVirement;
import org.pam.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReservationServiceImpl implements ReservationService {

	@Autowired
	private RepositoryReservation repositoryReservation;

	@Autowired
	private RepositoryUtilisateurs repositoryUtilisateurs;

	@Autowired
	private RepositoryEnfants repositoryEnfants;

	@Autowired
	private RepositoryAnnonce repositoryAnnonce;

	@Autowired
	private RepositoryStatistique repositoryStatistique;
	
	@Autowired
	private RepositoryCompte repositoryCompte;
	
	@Autowired
	private RepositoryVirement repositoryVirement;
	

	private final static int POURCENTAGE = 30;

	@Override
	public void PayerReservation(int iDAnnonce, int idUtilisateur,
			int IdEnfant, Date dateReservation, Double prix,
			Integer pointUtilise, String typePaiement) {

		Utilisateur utilisateur = repositoryUtilisateurs.findOne(idUtilisateur);
		Enfant enfant = repositoryEnfants.findOne(IdEnfant);
		Annonce annonce = repositoryAnnonce.findOne(iDAnnonce);

		Statistique statistique = null;

		Reservation reservation = null;

		Utilisateur utililateurAnnonceur = annonce.getUtilisateur();

		if (!annonce.isAnnonceGratuite()) {

			switch (typePaiement) {
			case "Agrent":
				if (utililateurAnnonceur.getSolde() != null) {
					utililateurAnnonceur
							.setSolde(utililateurAnnonceur.getSolde()
									+ (calculeLaSommeApayer(annonce) - calculePourcentage(
											calculeLaSommeApayer(annonce),
											POURCENTAGE)));
				} else
					utililateurAnnonceur.setSolde(calculeLaSommeApayer(annonce)
							- calculePourcentage(calculeLaSommeApayer(annonce),
									POURCENTAGE));

				statistique = new Statistique(annonce, new Date(),
						calculePourcentage(calculeLaSommeApayer(annonce),
								POURCENTAGE));

				reservation = new Reservation(dateReservation, utilisateur,
						enfant, calculeLaSommeApayer(annonce), 0, annonce);
				break;
			case "PointsArgent":

				// Verification du solde de l'annonceur pour eviter la
				// concatination avce null
				if (utililateurAnnonceur.getSolde() != 0) {
					utililateurAnnonceur
							.setSolde(utililateurAnnonceur.getSolde()
									+ ConvertirPointsVertEuro(pointUtilise)
									+ (DifferencePayer(pointUtilise, annonce) - calculePourcentage(
											DifferencePayer(pointUtilise,
													annonce), POURCENTAGE)));
				} else
					utililateurAnnonceur
							.setSolde(ConvertirPointsVertEuro(pointUtilise)
									+ (DifferencePayer(pointUtilise, annonce) - calculePourcentage(
											DifferencePayer(pointUtilise,
													annonce), POURCENTAGE)));

				//debiter le nombre de point 
				utilisateur.setNombre_points(utilisateur.getNombre_points()-pointUtilise);
				
				statistique = new Statistique(annonce, new Date(),
						calculePourcentage(
								DifferencePayer(pointUtilise, annonce),
								POURCENTAGE));

				reservation = new Reservation(dateReservation, utilisateur,
						enfant, ConvertirPointsVertEuro(pointUtilise)
								+ DifferencePayer(pointUtilise, annonce),
						pointUtilise, annonce);

				break;

			case "Points":
				// verification que le montant converti en euro est suffisant
				// pour payer la reservation
				if ((calculeLaSommeApayer(annonce) - calculePourcentage(
						calculeLaSommeApayer(annonce), POURCENTAGE)) <= ConvertirPointsVertEuro(pointUtilise)) {
					// Verification du solde de l'annonceur pour eviter la
					// concatination avce null
					if (utililateurAnnonceur.getSolde() != 0) {
						utililateurAnnonceur.setSolde(utililateurAnnonceur
								.getSolde()
								+ ConvertirPointsVertEuro(pointUtilise));
					} else{
						utililateurAnnonceur
								.setSolde(ConvertirPointsVertEuro(pointUtilise));}

					//debiter le nombre de point 
					utilisateur.setNombre_points(utilisateur.getNombre_points()-pointUtilise);
					
					statistique = new Statistique(annonce, new Date(), 0.0);

					reservation = new Reservation(dateReservation, utilisateur,
							enfant, ConvertirPointsVertEuro(pointUtilise),
							pointUtilise, annonce);
					
				}

				break;

			}

		} else {

			switch (typePaiement) {
			case "Agrent":
				utililateurAnnonceur.setNombre_points(utililateurAnnonceur
						.getNombre_points() + calculeNombrePointGagner(annonce));
	            double benefice = calculeNombrePointGagner(annonce);
	            //l'argent gagne
				statistique = new Statistique(annonce, new Date(), benefice);
				 
	             utilisateur.setNombre_points(utilisateur.getNombre_points()-calculeNombrePointGagner(annonce));
				
				reservation = new Reservation(dateReservation, utilisateur, enfant,
						 benefice, 0, annonce);
				break;
			case "Points":
				
				utililateurAnnonceur.setNombre_points(utililateurAnnonceur
						.getNombre_points() + (calculeNombrePointGagner(annonce)*2));
	             benefice = calculeNombrePointGagner(annonce);
	             
	             utilisateur.setNombre_points(utilisateur.getNombre_points()-(calculeNombrePointGagner(annonce)*2));
				
	             statistique = new Statistique(annonce, new Date(), benefice);

				reservation = new Reservation(dateReservation, utilisateur, enfant,
						 benefice, 0, annonce);
				break;

			}
			

		}
		reservation.setStatut("encours");
		repositoryReservation.save(reservation);

		repositoryStatistique.save(statistique);
	}

	// calculer le pourcentage a gagner pou chaque reservation
	private Double calculePourcentage(Double prix, int pourcentage) {
		return (prix * pourcentage) / 100;
	}

	// calculer le prix a payer
	private Double calculeLaSommeApayer(Annonce annonce) {
		// Calculer Nombre d'heur à payer
		long  HeurFin= annonce.getHeure_fini().getTime() ;
		long Heurdepart	 = annonce.getHeure_depart().getTime();
		long nombreHeure = (HeurFin - Heurdepart) /  (60 * 60 * 1000);


		Double PrixPayer = nombreHeure * annonce.getPrix();

		return PrixPayer;
	}

	// Convertir le nombre de points en euro chaque 1 point = 0,66euro
	private Double ConvertirPointsVertEuro(int pointUtiliser) {

		Double PrixPayer = pointUtiliser * 0.66;

		return PrixPayer;
	}

	// calcule la difference a payer entre les points utiliser et prix d'annonce
	private Double DifferencePayer(int pointUtiliser, Annonce annonce) {

		Double PrixPayer =  calculeLaSommeApayer(annonce) -  ConvertirPointsVertEuro(pointUtiliser);
				

		return PrixPayer;
	}
	
	private long calculeNombrePointGagner(Annonce annonce) {
		long  HeurFin= annonce.getHeure_fini().getTime() ;
		long Heurdepart	 = annonce.getHeure_depart().getTime();
		long nombreHeure = (HeurFin - Heurdepart) /  (60 * 60 * 1000);

		return nombreHeure;
	}

	@Override
	public void annulerReservation(int idAnnonce, int idReservation,
			int idUtilisateur) {
		Date dateActuel=new Date();
		
		//Annonce annonce=repositoryAnnonce.findOne(idAnnonce);
		Annonce annonce=repositoryReservation.findOne((long)idReservation).getAnnonce();
		Utilisateur utilisateur=repositoryReservation.findOne((long)idReservation).getAnnonce().getUtilisateur();
		Reservation reservation=repositoryReservation.findOne((long)idReservation);
		
	long	diff =   annonce.getDate_annonce().getTime() - dateActuel.getTime();
		
		if( diff >= (24 * 60 * 60 * 1000)){
			//annonce.setStatut(Constante.ANNULEE);
			//annonce.setDate_annulation(new Timestamp(new Date().getTime()));
		if(utilisateur.getSolde()>0 && utilisateur.getNombre_points() >0){
			utilisateur.setSolde(utilisateur.getSolde()+reservation.getPrix());
			utilisateur.setNombre_points(utilisateur.getNombre_points()+reservation.getPointUtilise());
		}else{
			utilisateur.setSolde(reservation.getPrix());
			utilisateur.setNombre_points(utilisateur.getNombre_points()+reservation.getPointUtilise());
		}
		
		reservation.setStatut("annulee");
		repositoryReservation.save(reservation);
		}
		
	}

	@Override
	public Collection<Reservation> getAllReservationByUtilisateur(int idUtilisateur) {
		return repositoryReservation.getAllReservationByUtilisateur(idUtilisateur);
	}

	@Override
	public Collection<Reservation> getHistoriqueReservationByUtilisateur(
			int idUtilisateur) {
		return repositoryReservation.getHistoriqueReservationByUtilisateur(idUtilisateur);
	}

	@Override
	public Double getArgentVerser(int idUtilisateur) {
		Collection<Reservation> allreservation=getHistoriqueReservationByUtilisateur(idUtilisateur);
		
		Date date= new java.util.Date();
		Timestamp dateActuel = new Timestamp(date.getTime());
		
		Double Somme=0.0;
		for (Reservation reservation : allreservation) {
			//long	diff =   annonce.getDate_annonce().getTime() - dateActuel.getTime();
			
			if (reservation.getAnnonce().getDate_annonce().before(dateActuel) && !reservation.getStatut().equals("confirmee") ){
				
				Compte compte=repositoryCompte.getCompteUtilisateur(reservation.getAnnonce().getUtilisateur());
				repositoryVirement.save(new Virement(new Date(), reservation.getPrix(), compte));
				reservation.getAnnonce().getUtilisateur().setSolde
				(reservation.getAnnonce().getUtilisateur().getSolde()-reservation.getPrix());
				
				
				Somme=Somme+reservation.getPrix();
				reservation.setStatut("confirmee");
			}
			
			
		}
		return Somme;
	}

}
