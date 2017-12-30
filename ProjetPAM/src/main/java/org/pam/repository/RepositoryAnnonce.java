package org.pam.repository;

import java.util.Collection;

import org.pam.entities.Annonces;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
public interface RepositoryAnnonce  extends JpaRepository<Annonces,Integer>{

	@Query("select o from Annonces o")
	public Collection<Annonces> getAllAnonces();
	

}
