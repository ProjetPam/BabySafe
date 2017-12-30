package org.pam.controllers;

import java.sql.Timestamp;
import java.util.Date;

import org.pam.entities.Annonces;
import org.pam.metier.MetierAnnonces;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ControllerAnnonces {

	@Autowired
    private MetierAnnonces metierAnnonces;
	
	
	@RequestMapping("/ajouterAnnonce")
	public String ajouterAnnonce(Model model,Date DateAnnonce,String heure_depart,String heure_fini,String description){
		
			
		return "AjouterAnnonce";
	}
	@RequestMapping("/AddAnnonce")
	public String addAnnonce(Model model,Date DateAnnonce,String heure_depart,String heure_fini,String description){
		try {
			//Date datAnn = new Date() ;
			
			//Timestamp ts2 =new Timestamp(2017, 10, 10, 17, 17, 18, 12);
			String desc = "TOTO" ;
			//12:23
			Timestamp ts1 = null ;
			int heureDep = Integer.valueOf(heure_depart.substring(0, 2));
			int minuteDep = Integer.valueOf(heure_depart.substring(3, 5));
			int heureDep1 = Integer.valueOf(heure_fini.substring(0, 2));
			int minuteFin1 = Integer.valueOf(heure_fini.substring(3, 5));
			 Timestamp heuredepart =new Timestamp(0000, 00, 00, heureDep, minuteDep,00,00);
			 Timestamp heurefin =new Timestamp(2000, 00, 00, heureDep1, minuteFin1,00,00);
			   Annonces annonce=new Annonces(DateAnnonce, heuredepart, heurefin, description);
			//Annonces annonce=new Annonces(datAnn, ts1, ts2, desc);
			metierAnnonces.ajouterAnnonce(annonce, 1);
			
		} catch (Exception e) {
			e.printStackTrace();		
		}
		
		return "AjouterAnnonce";
	}
	
	@RequestMapping("/ListeAnnonces")
	public String ajouterAnnonce(Model model){
		model.addAttribute("listAnnonce",metierAnnonces.getAllAnnonces());
		return "ListeAnnonces";
	}
	
	
	
	@RequestMapping("/Reservation")
	public String Reservation(Model model,int idAnnonce){
		model.addAttribute("Annonce",metierAnnonces.getAnnonceByID(idAnnonce));
		return "Paiement";
	}
	
	
}
