package org.pam.model;

import java.sql.Timestamp;
import java.util.Date;

public class main {

	public static void main(String[] args) {
	  Timestamp ts1 =new Timestamp(2017, 10, 10, 17, 17, 18, 12);
		
		Date ts2 = new Date();
		ts2.getMinutes();
/*
		  long milliseconds1 = ts1.getTime();
		  long milliseconds2 = ts2.getTime();

		  long diff = milliseconds1 - milliseconds2;
		  long diffSeconds = diff / 1000;
		  long diffMinutes = diff / (60 * 1000);
		  long diffHours = diff / (60 * 60 * 1000);
		  long diffDays = diff / (24 * 60 * 60 * 1000);
		  
		  Timestamp ts3 =new  Timestamp(new Date().getTime());
		  System.out.println(ts3);
		  
		 String role="operator est connecté avec le rôle operator";
		 boolean exist = role.contains("simo");*/ //Renvoie true
		//System.out.println(exist);
	}

}
