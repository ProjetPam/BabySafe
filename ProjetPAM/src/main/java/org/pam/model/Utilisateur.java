package org.pam.model;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;


@Entity
public class Utilisateur implements Serializable {

	@Id
	@GeneratedValue
	private int numero;
	private String nom;
	private String prenom;
	private String email;
	private String password;
	private String photo;
	private String Adresse;
	private String telephone;
	private int nombre_points;
	
	
	private String Justificatif_domicile;
	private String piece_d_identite;
	//Motivatio pour garder les enfants
	private String Commentaire;
	//le rib

	
	
	
	
	//Mon solde de compte
	private Double solde;
	
	@OneToMany(mappedBy="utilisateur",fetch=FetchType.LAZY)
	private Collection<Enfant> enfant;
	
    @OneToMany(mappedBy="utilisateur",fetch=FetchType.LAZY)
	private Collection<Annonce> annonce;
	
    @OneToMany(mappedBy="utilisateur",fetch=FetchType.LAZY)
	private Collection<Annonce> avis;
    

    
    
    
    
	public Double getSolde() {
		return solde;
	}
	public void setSolde(Double solde) {
		this.solde = solde;
	}
	public Collection<Enfant> getEnfants() {
		return enfant;
	}
	public void setEnfants(Collection<Enfant> enfant) {
		this.enfant = enfant;
	}
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getNombre_points() {
		return nombre_points;
	}
	public void setNombre_points(int nombre_points) {
		this.nombre_points = nombre_points;
	}
	 @OneToMany(mappedBy="utilisateur")
	    private Collection<Reservation> reservations ;
	 
	public Collection<Enfant> getEnfant() {
		return enfant;
	}
	public void setEnfant(Collection<Enfant> enfant) {
		this.enfant = enfant;
	}
	public Collection<Annonce> getAnnonce() {
		return annonce;
	}
	public void setAnnonce(Collection<Annonce> annonce) {
		this.annonce = annonce;
	}
	public Collection<Reservation> getReservations() {
		return reservations;
	}
	public void setReservations(Collection<Reservation> reservations) {
		this.reservations = reservations;
	}
	public Utilisateur() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Utilisateur(String nom, String prenom, String email, String password) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.password = password;
	}
	public Collection<Annonce> getAnnonces() {
		return annonce;
	}
	public void setAnnonces(Collection<Annonce> annonce) {
		this.annonce = annonce;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	public String getAdresse() {
		return Adresse;
	}
	public void setAdresse(String adresse) {
		Adresse = adresse;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getJustificatif_domicile() {
		return Justificatif_domicile;
	}
	public void setJustificatif_domicile(String justificatif_domicile) {
		Justificatif_domicile = justificatif_domicile;
	}
	public String getPiece_d_identite() {
		return piece_d_identite;
	}
	public void setPiece_d_identite(String piece_d_identite) {
		this.piece_d_identite = piece_d_identite;
	}
	public String getCommentaire() {
		return Commentaire;
	}
	public void setCommentaire(String commentaire) {
		Commentaire = commentaire;
	}
	public Collection<Annonce> getAvis() {
		return avis;
	}
	public void setAvis(Collection<Annonce> avis) {
		this.avis = avis;
	}
	
	
	
	
	
}
