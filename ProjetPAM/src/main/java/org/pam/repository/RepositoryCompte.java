package org.pam.repository;

import org.pam.model.Compte;
import org.pam.model.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface RepositoryCompte extends JpaRepository<Compte, Long> {

	@Query("select o from Compte o where o.utilisateur =:x ")
	public Compte getCompteUtilisateur(@Param("x") Utilisateur utilisateur);
	
}
