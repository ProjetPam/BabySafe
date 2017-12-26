package org.pam.metier;

import org.pam.entities.Enfants;
import org.pam.repository.RepositoryEnfants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Service
public class MetierEnfantsImpl implements MetierEnfants{

	@Autowired
	private RepositoryEnfants repositoryenfant;
	
	
	@Override
	public void ajouterEnfants(Enfants enfant) {
		repositoryenfant.save(enfant);
		
	}

}
