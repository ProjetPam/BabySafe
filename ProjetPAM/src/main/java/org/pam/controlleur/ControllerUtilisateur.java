package org.pam.controlleur;

import org.pam.model.Utilisateur;
import org.pam.service.UtilisateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;



@Controller
public class ControllerUtilisateur {
	
	@Autowired
	private UtilisateurService utilisateurservice;
	
	
	
	@RequestMapping("/authentification")
	public String authentification(){
		
		return "Authentification";
	}
	
	@RequestMapping("/sinscrir")
	public String demandEnregistrer(){
		
		return "EnregistrementUtilisateur";
	}

	@RequestMapping("/enregistrer")
	public String enregistrer(Model model,String name,String lastname,String telephone,
			                  String email,String password,String passconf,String adresse,
			                  String Justi_domicile,String piece_d_identite,String photo){
		
		//if(password.equals(passconf)){
			
Utilisateur utilisateur=new Utilisateur(name, lastname, email, password, photo, adresse, telephone, 
		Justi_domicile, piece_d_identite);
utilisateurservice.enregistrement(utilisateur);
		//}
		
		return "EnregistrementUtilisateur";
	}
	
	
	@RequestMapping("/login")
	public String login(Model model,String password,
			                  String email){
		
       Utilisateur utilisateur =utilisateurservice.authentitication(email, password);
	if(utilisateur != null){
		return "ListeAnnonces";
	}
		
		return "Authentification";
	}
	
	
}
