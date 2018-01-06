package org.pam.service;

import org.pam.model.Annonce;
import org.pam.model.Utilisateur;

public interface AvisService {

	public void addAvis(Utilisateur utilisateurComentateur,Annonce annonce,String commentaire,int note);
	
	
}
