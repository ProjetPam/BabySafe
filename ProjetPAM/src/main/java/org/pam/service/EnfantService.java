package org.pam.service;

import java.util.Collection;

import org.pam.model.Enfant;

public interface EnfantService {

	public void ajouterEnfants(Enfant enfant,int idUtilisateur);
	public Collection<Enfant> getEnfantsByUtilisateur(int idUtilisateur);
	
}
