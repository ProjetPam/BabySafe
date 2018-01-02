package org.pam.service;

import java.util.Collection;

import org.pam.model.Annonce;

public interface AnnonceService {

	public void ajouterAnnonce(Annonce annonce, int idUtilisateur)
			throws Exception;

	public Collection<Annonce> getAllAnnonces() throws Exception;

	public Annonce getAnnonceByID(int id) throws Exception;

}
