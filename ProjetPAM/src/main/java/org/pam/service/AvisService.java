package org.pam.service;

import java.util.Collection;

import org.pam.model.Annonce;
import org.pam.model.Avis;
import org.pam.model.Utilisateur;

public interface AvisService {

	public void addAvis(Utilisateur utilisateurComentateur,Annonce annonce,String commentaire,int note);
	
	public Collection<Avis> getAvisByannonce(int idAnnonce);
	
}
