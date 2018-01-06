 package org.pam.service;

import java.util.Date;

import org.pam.model.Enfant;
import org.pam.model.Utilisateur;

public interface ReservationService {
	
	public void PayerReservation(int idAnnonce ,int idUtilisateur,int  IdEnfant,
			Date dateResevation,Double prix, Integer pointUtilise,String typePaiement);
	
}
