package com.bhavcopy.web.util;

import java.text.SimpleDateFormat;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class CalculateDateMonthAndYear {

	public static void main(String[] args) {
		CalculateDateMonthAndYear cal = new CalculateDateMonthAndYear();
		cal.getLastMonth();		
	}
	
	public String getLastMonth(){
		Calendar c = new GregorianCalendar();
		c.setTime(new Date());
		SimpleDateFormat sdf = new SimpleDateFormat("MMMM YYYY");
		c.add(Calendar.MONTH, -1);

		return sdf.format(c.getTime());
	}
	

}
