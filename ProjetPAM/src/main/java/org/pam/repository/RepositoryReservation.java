package org.pam.repository;

import org.pam.model.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositoryReservation  extends JpaRepository<Reservation, Long>{

}
