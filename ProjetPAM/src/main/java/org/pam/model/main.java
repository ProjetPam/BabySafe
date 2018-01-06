package org.pam.model;

import java.sql.Timestamp;

public class main {

	public static void main(String[] args) {
		Timestamp ts1 =new Timestamp(2017, 10, 10, 17, 17, 18, 12);
		
		Timestamp ts2 =new Timestamp(2017, 10, 10, 19, 50, 18, 12);
		

		  long milliseconds1 = ts1.getTime();
		  long milliseconds2 = ts2.getTime();

		  long diff = milliseconds2 - milliseconds1;
		  long diffSeconds = diff / 1000;
		  long diffMinutes = diff / (60 * 1000);
		  long diffHours = diff / (60 * 60 * 1000);
		  long diffDays = diff / (24 * 60 * 60 * 1000);
		  System.out.println(5+2-1);
	

	}

}
