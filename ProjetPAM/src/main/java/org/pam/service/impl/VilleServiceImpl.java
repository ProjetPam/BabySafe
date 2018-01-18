package org.pam.service.impl;

import java.util.Collection;

import org.pam.model.Ville;
import org.pam.repository.RepositoryVille;
import org.pam.service.VilleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VilleServiceImpl implements VilleService{

	
	@Autowired
	private RepositoryVille repositoryVille;
	
	
	
	
	@Override
	public Collection<Ville> getAllVilles() {
		
		return repositoryVille.findAll();
	}

}
