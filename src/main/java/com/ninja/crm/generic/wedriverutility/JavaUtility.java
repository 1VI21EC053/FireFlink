package com.ninja.crm.generic.wedriverutility;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class JavaUtility {

	public int randomNumber(int key) {

		Random r = new Random();
		int data = r.nextInt(key);
		return data;

	}

	public String getPresentDate() {
		Date d = new Date();
		SimpleDateFormat sim = new SimpleDateFormat("dd-MM-yyy");
		String date = sim.format(d);
		return date;

	}

	public String getFutureDate(int key) {
		Date d = new Date();
		SimpleDateFormat sim = new SimpleDateFormat("dd-MM-yyy");
		Calendar cal = sim.getCalendar();
		cal.add(Calendar.DAY_OF_MONTH, key);
		String data = sim.format(cal.getTime());
		return data;
	}
}