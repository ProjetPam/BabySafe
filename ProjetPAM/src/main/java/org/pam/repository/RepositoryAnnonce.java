package org.pam.repository;

import java.util.Collection;

import org.pam.model.Annonce;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
public interface RepositoryAnnonce  extends JpaRepository<Annonce,Integer>{

	@Query("select o from Annonce o where o.statut='confirmee'")
	public Collection<Annonce> getAllAnonces();
	
	@Query("select o from Annonce o  join  o.utilisateur u where u.numero=:x")
	public Collection<Annonce> getAllAnoncesByUtilisateur(@Param("x")int idUtilisateur);
	
}
