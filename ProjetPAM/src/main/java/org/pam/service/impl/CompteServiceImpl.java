package org.pam.service.impl;

import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.pam.model.Compte;
import org.pam.model.Utilisateur;
import org.pam.model.Virement;
import org.pam.repository.RepositoryCompte;
import org.pam.repository.RepositoryUtilisateurs;
import org.pam.repository.RepositoryVirement;
import org.pam.service.CompteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.thymeleaf.context.ForbiddenContextVariableRestriction;


@Service
public class CompteServiceImpl implements CompteService {

	@Autowired
	private RepositoryCompte repositoryCompte;
	
	@Autowired
	private RepositoryVirement repositoryVirement;
	
	@Autowired
	private RepositoryUtilisateurs repositoryUtilisateurs;
	
	
	@Override
	public void addCompte(Compte compte) {
		repositoryCompte.save(compte);

	}

	@Override
	public void effectuerVirement(List<Utilisateur> utilisateurs) {
		
		for (Utilisateur utilisateur : utilisateurs) {
			if(utilisateur.getSolde() > 0){
				Compte compte=repositoryCompte.getCompteUtilisateur(utilisateur);
				repositoryVirement.save(new Virement(new Date(), utilisateur.getSolde(), compte));
				utilisateur.setSolde(0.0);
				
			}
		}
			
		}
		
	}


