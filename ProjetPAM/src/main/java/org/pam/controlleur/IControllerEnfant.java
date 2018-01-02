package org.pam.controlleur;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

public interface IControllerEnfant {

	public abstract String ajouterEnfant();

	public abstract String AddEnfant(Model model, String Nom, String Prénom,
			String NiveauEtud, String Age, String Maladie, String Photo);

}