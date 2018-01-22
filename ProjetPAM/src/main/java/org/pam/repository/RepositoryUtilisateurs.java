package org.pam.repository;

import org.pam.model.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface RepositoryUtilisateurs extends JpaRepository<Utilisateur, Integer> {

	@Query("select u from Utilisateur u where u.email =:y  and u.password =:x")
	public Utilisateur getLoginPASS(@Param("y")String email,@Param("x")String password);
	
}
