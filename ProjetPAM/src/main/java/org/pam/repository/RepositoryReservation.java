package org.pam.repository;

import java.util.Collection;


import org.pam.model.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface RepositoryReservation  extends JpaRepository<Reservation, Long>{

	@Query("select r from Reservation r join  r.utilisateur u  where u.numero=:x and r.statut='encours' ORDER BY r.dateReservation DESC")
	public Collection<Reservation> getAllReservationByUtilisateur(@Param("x") int idutilisateur);
	
	@Query("select r from Reservation r join  r.annonce a  where a.numero_annonce =:x")
	public Collection<Reservation> getAllReservationByAnnonce(@Param("x") int idAnnonce);
	
	@Query("select r from Reservation r  where r.annonce.utilisateur.numero=:x ")
	public Collection<Reservation> getHistoriqueReservationByUtilisateur(@Param("x") int idutilisateur);
	
	
	@Query("select r from Reservation r  where r.annonce.utilisateur.numero=:x and r.statut ='confirmee' ")
	public Collection<Reservation> getReservationConfirmer(@Param("x") int idutilisateur);
}
