package org.pam.metier;

import java.util.Collection;

import org.pam.entities.Annonces;

public interface MetierAnnonces {

	
	public void ajouterAnnonce(Annonces annonce,int idUtilisateur);
	public Collection<Annonces> getAllAnnonces();
	public Annonces getAnnonceByID(int id);
	
	
}
