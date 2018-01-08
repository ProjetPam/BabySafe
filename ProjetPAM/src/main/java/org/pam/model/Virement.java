package org.pam.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Virement {

	@Id
	@GeneratedValue
	private Long Id;
	private Date dateVirement;
	private Double montant;
	
	@ManyToOne
	@JoinColumn(name="Id_Compte")
	private Compte compte;

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public Date getDateVirement() {
		return dateVirement;
	}

	public void setDateVirement(Date dateVirement) {
		this.dateVirement = dateVirement;
	}

	public Double getMontant() {
		return montant;
	}

	public void setMontant(Double montant) {
		this.montant = montant;
	}

	public Compte getCompte() {
		return compte;
	}

	public void setCompte(Compte compte) {
		this.compte = compte;
	}

	public Virement() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Virement(Date dateVirement, Double montant, Compte compte) {
		super();
		this.dateVirement = dateVirement;
		this.montant = montant;
		this.compte = compte;
	}
	
	
	
}
