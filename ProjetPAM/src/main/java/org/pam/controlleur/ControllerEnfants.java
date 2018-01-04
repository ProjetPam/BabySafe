package org.pam.controlleur;

import org.pam.model.Enfant;
import org.pam.service.EnfantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ControllerEnfants  {

	@Autowired
	private EnfantService enfantService;
	
	/* (non-Javadoc)
	 * @see org.pam.controlleur.IControllerEnfant#ajouterEnfant()
	 */
	
	@RequestMapping("/ajouterEnfant")
	public String  ajouterEnfant(){
		
		return "AjouterEnfant";
	}
	/* (non-Javadoc)
	 * @see org.pam.controlleur.IControllerEnfant#AddEnfant(org.springframework.ui.Model, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String)
	 */
	
	@RequestMapping("/AddEnfant")
	public String  AddEnfant(Model model,String Nom ,String Prénom,String NiveauEtud,String Age,String Maladie,String Photo){
		
		Enfant enfant=new Enfant(Nom, Prénom, NiveauEtud, Photo, Age, Maladie);
		
		
		enfantService.ajouterEnfants(enfant, 1);
		
		return "AjouterEnfant";
	}
	
	
}
