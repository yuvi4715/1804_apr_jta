package com.revature.questions38_45;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class Question39 {

	public static void main(String[] args) {
		
		Calendar dob = new GregorianCalendar(1993, 1, 2); //Year Month, Date
		System.out.println("Age: " + happyBirthday(dob));
		//test birthday
		Calendar dob2 = new GregorianCalendar(1993, 3, 7); //Months start at zero (Change birthday to today)
		System.out.println("Age: " + happyBirthday(dob2));
		
	}
	
	public static int happyBirthday(Calendar bDay) {

		Calendar today = Calendar.getInstance();
		
		//too lazy to clean and move
		if(bDay.get(Calendar.MONTH) == today.get(Calendar.MONTH) && 
				bDay.get(Calendar.DAY_OF_MONTH) == today.get(Calendar.DAY_OF_MONTH)) {
			System.out.println("Happy birthday to you!");
		}
	    int todayYear = today.get(Calendar.YEAR);
	    int bDayYear = bDay.get(Calendar.YEAR);
	    int todayDayOfYear = today.get(Calendar.DAY_OF_YEAR);
	    int bDayDayOfYear = bDay.get(Calendar.DAY_OF_YEAR);
	    int todayMonth = today.get(Calendar.MONTH);
	    int bDayMonth = bDay.get(Calendar.MONTH);
	    int todayDayOfMonth = today.get(Calendar.DAY_OF_MONTH);
	    int bDayDayOfMonth = bDay.get(Calendar.DAY_OF_MONTH);
	    int age = todayYear - bDayYear;
	    

		if(todayDayOfYear == bDayDayOfYear && todayMonth == bDayDayOfMonth) {
			System.out.println("Happy birthday to you!");
		}

	    if ((bDayDayOfYear - todayDayOfYear > 3) || (bDayMonth > todayMonth)){
	        age--;
	    } else if ((bDayMonth == todayMonth) && (bDayDayOfMonth > todayDayOfMonth)){
	        age--;
	    }
	    return age;
	}
}
