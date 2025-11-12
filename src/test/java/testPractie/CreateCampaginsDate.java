package testPractie;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class CreateCampaginsDate {

	public static void main(String[] args) {
		//step 1
		Date d = new Date();
		System.out.println(d);
		//step2
		SimpleDateFormat sim= new SimpleDateFormat("dd-MM-YYYY");
		String date = sim.format(d);
		System.out.println(date);
		// when we want to eg: departure date 
		Calendar cal = sim.getCalendar();
		 cal.add(Calendar.DAY_OF_MONTH, 3456);
		String ab = sim.format(cal.getTime());
		System.out.println(ab);
		     
	}

}

