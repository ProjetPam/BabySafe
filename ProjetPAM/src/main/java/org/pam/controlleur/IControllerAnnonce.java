package org.pam.controlleur;

import java.util.Date;

import org.springframework.ui.Model;

public interface IControllerAnnonce { 
	public abstract String ajouterAnnonce(Model model, Date DateAnnonce,
			String heure_depart, String heure_fini, String description,Double prix) throws Exception;

	public abstract String addAnnonce(Model model, Date DateAnnonce,
			String heure_depart, String heure_fini, String description,Double prix) throws Exception;

	public abstract String ajouterAnnonce(Model model) throws Exception;

	public abstract String Reservation(Model model, int idAnnonce) throws Exception;

	public abstract String paiement(Model model,int idenfant,int idAnnonce,Double prix,Integer poinUtiliser);
	
}