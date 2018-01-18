package org.pam.service.impl;

import java.util.Collection;

import org.pam.model.Departement;
import org.pam.repository.RepositoryDepartement;
import org.pam.service.DepartementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DepartementServiceImpl  implements DepartementService{

	@Autowired
	private RepositoryDepartement repositoryDepartement;
	
	
	@Override
	public Collection<Departement> getallDepartement() {
		
		return repositoryDepartement.findAll();
	}

}
