package org.pam.entities;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;


@Entity
public class Utilisateurs implements Serializable {

	@Id
	@GeneratedValue
	private int numero;
	private String nom;
	private String prenom;
	private String email;
	private String password;
	private int nombre_points;
	@OneToMany(mappedBy="utilisateur",fetch=FetchType.LAZY)
	private Collection<Enfants> enfants;
	
	public Collection<Enfants> getEnfants() {
		return enfants;
	}
	public void setEnfants(Collection<Enfants> enfants) {
		this.enfants = enfants;
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
	public Utilisateurs() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Utilisateurs(String nom, String prenom, String email, String password) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.password = password;
	}
	
	
	
}
