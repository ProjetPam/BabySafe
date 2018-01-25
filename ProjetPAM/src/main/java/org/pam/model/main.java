package org.pam.model;

import java.sql.Timestamp;
import java.util.Date;

import javax.servlet.http.HttpSession;

import org.apache.catalina.connector.Request;

public class main {

	public static void main(String[] args) {
	  Date ts1 =new Date();
		
	  Timestamp ts2 =new Timestamp(2018,01, 23, 17, 17, 18, 12);
		
		//ts2.getMinutes();
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
		 boolean exist = role.contains("simo");*/ //Renvoie true*/
		long diff =  ts1.getTime() - ts2.getTime() ;
		
             System.out.println(ts1.before(ts2));
	}
	
	
}
