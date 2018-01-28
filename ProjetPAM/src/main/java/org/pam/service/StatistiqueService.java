package org.pam.service;

import java.util.Date;
import java.util.List;

import org.springframework.web.bind.annotation.ResponseBody;

//import com.google.gson.JsonObject;



public interface StatistiqueService {

	//public @ResponseBody JsonObject getStatistiqueParMois();
	public List<String>  getStatistiqueParMois();
	public List<String>  getStatistiqueParAnne(long annee);
}
