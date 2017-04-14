package com.tcs.utility;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtility {
	public static Date getDate(String source,String formate)
	{
		Date date=null;
		SimpleDateFormat df = new SimpleDateFormat(formate);
		try {
			date=df.parse(source);
			System.out.println(date);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return date;
		
	}
	
	public static int daysBetween(Date d1, Date d2){
		 return (int)( (d2.getTime() - d1.getTime()) / (1000 * 60 * 60 * 24));
		 }

}
