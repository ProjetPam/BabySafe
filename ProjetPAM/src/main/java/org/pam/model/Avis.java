package org.pam.model;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;



@Entity
public class Avis  {

	@Id
	@GeneratedValue
	private Long id;
	private Timestamp date_avis;
	private String commentaire;
	private int note;
	@ManyToOne
	@JoinColumn(name="idAnnonce")
	private Annonce annonce;
	
	@ManyToOne
	@JoinColumn(name="CODE_UTILISATEUR")
	private Utilisateur utilisateur;

	
	public Avis() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Avis(Timestamp date_avis, String commentaire, int note,
			Annonce annonce, Utilisateur utilisateur) {
		super();
		this.date_avis = date_avis;
		this.commentaire = commentaire;
		this.note = note;
		this.annonce = annonce;
		this.utilisateur = utilisateur;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Timestamp getDate_avis() {
		return date_avis;
	}

	public void setDate_avis(Timestamp date_avis) {
		this.date_avis = date_avis;
	}

	public String getCommentaire() {
		return commentaire;
	}

	public void setCommentaire(String commentaire) {
		this.commentaire = commentaire;
	}

	public int getNote() {
		return note;
	}

	public void setNote(int note) {
		this.note = note;
	}

	public Annonce getAnnonce() {
		return annonce;
	}

	public void setAnnonce(Annonce annonce) {
		this.annonce = annonce;
	}

	public Utilisateur getUtilisateur() {
		return utilisateur;
	}

	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}
	
	
	
	
	
	
}
