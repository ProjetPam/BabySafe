package org.pam.model;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Annonce implements Serializable {

	@Id
	@GeneratedValue
	private int numero_annonce;
	private Date date_annonce;
	private Timestamp heure_depart;
	private Timestamp heure_fini;
	private String description;
	private int NombrEnfantGarde;
	private Double prix;
	private String statut;
	private Timestamp date_annulation;
	private boolean annonceGratuite;
	
	
	@ManyToOne
	@JoinColumn(name="CODE_UTILISATEUR")
	private Utilisateur utilisateur;
	
	@OneToMany(mappedBy="annonce",fetch=FetchType.LAZY)
	private Collection<Reservation> reservations;
	
	
	@OneToMany(mappedBy="annonce",fetch=FetchType.LAZY)
	private Collection<Statistique> statistiques;
	
	@OneToMany(mappedBy="annonce",fetch=FetchType.LAZY)
	private Collection<Avis> avis;
	
	
	
	public Annonce() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public Annonce(Date date_annonce, Timestamp heure_depart,
			Timestamp heure_fini, String description, Double prix,
			String statut,int nombrEnfantGarde,boolean annonceGratuite
			) {
		super();
		this.date_annonce = date_annonce;
		this.heure_depart = heure_depart;
		this.heure_fini = heure_fini;
		this.description = description;
		this.prix = prix;
		this.statut = statut;
		this.NombrEnfantGarde=nombrEnfantGarde;
		this.annonceGratuite=annonceGratuite;
		
		
	}


	public boolean isAnnonceGratuite() {
		return annonceGratuite;
	}


	public void setAnnonceGratuite(boolean annonceGratuite) {
		this.annonceGratuite = annonceGratuite;
	}


	public int getNombrEnfantGarde() {
		return NombrEnfantGarde;
	}


	public void setNombrEnfantGarde(int nombrEnfantGarde) {
		NombrEnfantGarde = nombrEnfantGarde;
	}


	public String getStatut() {
		return statut;
	}


	public void setStatut(String statut) {
		this.statut = statut;
	}


	public Timestamp getDate_annulation() {
		return date_annulation;
	}


	public void setDate_annulation(Timestamp date_annulation) {
		this.date_annulation = date_annulation;
	}


	public Collection<Reservation> getReservations() {
		return reservations;
	}


	public void setReservations(Collection<Reservation> reservations) {
		this.reservations = reservations;
	}


	public Collection<Statistique> getStatistiques() {
		return statistiques;
	}


	public void setStatistiques(Collection<Statistique> statistiques) {
		this.statistiques = statistiques;
	}


	public Collection<Avis> getAvis() {
		return avis;
	}


	public void setAvis(Collection<Avis> avis) {
		this.avis = avis;
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
