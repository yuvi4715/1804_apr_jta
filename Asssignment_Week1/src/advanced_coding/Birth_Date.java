package advanced_coding;

import java.util.Calendar;

//Kevin Rivera - Revature
//Assignment Week 1: Advanced Coding: Problem 39.
//This class tells you your age when given a birth date. It also prints
//the happy birthday song if it is your birthday.

public class Birth_Date {
	public static void main(String[] args) {
		String age = getAge(1995, 4, 7);
		System.out.println("Your age is: " + age);
	}
	
	public static void hbdSong(){
		System.out.println("Happy birthday to you, happy birthday to you" +
					", happy birthday, happy birthday, happy birthday to YOUUUUUU!!!");
	}
	
	public static String getAge(int year, int month, int day) {
		//Get an instance of Calendar
		Calendar cal = Calendar.getInstance();
		boolean bd = false;
		
		//Check if today is the birthday! and set flag
		if ((month == cal.get(Calendar.MONTH) + 1) && (day == cal.get(Calendar.DAY_OF_MONTH)));{
			hbdSong();
			bd = true;
		}
		//Save current date in milliseconds
		long currentTime = cal.getTimeInMillis();
		//Set the calendar with the birth date
		cal.set(year, month, day);
		//Get time in milliseconds of birth date
		long birthDate = cal.getTimeInMillis();
		//Calculate age in milliseconds
		long age = currentTime - birthDate;
		//Assign that age to the calendar
		cal.setTimeInMillis(age);
		//Get number of years, months, and days
		int years = cal.get(Calendar.YEAR) - 1970; //- 1970 because that's when Epoch time started
		int months = cal.get(Calendar.MONTH) + 1; //+ 1 because January starts with 0
		int days = cal.get(Calendar.DAY_OF_MONTH);
		
		if (bd) {
			years++;
			months = 0;
			days = 0;
		}
		String ageString = years + " years, " + months + " months, " + days + " days.";
		
		return ageString;
	}
}
