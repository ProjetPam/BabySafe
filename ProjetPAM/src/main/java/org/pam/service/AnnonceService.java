package org.pam.service;

import java.util.Collection;
import java.util.Date;

import org.pam.model.Annonce;

public interface AnnonceService {

	public void ajouterAnnonce(Date DateAnnonce,String heure_depart,String heure_fini,String statut,
			String description,Double prix,int nombreEnfant,boolean annanceGratuit,
			long idDepartement,long idVille,String complementAdresse, int idUtilisateur)
			throws Exception;

	public Collection<Annonce> getAllAnnonces() throws Exception;

	public Annonce getAnnonceByID(int id) throws Exception;

	public void annulerAnnonce(int id) throws Exception;
	
	public Collection<Annonce> getAllAnoncesByUtilisateur(int idUtilisateur);
	
	public Collection<Annonce> getAllAnnceByDate(String ville,Date date);
}
