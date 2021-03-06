package org.pam.repository;

import java.util.Collection;
import java.util.Date;

import org.pam.model.Statistique;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface RepositoryStatistique extends JpaRepository<Statistique,Long>{

	@Query("select sum(benefice)  from Statistique where date_paeiment between :x and :y ")
	public String getStatistiqueParMois(@Param("x")Date date1,@Param("y")Date date2);
	
	
	
}
