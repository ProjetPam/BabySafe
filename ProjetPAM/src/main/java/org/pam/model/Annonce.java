package org.pam.model;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Annonce implements Serializable {

	@Id
	@GeneratedValue
	private int numero_annonce;
	private Date date_annonce;
	private Timestamp heure_depart;
	private Timestamp heure_fini;
	private String description;
	private Double prix;
	
	@ManyToOne
	@JoinColumn(name="CODE_UTILISATEUR")
	private Utilisateur utilisateur;
	
	
	
	
	
	public Annonce() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Annonce(Date date_annonce, Timestamp heure_depart,
			Timestamp heure_fini, String description,Double prix) {
		super();
		this.date_annonce = date_annonce;
		this.heure_depart = heure_depart;
		this.heure_fini = heure_fini;
		this.description = description;
		this.prix=prix;
	}
	
	public Double getPrix() {
		return prix;
	}
	public void setPrix(Double prix) {
		this.prix = prix;
	}
	public int getNumero_annonce() {
		return numero_annonce;
	}
	public void setNumero_annonce(int numero_annonce) {
		this.numero_annonce = numero_annonce;
	}
	public Date getDate_annonce() {
		return date_annonce;
	}
	public void setDate_annonce(Date date_annonce) {
		this.date_annonce = date_annonce;
	}
	public Timestamp getHeure_depart() {
		return heure_depart;
	}
	public void setHeure_depart(Timestamp heure_depart) {
		this.heure_depart = heure_depart;
	}
	public Timestamp getHeure_fini() {
		return heure_fini;
	}
	public void setHeure_fini(Timestamp heure_fini) {
		this.heure_fini = heure_fini;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Utilisateur getUtilisateur() {
		return utilisateur;
	}
	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}
	
	
	
	
	
}
