package org.pam.repository;

import org.pam.entities.Utilisateurs;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositoryUtilisateurs extends JpaRepository<Utilisateurs, Integer> {

}
