package org.pam.model;



import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Id;

@Entity
public class Statistique {

	@Id
	@GeneratedValue
	private Long Id;
	
	@ManyToOne
	@JoinColumn(name = "idAnnonce")
	private Annonce annonce;
	
	private Date date_paeiment;
	
	private Double benefice;
	
	
	

	public Statistique(Annonce annonce, Date date_paeiment, Double benefice) {
		super();
		this.annonce = annonce;
		this.date_paeiment = date_paeiment;
		this.benefice = benefice;
	}

	public Statistique() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public Annonce getAnnonce() {
		return annonce;
	}

	public void setAnnonce(Annonce annonce) {
		this.annonce = annonce;
	}

	public Date getDate_paeiment() {
		return date_paeiment;
	}

	public void setDate_paeiment(Date date_paeiment) {
		this.date_paeiment = date_paeiment;
	}

	public Double getBenefice() {
		return benefice;
	}

	public void setBenefice(Double benefice) {
		this.benefice = benefice;
	}
	
	
	

}
