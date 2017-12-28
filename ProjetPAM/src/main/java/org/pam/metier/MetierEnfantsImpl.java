package org.pam.metier;

import org.pam.entities.Enfants;
import org.pam.entities.Utilisateurs;
import org.pam.repository.RepositoryEnfants;
import org.pam.repository.RepositoryUtilisateurs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Service
public class MetierEnfantsImpl implements MetierEnfants{

	@Autowired
	private RepositoryEnfants repositoryenfant;
	@Autowired
	private RepositoryUtilisateurs repositoryutilisateur;
	
	@Override
	public void ajouterEnfants(Enfants enfant,int idUtilisateuri ){
		Utilisateurs utilisateur=repositoryutilisateur.findOne(idUtilisateuri);
		enfant.setUtilisateur(utilisateur);
		repositoryenfant.save(enfant);
		
	}

}
