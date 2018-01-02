package org.pam.repository;

import org.pam.model.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositoryUtilisateurs extends JpaRepository<Utilisateur, Integer> {

}
