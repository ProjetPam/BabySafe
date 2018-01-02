package org.pam.repository;

import java.util.Collection;

import org.pam.model.Enfant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface RepositoryEnfants extends JpaRepository<Enfant,Integer> {

	@Query("select e from Enfant e join  e.utilisateur u  where u.numero=:x")
	public Collection<Enfant> getAllenfantsByutilisateur(@Param("x") int idutilisateur);
	
	
	
}
