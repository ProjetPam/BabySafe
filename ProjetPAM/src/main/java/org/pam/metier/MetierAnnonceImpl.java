package org.pam.metier;

import java.util.Collection;

import org.pam.entities.Annonces;
import org.pam.entities.Utilisateurs;
import org.pam.repository.RepositoryAnnonce;
import org.pam.repository.RepositoryUtilisateurs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MetierAnnonceImpl implements MetierAnnonces  {

	@Autowired
	private RepositoryUtilisateurs repositoryutilisateurs;
	
	@Autowired
	private RepositoryAnnonce repositoryannonce;
	
	@Override
	public void ajouterAnnonce(Annonces annonce, int idUtilisateur) {

	Utilisateurs utilisateurs=repositoryutilisateurs.findOne(idUtilisateur);
	annonce.setUtilisateur(utilisateurs);
	
	repositoryannonce.save(annonce);
		
	}

	@Override
	public Collection<Annonces> getAllAnnonces() {
		return repositoryannonce.getAllAnonces();
	}

	@Override
	public Annonces getAnnonceByID(int id) {
		
		return repositoryannonce.findOne(id);
	}

}
