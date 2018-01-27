package org.pam.repository;

import java.util.Collection;

import org.pam.model.Avis;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface RepositoryAvis extends JpaRepository<Avis, Long> {

	@Query("select a FROM Avis a where a.annonce.numero_annonce =:x")
	Collection<Avis> getAllAvisByAnnonce(@Param("x")int idAnnonce);
	
	
}
