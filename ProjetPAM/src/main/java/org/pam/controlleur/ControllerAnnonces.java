package org.pam.controlleur;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;

import javax.servlet.http.HttpSession;

import org.pam.model.Annonce;
import org.pam.model.Departement;
import org.pam.repository.RepositoryDepartement;
import org.pam.repository.RepositoryVille;
import org.pam.service.AnnonceService;
import org.pam.service.DepartementService;
import org.pam.service.EnfantService;
import org.pam.service.ReservationService;
import org.pam.service.UtilisateurService;
import org.pam.service.VilleService;
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
	
	@Autowired
	private DepartementService DepartementService;
	
	@Autowired
	private VilleService villeService;
	
	/* (non-Javadoc)
	 * @see org.pam.controlleur.IControllerAnnonce#ajouterAnnonce(org.springframework.ui.Model, java.util.Date, java.lang.String, java.lang.String, java.lang.String)
	 */
	
	@RequestMapping("/ajouterAnnonce")
	public String ajouterAnnonce(Model model,HttpSession session){
		//String idUtilisateur=session.getAttribute("idUtilisateur").;
		if(session.getAttribute("idUtilisateur") != null){
		model.addAttribute("listeDepartement", DepartementService.getallDepartement());
		model.addAttribute("listeVille", villeService.getAllVilles());
		return "AjouterAnnonce";
		}
		
		return "Authentification";
	}
	/* (non-Javadoc)
	 * @see org.pam.controlleur.IControllerAnnonce#addAnnonce(org.springframework.ui.Model, java.util.Date, java.lang.String, java.lang.String, java.lang.String)
	 */
	
	@RequestMapping("/AddAnnonce")
	public String addAnnonce(Model model,Date DateAnnonce,String heure_depart,String heure_fini,String statut,
			String description,Double prix,int nombreEnfant,boolean annanceGratuit,
			long idDepartement,long idVille,String complementAdresse,HttpSession session){
		try {
			
			int idUtilisateur=Integer.parseInt(session.getAttribute("idUtilisateur").toString());
			annonceService.ajouterAnnonce(DateAnnonce,heure_depart,heure_fini,"confirmee",
					 description,prix,nombreEnfant,annanceGratuit,
					 9,20,complementAdresse, idUtilisateur);
			//9 Id departement constant pour l'instant
	        //20Id Ville Besancon constant pour l'instant
		} catch (Exception e) {
			e.printStackTrace();		
		}
		
		return "AjouterAnnonce";
	}
	
	/* (non-Javadoc)
	 * @see org.pam.controlleur.IControllerAnnonce#ajouterAnnonce(org.springframework.ui.Model)
	 */
	
	@RequestMapping("/ListeAnnonces")
	public String ListeAnnonces(Model model) throws Exception{
		model.addAttribute("listAnnonce",annonceService.getAllAnnonces());
		return "ListeAnnonces";
	}
	
	
	
	/* (non-Javadoc)
	 * @see org.pam.controlleur.IControllerAnnonce#Reservation(org.springframework.ui.Model, int)
	 */
	
	
	@RequestMapping("/MesAnnonces")
	public String mesAnoonoces(Model model,HttpSession session) {
		if(session.getAttribute("idUtilisateur") != null){
		int idUtilisateur=Integer.parseInt(session.getAttribute("idUtilisateur").toString());
		model.addAttribute("mesAnnonces", annonceService.getAllAnoncesByUtilisateur(idUtilisateur));
		return "MesAnnonces";
		}
		return "Authentification";
		
	}
	
	
	@RequestMapping("/AnnulerAnnonce")
	public String AnnulerAnnonce(Model model,int idAnnonce,HttpSession session) {
		try {
			annonceService.annulerAnnonce(idAnnonce);
		} catch (Exception e) {
			e.printStackTrace();
		}
		int idUtilisateur=Integer.parseInt(session.getAttribute("idUtilisateur").toString());
		model.addAttribute("mesAnnonces", annonceService.getAllAnoncesByUtilisateur(idUtilisateur));
		
		return "MesAnnonces";
	}
	
	@RequestMapping("/RechercheAnnonce")
	public String RechercheAnnonce(Model model,String ville,String dateR) throws ParseException {
		String madate = dateR.replaceAll("-", "/") + " 00:00:00";
		
		Date reportDate = new Date(madate);
		
		model.addAttribute("listAnnonce",annonceService.getAllAnnceByDate(ville, reportDate));
		return "ListeAnnonces";
	}
	
	
	
	
}
