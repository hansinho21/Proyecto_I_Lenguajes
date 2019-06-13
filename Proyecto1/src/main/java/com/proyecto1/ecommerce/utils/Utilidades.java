package com.proyecto1.ecommerce.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Utilidades {

	public static String getCurrentTimeUsingDate() {
	     Date date = new Date();
	     String strDateFormat = "dd/MM/yy ";
	     DateFormat dateFormat = new SimpleDateFormat(strDateFormat);
	     String formattedDate= dateFormat.format(date);
	     Date date1= new Date();
	     try {
			 date1=new SimpleDateFormat("dd/MM/yyyy").parse(formattedDate);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    return formattedDate;
	 }
	
}
