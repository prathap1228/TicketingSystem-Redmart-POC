package com.redmart.util;

import java.util.Calendar;
import java.util.TimeZone;

/**
 * 
 * @author prathap
 *
 */
public class DateUtil {

	public static String getWelcomeMessageBasedOnTime() {
		Calendar currentTimeCalendar = Calendar.getInstance();
		currentTimeCalendar.setTimeZone(TimeZone.getTimeZone("IST"));
		int hourOfDay = currentTimeCalendar.get(Calendar.HOUR_OF_DAY);
		if(hourOfDay > 5 && hourOfDay < 12)
			return "Good Morning";
		else if(hourOfDay >= 12 && hourOfDay < 17)
			return "Good Afternoon";
		else if(hourOfDay >= 17 && hourOfDay < 21)
			return "Good Evening";
		else
			return "Good Night";
	}
}
