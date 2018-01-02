package org.pam.repository;

import java.util.Collection;

import org.pam.model.Annonce;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
public interface RepositoryAnnonce  extends JpaRepository<Annonce,Integer>{

	@Query("select o from Annonce o")
	public Collection<Annonce> getAllAnonces();
	

}
