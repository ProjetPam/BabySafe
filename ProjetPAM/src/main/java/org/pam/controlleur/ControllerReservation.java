package org.pam.controlleur;

import java.util.Date;

import org.pam.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ControllerReservation {

	@Autowired
	private ReservationService reservationService;
	
	
	@RequestMapping("/ListReservations")
	public String ListeReservation(Model model) {

		model.addAttribute("ListReservation", reservationService.getAllReservationByUtilisateur(1));
		
		return "MesReservation";
	}
	
	
	
	
}
