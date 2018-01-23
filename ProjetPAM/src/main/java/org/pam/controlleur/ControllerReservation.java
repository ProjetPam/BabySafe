package org.pam.controlleur;

import java.util.Date;

import javax.servlet.http.HttpSession;

import org.pam.service.AnnonceService;
import org.pam.service.EnfantService;
import org.pam.service.ReservationService;
import org.pam.service.UtilisateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ControllerReservation {

	@Autowired
	private ReservationService reservationService;
	
	@Autowired
    private AnnonceService annonceService;
	
	@Autowired
    private EnfantService enfantService;
	
	@Autowired
    private UtilisateurService utilisateurService;
	
	@Autowired
    private ReservationService reservationservice;
	
	@RequestMapping("/ListReservations")
	public String ListeReservation(Model model) {

		
		model.addAttribute("ListReservation", reservationService.getAllReservationByUtilisateur(1));
		
		return "MesReservation";
	}
	
	@RequestMapping("/Reservation")
	public String Reservation(Model model,int idAnnonce) throws Exception{
		model.addAttribute("nombrePoints", utilisateurService.getUtilisateurById(1));
		model.addAttribute("ListeEnfants",enfantService.getEnfantsByUtilisateur(1));
		model.addAttribute("Annonce",annonceService.getAnnonceByID(idAnnonce));
		return "Paiement";
	}
	
	
	@RequestMapping("/Paiement")
	public String paiement(Model model,int idenfant,int idAnnonce, Double prix,
			                           Integer poinUtiliser,String typePaiement,HttpSession session) {

		int idUtilisateur=Integer.parseInt(session.getAttribute("idUtilisateur").toString());
		reservationservice.PayerReservation(idAnnonce,idUtilisateur, idenfant, new Date(), prix, poinUtiliser,typePaiement);
		
		return "ListeAnnonces";
	}
	
	
	
	
}
