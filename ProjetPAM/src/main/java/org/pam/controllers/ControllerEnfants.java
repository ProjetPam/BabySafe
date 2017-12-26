package org.pam.controllers;

import org.pam.metier.MetierEnfants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ControllerEnfants {

	@Autowired
	private MetierEnfants metierEnfants;
	
	@RequestMapping("/ajouterEnfant")
	public String  ajouterEnfant(){
		
		return "templates/AjouterEnfant";
	}
	
	
	
}
