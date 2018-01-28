package org.pam.service.impl;
/*
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;*/

//import jnr.ffi.types.size_t;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.pam.repository.RepositoryStatistique;
import org.pam.service.StatistiqueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
//import org.springframework.web.bind.annotation.ResponseBody;

//import com.google.gson.JsonArray;
//import com.google.gson.JsonObject;

@Service
public class StatistiqueServiceImpl implements StatistiqueService {

	@Autowired
	private RepositoryStatistique repositoryStatistique;

	@Override
	public List<String> getStatistiqueParMois() {
		Calendar c = Calendar.getInstance();
		  int anneeEncours = c.get(Calendar.YEAR);
		  //JsonArray jsonarr = new JsonArray();
			
			System.out.println(anneeEncours);
			//HashMap<Integer, Double> statisticMonth = new HashMap<>();
			
			List<String> statisticMonth=new ArrayList<>();
			List<String> periodeAnneeEnCours = new ArrayList<>();
			
			for(int i=1;i<=9;i++){
				periodeAnneeEnCours.add(anneeEncours+"/0"+i+"/01");
				periodeAnneeEnCours.add(anneeEncours+"/0"+i+"/31");
			}
			for(int i=10;i<=12;i++){
				periodeAnneeEnCours.add(anneeEncours+"/"+i+"/01");
				periodeAnneeEnCours.add(anneeEncours+"/"+i+"/31");
			}
			for(int i=0;i< periodeAnneeEnCours.size() ;i=i+2){
				Date dat1 = new Date(periodeAnneeEnCours.get(i));
				Date dat2 = new Date(periodeAnneeEnCours.get(i+1));
				statisticMonth.add("Le benifice de mois de "+dat1.getMonth()+" est "+repositoryStatistique.getStatistiqueParMois(dat1,dat2)+" €");
				//statisticMonth.put(dat1.getMonth(), 
					//	repositoryStatistique.getStatistiqueParMois(dat1,dat2));
			}
		return statisticMonth;
	}
	
	/*
	@Override
	public @ResponseBody JsonObject getStatistiqueParMois() {
		 Calendar c = Calendar.getInstance();
		  int anneeEncours = c.get(Calendar.YEAR);
		  JsonArray jsonarr = new JsonArray();
			
			System.out.println(anneeEncours);
			HashMap<Integer, Double> statisticMonth = new HashMap<>();
			
			List<String> periodeAnneeEnCours = new ArrayList<>();
			
			for(int i=1;i<=9;i++){
				periodeAnneeEnCours.add(anneeEncours+"/0"+i+"/01");
				periodeAnneeEnCours.add(anneeEncours+"/0"+i+"/31");
			}
			for(int i=10;i<=12;i++){
				periodeAnneeEnCours.add(anneeEncours+"/"+i+"/01");
				periodeAnneeEnCours.add(anneeEncours+"/"+i+"/31");
			}
			for(int i=0;i< periodeAnneeEnCours.size() ;i=i+2){
				Date dat1 = new Date(periodeAnneeEnCours.get(i));
				Date dat2 = new Date(periodeAnneeEnCours.get(i+1));
				//statisticMonth.put(dat1.getMonth(), 
					//	repositoryStatistique.getStatistiqueParMois(dat1,dat2));
			}
			Iterator it = statisticMonth.entrySet().iterator();
		    while (it.hasNext()) {
		        Map.Entry pair = (Map.Entry)it.next();
		        System.out.println(pair.getKey() + " = " + pair.getValue());
		        JsonObject jsobj = new JsonObject();
				jsobj.addProperty("mois", (String) pair.getKey());
				jsobj.addProperty("Statistique", (String) pair.getValue());
				//jsobj.addProperty("absenceHQA", r.getAbsenceHQA());
				jsonarr.add(jsobj);
		    }
		    JsonObject jsonSend = new JsonObject();
			jsonSend.add("statistiqueAnne", jsonarr);
		
			return jsonSend;
	}
*/
}
