package org.pam.controllers;

import java.io.Serializable;

public class test implements Serializable {
	public static void main (String []args){
		String heure = "12:30" ;
		System.out.println(Integer.valueOf(heure.substring(0, 2)));
		System.out.println(Integer.valueOf(heure.substring(3, 5)));
	}
}
