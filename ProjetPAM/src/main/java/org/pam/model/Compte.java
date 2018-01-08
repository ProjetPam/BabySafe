package org.pam.model;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Compte {

	@Id
	@GeneratedValue
	private Long id;
	
	@OneToOne
	@JoinColumn(name="ID_Utilisateur",referencedColumnName="numero"
			)
	private Utilisateur utilisateur;
	private String  nomAgence;
	private String Iban;
	private String bic;
	
	@OneToMany(mappedBy="compte")
	private Collection<Virement> virements;
	
	
	public Compte(Utilisateur utilisateur, String nomAgence, String iban,
			String bic) {
		super();
		this.utilisateur = utilisateur;
		this.nomAgence = nomAgence;
		Iban = iban;
		this.bic = bic;
	}
	public Compte() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Utilisateur getUtilisateur() {
		return utilisateur;
	}
	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}
	public String getNomAgence() {
		return nomAgence;
	}
	public void setNomAgence(String nomAgence) {
		this.nomAgence = nomAgence;
	}
	public String getIban() {
		return Iban;
	}
	public void setIban(String iban) {
		Iban = iban;
	}
	public String getBic() {
		return bic;
	}
	public void setBic(String bic) {
		this.bic = bic;
	}
	
	
	
	
	
	
	
}
