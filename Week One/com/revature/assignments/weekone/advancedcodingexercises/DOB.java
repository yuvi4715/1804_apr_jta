/**
 * 
 */
package com.revature.assignments.weekone.advancedcodingexercises;

import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

import sun.util.resources.CalendarData;

/**
 * @author Ed M
 * @date Apr 5, 2018
 * @time time 4:42:41 PM
 */
public class DOB {

	/**
	 * 
	 */
	public DOB() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	// class Calender{
	//
	// private int year ;
	// private int month;
	// private int day;
	// Calender(int year, int month, int day){
	// this.year = year;
	// this.month = month;
	// this.day = day;
	// }
	// public int getYear() {
	// return year;
	// }
	// public int getMonth() {
	// return month;
	// }
	// public int getDay() {
	// return day;
	// }
	//
	//
	// }

	@SuppressWarnings("deprecation")
	public static int getAge(Calendar dOB, Date today) {

		int yearDiff = (today.getYear() + 1900) - dOB.get(Calendar.YEAR);
		if (today.getMonth() < dOB.get(Calendar.MONTH)) {
			return yearDiff--;
		}else if ((today.getMonth() > dOB.get(Calendar.MONTH)) && (today.getDay() > dOB.get(Calendar.DAY_OF_MONTH))) {
			return yearDiff;
		}else if ((today.getMonth() == dOB.get(Calendar.MONTH)) && (today.getDay() == dOB.get(Calendar.DAY_OF_MONTH))) {
			System.out.println("Happy Brithday Song...");
			return yearDiff;
		}
		return -1;

	}

	public static void main(String[] args) {
		// System.out.println("Today's date: Year , Month, Day");
		// Scanner sc = new Scanner(System.in);
		// int year = sc.nextInt();
		// int month = sc.nextInt();
		// int day = sc.nextInt();
		// String s = sc.nextLine();
		Date today = Calendar.getInstance().getTime();

		System.out.println("Your Brithday date: Year , Month, Day");
		Scanner newsc = new Scanner(System.in);
		int year = newsc.nextInt();
		int month = newsc.nextInt();
		int day = newsc.nextInt();
		String nothing = newsc.nextLine();
		Calendar dob = Calendar.getInstance();
		dob.set(year, month, day);
		// System.out.print(today.getYear()+1900);
		
		System.out.println(today.getMonth());
		System.out.println(dob.get(Calendar.MONTH));
		System.out.print(getAge(dob, today));

	}

}
