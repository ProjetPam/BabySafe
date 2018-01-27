 package org.pam.service;

import java.util.Collection;
import java.util.Date;

import org.pam.model.Annonce;
import org.pam.model.Enfant;
import org.pam.model.Reservation;
import org.pam.model.Utilisateur;

public interface ReservationService {
	
	public void PayerReservation(int idAnnonce ,int idUtilisateur,int  IdEnfant,
			Date dateResevation,Double prix, Integer pointUtilise,String typePaiement);
	
	        public void annulerReservation(int idAnnonce,int idReservation,int idUtilisateur);
	        public Collection<Reservation> getAllReservationByUtilisateur(int idUtilisateur);
	
	        public Collection<Reservation> getHistoriqueReservationByUtilisateur(int idUtilisateur);
	        
	        public Double getArgentVerser(int idUtilisateur);
	        public Collection<Reservation> getReservationConfirmeeByUtilisateur(int idUtilisateur);
	        
	        
}
