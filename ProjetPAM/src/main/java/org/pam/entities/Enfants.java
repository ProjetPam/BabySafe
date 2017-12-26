package org.pam.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Enfants implements Serializable{

	@Id
	@GeneratedValue
	private int numero ;
	private String nom ;
	private String prenom;
	private String niveau_etude;
	private String photo;
	private String age;
	private String maladie;
	@ManyToOne
	@JoinColumn(name="CODE_UTILISATEUR")
	private Utilisateurs utilisateur;
	
	
	
	
	
	public Enfants(String nom, String prenom, String niveau_etude,
			String photo, String age, String maladie) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.niveau_etude = niveau_etude;
		this.photo = photo;
		this.age = age;
		this.maladie = maladie;
	}
	public Enfants() {
		super();
		// TODO Auto-generated constructor stub
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
	public String getNiveau_etude() {
		return niveau_etude;
	}
	public void setNiveau_etude(String niveau_etude) {
		this.niveau_etude = niveau_etude;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getMaladie() {
		return maladie;
	}
	public void setMaladie(String maladie) {
		this.maladie = maladie;
	}
	
	
}
