package org.pam.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;



@Entity
public class Ville {

	@Id
	@GeneratedValue
	private long idVille;
	private String nom_commune;
	private String codes_postaux;
	
	@ManyToOne
	@JoinColumn(name="Code_departement")
	private Departement departement;

	public long getIdVille() {
		return idVille;
	}

	public void setIdVille(long idVille) {
		this.idVille = idVille;
	}

	public String getNom_commune() {
		return nom_commune;
	}

	public void setNom_commune(String nom_commune) {
		this.nom_commune = nom_commune;
	}

	public String getCodes_postaux() {
		return codes_postaux;
	}

	public void setCodes_postaux(String codes_postaux) {
		this.codes_postaux = codes_postaux;
	}

	public Departement getDepartement() {
		return departement;
	}

	public void setDepartement(Departement departement) {
		this.departement = departement;
	}

	public Ville() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Ville(String nom_commune, String codes_postaux,
			Departement departement) {
		super();
		this.nom_commune = nom_commune;
		this.codes_postaux = codes_postaux;
		this.departement = departement;
	}
	
	
	
	
	
	
}
