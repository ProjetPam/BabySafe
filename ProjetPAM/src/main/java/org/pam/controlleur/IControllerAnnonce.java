package org.pam.controlleur;

import java.util.Date;

import org.springframework.ui.Model;

public interface IControllerAnnonce { 
	public abstract String ajouterAnnonce(Model model, Date DateAnnonce,
			String heure_depart, String heure_fini, String description);

	public abstract String addAnnonce(Model model, Date DateAnnonce,
			String heure_depart, String heure_fini, String description);

	public abstract String ajouterAnnonce(Model model);

	public abstract String Reservation(Model model, int idAnnonce);

}