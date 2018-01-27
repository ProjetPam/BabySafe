package org.pam.controlleur;

import java.util.Date;

import javax.servlet.http.HttpSession;

import org.pam.model.Annonce;
import org.pam.model.Utilisateur;
import org.pam.service.AnnonceService;
import org.pam.service.AvisService;
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
	
	@Autowired
	private AvisService avisService;
	
	@RequestMapping("/ListReservations")
	public String ListeReservation(Model model,HttpSession session) {
		if(session.getAttribute("idUtilisateur") != null){
		int idUtilisateur=Integer.parseInt(session.getAttribute("idUtilisateur").toString());
		model.addAttribute("ListReservation", reservationService.getAllReservationByUtilisateur(idUtilisateur));
		return "MesReservation";
		}
		
		return "Authentification";
	}
	
	
	
	
	@RequestMapping("/Reservation")
	public String Reservation(Model model,int idAnnonce,HttpSession session) throws Exception{
		if(session.getAttribute("idUtilisateur") != null){
		int idUtilisateur=Integer.parseInt(session.getAttribute("idUtilisateur").toString());
		
		model.addAttribute("nombrePoints", utilisateurService.getUtilisateurById(idUtilisateur));
		model.addAttribute("ListeEnfants",enfantService.getEnfantsByUtilisateur(idUtilisateur));
		model.addAttribute("Annonce",annonceService.getAnnonceByID(idAnnonce));
		return "Paiement";}
		return "Authentification";
	}
	
	
	@RequestMapping("/annulerReservation")
	public String annulerReservation(Model model,int idReservation,HttpSession session) throws Exception{
		
		int idUtilisateur=Integer.parseInt(session.getAttribute("idUtilisateur").toString());
		
		reservationservice.annulerReservation(1, idReservation, idUtilisateur);
		return "MesReservation";
	}
	
	@RequestMapping("/Paiement")
	public String paiement(Model model,int idenfant,int idAnnonce, Double prix,
			                           Integer poinUtiliser,String typePaiement,HttpSession session) {

		int idUtilisateur=Integer.parseInt(session.getAttribute("idUtilisateur").toString());
		reservationservice.PayerReservation(idAnnonce,idUtilisateur, idenfant, new Date(), prix, poinUtiliser,typePaiement);
		
		return "ListeAnnonces";
	}
	
	@RequestMapping("/HistoriqueReservations")
	public String HistoriqueReservations(Model model,HttpSession session) {

		if(session.getAttribute("idUtilisateur") != null){
		int idUtilisateur=Integer.parseInt(session.getAttribute("idUtilisateur").toString());
		
		model.addAttribute("ListReservation", reservationService.getHistoriqueReservationByUtilisateur(idUtilisateur));
		model.addAttribute("SommeVerser",reservationService.getArgentVerser(idUtilisateur));
		return "Argents";
		}
		return "Authentification";
	}
	
	
	
	
	@RequestMapping("/Avis")
	public String Avis(Model model,HttpSession session) {

		int idUtilisateur=Integer.parseInt(session.getAttribute("idUtilisateur").toString());
		model.addAttribute("ListReservation", reservationService.getReservationConfirmeeByUtilisateur(idUtilisateur));
		
		return "Avis";
	}
	
	@RequestMapping("/DonnerAvis")
	public String donerAvis(Model model,HttpSession session,int idAnnonce) throws Exception {

		if(session.getAttribute("idUtilisateur") != null){
		model.addAttribute("Annonce", annonceService.getAnnonceByID(idAnnonce));
		model.addAttribute("allAvis", avisService.getAvisByannonce(idAnnonce));
		return "AjouterAvis";
		}
		return "Authentification";
	}
	
	@RequestMapping("/addAvis")
	public String addAvis(Model model,HttpSession session,int idAnnonce
			,String comment,int note) throws Exception {

		if(session.getAttribute("idUtilisateur") != null){
		int idUtilisateur=Integer.parseInt(session.getAttribute("idUtilisateur").toString());
		
		Annonce annonce=annonceService.getAnnonceByID(idAnnonce);
		Utilisateur utilisateur=utilisateurService.getUtilisateurById(idUtilisateur);
		avisService.addAvis(utilisateur,annonce,comment, note);
		return "AjouterAvis";
		}
		
		return "Authentification";
	}
	
	
}
