package com.revature.advancedcodingexercises;

import java.util.Calendar;

public class Age {
	int age;


	public static void main(String[] args) {
		/*
		 * 39. Write a method that takes a date of birth via Calendar object and returns
		 * your age. If it is your birthday, print the Happy Birthday song!
		 */

		Age yourAge = new Age();
		yourAge.generateAge();
	}
	
	int generateAge() {
		Calendar current = Calendar.getInstance();
		current.set(2018, 3, 5);
		int currentyear = current.get(Calendar.YEAR);
		int currentmonth = current.get(Calendar.MONTH);
		int currentday = current.get(Calendar.DAY_OF_MONTH);
		Calendar dob = Calendar.getInstance();
		dob.set(1995, 1, 1);
		int dobyear = dob.get(Calendar.YEAR);
		int dobmonth = dob.get(Calendar.MONTH);
		int dobday = dob.get(Calendar.DAY_OF_MONTH);
		if (currentmonth == dobmonth & currentday == dobday)
			System.out.println("Happy Birthday to You");
		age = currentyear - dobyear;
		if (currentmonth >= dobmonth) {
			age = age - 1;
			if (currentmonth == dobmonth & currentday >= dobday )
				age = age + 1;
		}
		System.out.println("You are "+ age +" years old.");
		return age;
	}


}
