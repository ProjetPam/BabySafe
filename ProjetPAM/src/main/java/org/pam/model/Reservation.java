package org.pam.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Reservation {

	@Id
	@GeneratedValue
	private Long idReservation;
	private Date dateReservation;
	
	@ManyToOne
	@JoinColumn(name = "idUtilisateur")
	private Utilisateur utilisateur ;
	
	@ManyToOne
	@JoinColumn(name = "idEnfant")
	private Enfant enfant ;
	
	@ManyToOne
	@JoinColumn(name = "idAnnonce")
	private Annonce annonce ;
	
	
	public Annonce getAnnonce() {
		return annonce;
	}

	public void setAnnonce(Annonce annonce) {
		this.annonce = annonce;
	}
	private Double prix ;
	private Integer pointUtilise ;
	private String  statut;
	public Reservation() {
		super();
	}

	public Reservation(Date dateReservation, Utilisateur utilisateur, Enfant enfant, Double prix,
			Integer pointUtilise,Annonce annonce) {
		super();
		this.dateReservation = dateReservation;
		this.utilisateur = utilisateur;
		this.enfant = enfant;
		this.prix = prix;
		this.pointUtilise = pointUtilise;
		this.annonce=annonce;
	}
	
	public Long getIdReservation() {
		return idReservation;
	}
	public void setIdReservation(Long idReservation) {
		this.idReservation = idReservation;
	}
	public Date getDateReservation() {
		return dateReservation;
	}
	public void setDateReservation(Date dateReservation) {
		this.dateReservation = dateReservation;
	}
	public Utilisateur getUtilisateur() {
		return utilisateur;
	}
	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}
	public Enfant getEnfant() {
		return enfant;
	}
	public void setEnfant(Enfant enfant) {
		this.enfant = enfant;
	}
	public Double getPrix() {
		return prix;
	}
	public void setPrix(Double prix) {
		this.prix = prix;
	}
	public Integer getPointUtilise() {
		return pointUtilise;
	}
	public void setPointUtilise(Integer pointUtilise) {
		this.pointUtilise = pointUtilise;
	}

	public String getStatut() {
		return statut;
	}

	public void setStatut(String statut) {
		this.statut = statut;
	}
	
	
	
}
