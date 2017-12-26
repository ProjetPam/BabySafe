package org.pam.entities;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

public class Annonces implements Serializable {

	private int numero_annonce;
	private Date date_annonce;
	private Timestamp heure_depart;
	private Timestamp heure_fini;
	private String description;
	
	
	
	
	
	public Annonces() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Annonces(Date date_annonce, Timestamp heure_depart,
			Timestamp heure_fini, String description) {
		super();
		this.date_annonce = date_annonce;
		this.heure_depart = heure_depart;
		this.heure_fini = heure_fini;
		this.description = description;
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
	
	
	
	
}
