package org.pam.controllers;

import org.pam.entities.Enfants;
import org.pam.metier.MetierEnfants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ControllerEnfants {

	@Autowired
	private MetierEnfants metierEnfants;
	
	@RequestMapping("/ajouterEnfant")
	public String  ajouterEnfant(){
		
		return "AjouterEnfant";
	}
	@RequestMapping("/AddEnfant")
	public String  AddEnfant(Model model,String Nom ,String Prénom,String NiveauEtud,String Age,String Maladie,String Photo){
		
		Enfants enfant=new Enfants(Nom, Prénom, NiveauEtud, Photo, Age, Maladie);
		
		
		metierEnfants.ajouterEnfants(enfant, 1);
		
		return "AjouterEnfant";
	}
	
	
}
