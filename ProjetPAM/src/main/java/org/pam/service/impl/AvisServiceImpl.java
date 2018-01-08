package org.pam.service.impl;

import java.sql.Timestamp;
import java.util.Date;

import org.pam.model.Annonce;
import org.pam.model.Avis;
import org.pam.model.Utilisateur;
import org.pam.repository.RepositoryAvis;
import org.pam.service.AvisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AvisServiceImpl implements AvisService{

	@Autowired
	private RepositoryAvis repositoryAvis;
	
	
	
	@Override
	public void addAvis(Utilisateur utilisateurComentateur, Annonce annonce,
			String commentaire, int note) {

		Date dateActuel=new Date();
		long timeActuel=dateActuel.getTime();
		long timeAnnonce=annonce.getHeure_fini().getTime();
		
		
if(timeAnnonce < timeActuel){
	
	
	repositoryAvis.save(new Avis((Timestamp) new Date(), commentaire, note, annonce, utilisateurComentateur));
	
}
		
		
		
		
	}

}
