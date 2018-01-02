package org.pam.service.impl;

import java.util.Collection;

import org.pam.model.Annonce;
import org.pam.model.Utilisateur;
import org.pam.repository.RepositoryAnnonce;
import org.pam.repository.RepositoryUtilisateurs;
import org.pam.service.AnnonceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AnnonceServiceImpl implements AnnonceService  {

	@Autowired
	private RepositoryUtilisateurs repositoryutilisateurs;
	
	@Autowired
	private RepositoryAnnonce repositoryannonce;
	
	@Override
	public void ajouterAnnonce(Annonce annonce, int idUtilisateur) {

	Utilisateur utilisateur=repositoryutilisateurs.findOne(idUtilisateur);
	annonce.setUtilisateur(utilisateur);
	
	repositoryannonce.save(annonce);
		
	}

	@Override
	public Collection<Annonce> getAllAnnonces() {
		return repositoryannonce.getAllAnonces();
	}

	@Override
	public Annonce getAnnonceByID(int id) {
		
		return repositoryannonce.findOne(id);
	}

}
