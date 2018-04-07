/*
 *  Author: Michael Sikorski
 *  Date: 4/6/18
 */

package advanced_coding_exercises;

import java.util.Calendar;

public class Question39 {

	public Question39() {
		
	}
	
	public double getAge(Calendar c) {
		int today_day = Calendar.getInstance().get(Calendar.DATE);
		int today_month = 1 + Calendar.getInstance().get(Calendar.MONTH);
		int today_year = Calendar.getInstance().get(Calendar.YEAR);
		int bday_day = c.get(Calendar.DATE);
		int bday_month = c.get(Calendar.MONTH);
		int bday_year = c.get(Calendar.YEAR);
		
		if (today_day == bday_day && today_month == bday_month) {
			happyBirthday();
		}
		
		int age = today_year - bday_year;
		
		if (today_month < bday_month || ((today_month == bday_month && today_day < bday_day))) {
			age--;	//birthday is coming up later this year
		}	
		return age;
	}
	
	public void happyBirthday() {
		System.out.println("Happy Birthday song");
	}
}
