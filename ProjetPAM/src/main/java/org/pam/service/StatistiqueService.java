package org.pam.service;

import java.util.Date;

import org.springframework.web.bind.annotation.ResponseBody;

//import com.google.gson.JsonObject;



public interface StatistiqueService {

	//public @ResponseBody JsonObject getStatistiqueParMois();
	public Double  getStatistiqueParMois();
}
