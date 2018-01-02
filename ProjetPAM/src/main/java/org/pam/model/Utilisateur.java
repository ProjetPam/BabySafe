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
	private int nombre_points;
	@OneToMany(mappedBy="utilisateur",fetch=FetchType.LAZY)
	private Collection<Enfant> enfant;
	
    @OneToMany(mappedBy="utilisateur",fetch=FetchType.LAZY)
	private Collection<Annonce> annonce;
	
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
	
	
	
	
	
}
