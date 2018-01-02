package org.pam.service.impl;

import java.util.Date;

import org.pam.model.Enfant;
import org.pam.model.Reservation;
import org.pam.model.Utilisateur;
import org.pam.repository.RepositoryReservation;
import org.pam.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;

public class ReservationServiceImpl implements ReservationService {

	@Autowired
	private RepositoryReservation repositoryReservation;

	@Override
	public void ajouterReservation(Utilisateur utilisateur, Enfant enfant, Date dateReservation, Double prix, Integer pointUtilise) {
		Reservation reservation = new Reservation(dateReservation, utilisateur, enfant, prix, pointUtilise);
		repositoryReservation.save(reservation);
	}

}
