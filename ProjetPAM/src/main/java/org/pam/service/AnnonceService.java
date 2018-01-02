package org.pam.service;

import java.util.Collection;

import org.pam.model.Annonce;

public interface AnnonceService {

	
	public void ajouterAnnonce(Annonce annonce,int idUtilisateur);
	public Collection<Annonce> getAllAnnonces();
	public Annonce getAnnonceByID(int id);
	
	
}
