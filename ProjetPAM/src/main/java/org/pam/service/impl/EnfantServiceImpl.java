package org.pam.service.impl;

import java.util.Collection;

import org.pam.model.Enfant;
import org.pam.model.Utilisateur;
import org.pam.repository.RepositoryEnfants;
import org.pam.repository.RepositoryUtilisateurs;
import org.pam.service.EnfantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Service
public class EnfantServiceImpl implements EnfantService{

	@Autowired
	private RepositoryEnfants repositoryenfant;
	@Autowired
	private RepositoryUtilisateurs repositoryutilisateur;
	
	@Override
	public void ajouterEnfants(Enfant enfant,int idUtilisateuri ){
		Utilisateur utilisateur=repositoryutilisateur.findOne(idUtilisateuri);
		enfant.setUtilisateur(utilisateur);
		repositoryenfant.save(enfant);
		
	}

	@Override
	public Collection<Enfant> getEnfantsByUtilisateur(int idUtilisateur) {
		
		return repositoryenfant.getAllenfantsByutilisateur(idUtilisateur);
	}

}
