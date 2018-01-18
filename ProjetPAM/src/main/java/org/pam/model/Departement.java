package org.pam.model;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;



@Entity
@Table(name="Departements")
public class Departement {

	@Id
	@GeneratedValue
	private long departement_id;
	private String departement_code;
	private String departement_nom;
	private String departement_nom_uppercase;
	private String departement_slug;
	private String departement_nom_soundex;
	
	@OneToMany(mappedBy = "departement" ,fetch=FetchType.LAZY)
	private Collection<Ville> villes;
	
	
	
	
	public Collection<Ville> getVilles() {
		return villes;
	}
	public void setVilles(Collection<Ville> villes) {
		this.villes = villes;
	}
	public Departement() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Departement(String departement_code, String departement_nom,
			String departement_nom_uppercase, String departement_slug,
			String departement_nom_soundex) {
		super();
		this.departement_code = departement_code;
		this.departement_nom = departement_nom;
		this.departement_nom_uppercase = departement_nom_uppercase;
		this.departement_slug = departement_slug;
		this.departement_nom_soundex = departement_nom_soundex;
	}
	public long getDepartement_id() {
		return departement_id;
	}
	public void setDepartement_id(long departement_id) {
		this.departement_id = departement_id;
	}
	public String getDepartement_code() {
		return departement_code;
	}
	public void setDepartement_code(String departement_code) {
		this.departement_code = departement_code;
	}
	public String getDepartement_nom() {
		return departement_nom;
	}
	public void setDepartement_nom(String departement_nom) {
		this.departement_nom = departement_nom;
	}
	public String getDepartement_nom_uppercase() {
		return departement_nom_uppercase;
	}
	public void setDepartement_nom_uppercase(String departement_nom_uppercase) {
		this.departement_nom_uppercase = departement_nom_uppercase;
	}
	public String getDepartement_slug() {
		return departement_slug;
	}
	public void setDepartement_slug(String departement_slug) {
		this.departement_slug = departement_slug;
	}
	public String getDepartement_nom_soundex() {
		return departement_nom_soundex;
	}
	public void setDepartement_nom_soundex(String departement_nom_soundex) {
		this.departement_nom_soundex = departement_nom_soundex;
	}
	
	
	
	
}
