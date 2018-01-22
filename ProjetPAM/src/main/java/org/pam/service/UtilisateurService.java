package org.pam.service;

import org.pam.model.Utilisateur;

public interface UtilisateurService {

	public Utilisateur getUtilisateurById(int idUtilisateur);
	public Utilisateur authentitication(String login,String password);
	public void enregistrement(Utilisateur utilisateur);
	
}
