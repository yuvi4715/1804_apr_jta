package com.revature.projrctzero;

import java.util.Calendar;

import java.text.SimpleDateFormat;
import java.util.Scanner;

public class Question39Birthday {

	// //Write a method that takes a date of birth via Calendar object and returns
	// your age.
	// If it is your birthday, print the Happy Birthday song!

	public static void main(String[] args) throws Exception {

		// read inputs
		//
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Date of Birth(yyyy-mm-dd): ");
		String inputDate = sc.next();

		// parsing it as Calendar object
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Calendar dob = Calendar.getInstance();
		dob.setTime(sdf.parse(inputDate));

		// printing age
		System.out.println("Age is:" + getAge(dob));
		String hbdSong = "Happy Birthday to You, \nHappy Birthday to You,\nHappy Birthday Dear,\nHappy Birthday to You.";
		// printing happy birthday song.
		Calendar today = Calendar.getInstance();
		if ((today.get(Calendar.MONTH) == dob.get(Calendar.MONTH))
				&& (today.get(Calendar.DAY_OF_MONTH) == dob.get(Calendar.DAY_OF_MONTH))) {
			System.out.println(hbdSong);
		}
	}

	// Returns age given the date of birth
	public static int getAge(Calendar dob) throws Exception {
		Calendar today = Calendar.getInstance();
		int curYear = today.get(Calendar.YEAR);
		int dobYear = dob.get(Calendar.YEAR);
		int age = curYear - dobYear;

		// if dob is month or day is behind today's month or day
		// reduce age by 1
		int curMonth = today.get(Calendar.MONTH);
		int dobMonth = dob.get(Calendar.MONTH);
		if (dobMonth > curMonth) { // this year can't be counted!
			age--;
		} else if (dobMonth == curMonth) { // same month? check for day
			int curDay = today.get(Calendar.DAY_OF_MONTH);
			int dobDay = dob.get(Calendar.DAY_OF_MONTH);
			if (dobDay > curDay) { // this year can't be counted!
				age--;
			}
		}
		return age;
	}

}
