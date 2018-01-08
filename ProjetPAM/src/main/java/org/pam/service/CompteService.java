package org.pam.service;

import java.util.List;

import org.pam.model.Compte;
import org.pam.model.Utilisateur;

public interface CompteService {

	
	public void addCompte(Compte compte);
	public void effectuerVirement(List<Utilisateur> utilisateurs);
	
	
	
	
}
