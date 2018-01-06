package org.pam.controlleur;

import java.sql.Timestamp;
import java.util.Date;

import org.pam.model.Annonce;
import org.pam.service.AnnonceService;
import org.pam.service.EnfantService;
import org.pam.service.ReservationService;
import org.pam.service.UtilisateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.pam.model.Reservation;

@Controller
public class ControllerAnnonces  {

	@Autowired
    private AnnonceService annonceService;
	
	@Autowired
    private EnfantService enfantService;
	
	@Autowired
    private UtilisateurService utilisateurService;
	
	@Autowired
    private ReservationService reservationservice;
	
	/* (non-Javadoc)
	 * @see org.pam.controlleur.IControllerAnnonce#ajouterAnnonce(org.springframework.ui.Model, java.util.Date, java.lang.String, java.lang.String, java.lang.String)
	 */
	
	@RequestMapping("/ajouterAnnonce")
	public String ajouterAnnonce(Model model,Date DateAnnonce,String heure_depart,String heure_fini,String description,Double prix){
		
			
		return "AjouterAnnonce";
	}
	/* (non-Javadoc)
	 * @see org.pam.controlleur.IControllerAnnonce#addAnnonce(org.springframework.ui.Model, java.util.Date, java.lang.String, java.lang.String, java.lang.String)
	 */
	
	@RequestMapping("/AddAnnonce")
	public String addAnnonce(Model model,Date DateAnnonce,String heure_depart,String heure_fini,String statut,
			String description,Double prix,int nombreEnfant,boolean annanceGratuit){
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
			 Timestamp heuredepart =new Timestamp(DateAnnonce.getYear(),DateAnnonce.getMonth(),DateAnnonce.getDay() , heureDep, minuteDep,00,00);
			 Timestamp heurefin =new Timestamp(DateAnnonce.getYear(),DateAnnonce.getMonth(),DateAnnonce.getDay() , heureDep1, minuteFin1,00,00);
			   Annonce annonce=new Annonce(DateAnnonce, heuredepart, heurefin,description,prix,statut,nombreEnfant,annanceGratuit);
			
			annonceService.ajouterAnnonce(annonce, 1);
			
		} catch (Exception e) {
			e.printStackTrace();		
		}
		
		return "AjouterAnnonce";
	}
	
	/* (non-Javadoc)
	 * @see org.pam.controlleur.IControllerAnnonce#ajouterAnnonce(org.springframework.ui.Model)
	 */
	
	@RequestMapping("/ListeAnnonces")
	public String ajouterAnnonce(Model model) throws Exception{
		model.addAttribute("listAnnonce",annonceService.getAllAnnonces());
		return "ListeAnnonces";
	}
	
	
	
	/* (non-Javadoc)
	 * @see org.pam.controlleur.IControllerAnnonce#Reservation(org.springframework.ui.Model, int)
	 */
	
	@RequestMapping("/Reservation")
	public String Reservation(Model model,int idAnnonce) throws Exception{
		model.addAttribute("nombrePoints", utilisateurService.getUtilisateurById(1));
		model.addAttribute("ListeEnfants",enfantService.getEnfantsByUtilisateur(1));
		model.addAttribute("Annonce",annonceService.getAnnonceByID(idAnnonce));
		return "Paiement";
	}
	
	
	@RequestMapping("/Paiement")
	public String paiement(Model model,int idenfant,int idAnnonce, Double prix,Integer poinUtiliser,String typePaiement) {

		reservationservice.PayerReservation(idAnnonce, 1, idenfant, new Date(), prix, poinUtiliser,typePaiement);
		
		return "ListeAnnonces";
	}
	
	
}
