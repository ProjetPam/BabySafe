package org.pam.service.impl;

import org.pam.model.Utilisateur;
import org.pam.repository.RepositoryUtilisateurs;
import org.pam.service.UtilisateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UtilisateurServiceImpl implements UtilisateurService {

	@Autowired
	private RepositoryUtilisateurs repositoryutilisateur;
	
	
	@Override
	public Utilisateur getUtilisateurById(int idUtilisateur) {
		
		return repositoryutilisateur.findOne(idUtilisateur);
	}

}
