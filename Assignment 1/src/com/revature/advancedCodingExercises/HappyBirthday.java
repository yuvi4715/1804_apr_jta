package com.revature.advancedCodingExercises;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class HappyBirthday {
	//problem 39
	
	public int birthday(String year, String month, String day) {
		DateFormat yearFormat = new SimpleDateFormat("yyyy");
		DateFormat monthFormat = new SimpleDateFormat("MM");
		DateFormat dayFormat = new SimpleDateFormat("dd");
		Calendar cal = Calendar.getInstance();
		
		int currentYear = Integer.parseInt(yearFormat.format(cal.getTime()));
		int currentMonth = Integer.parseInt(monthFormat.format(cal.getTime()));
		int currentDay = Integer.parseInt(dayFormat.format(cal.getTime()));
		
		int birthDay = Integer.parseInt(day);
		int birthMonth = Integer.parseInt(month);
		int birthYear = Integer.parseInt(year);
		
		int age;
		
		
		if (birthYear <= currentYear && birthMonth <= currentMonth && birthDay < currentDay) {
			age = currentYear - 1 - birthYear;
		}
		else {
			age = currentYear - birthYear;
		}
		
		if (currentMonth == birthMonth && currentDay == birthDay) {
			System.out.println("Happy birthday to you, happy birthday to you, happy birthday dear someone, happy birthday to you!");
		}

		return age;
	}
	
	
	public static void main(String[] args) {
		HappyBirthday hbd = new HappyBirthday();
		System.out.println(hbd.birthday("2000","04","06"));
	}
}
