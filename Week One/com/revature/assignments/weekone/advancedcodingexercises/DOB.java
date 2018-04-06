/**
 * 
 */
package com.revature.assignments.weekone.advancedcodingexercises;

import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

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
	public static int getAge(Calendar dOB, Calendar todayC) {
		
	
		
		System.out.println(dOB.get(Calendar.MONTH));
		System.out.println(dOB.get(Calendar.DAY_OF_MONTH));
		
		System.out.println(todayC.get(Calendar.MONTH));
		System.out.println(todayC.get(Calendar.DAY_OF_MONTH));
		
		
		
		
		long current = todayC.getTimeInMillis();
		long brith = dOB.getTimeInMillis();
		
		long age = (TimeUnit.MILLISECONDS.toDays(Math.abs(brith-current))/365);
		int yearDiff = (int)age;
		if ((dOB.get(Calendar.MONTH) == todayC.get(Calendar.MONTH)) && (todayC.get(Calendar.DAY_OF_MONTH) == dOB.get(Calendar.DAY_OF_MONTH)))
			System.out.println("Happy Brithday Song...");
		return yearDiff;
		
//		int dmonth = dOBCalendar.DAY_OF_MONTH;
//		dmonth++;
//		int dday  = dOB.get(Calendar.DAY_OF_MONTH);
//		dday++;
//		//System.out.println((today.getYear() +1900 ) +" - "+ (dOB.get(Calendar.YEAR)));
//		int yearDiff = ((today.getYear() + 1900) - (dOB.get(Calendar.YEAR)));
//		System.out.println(yearDiff);
//		System.out.println(today.getMonth()+" - "+dmonth);
//		if (((today.getMonth()) <= dmonth) && ((today.getDay()) < dday)) {
//			System.out.println("Beep 1 ");
//			return --yearDiff;
//		}else if ((today.getMonth() >= dmonth) && ((today.getDay()) > dday)) {
//			System.out.println(today.getMonth()+" - "+dmonth);
//			System.out.println("Beep 2 ");
//			return yearDiff;
//		}else if ((today.getMonth() == dmonth) && (today.getDay() == dday)) {
//			System.out.println("Happy Brithday Song...");
//			return yearDiff;
//		}else
//return -1;

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
		Calendar todayC = Calendar.getInstance();
		todayC.setTime(today);
		month--;
		//day++;
		dob.set(year, month, day);
		// System.out.print(today.getYear()+1900);
//		
//		System.out.println(today.getMonth());
//		System.out.println(today.getDay());
//		System.out.println(today.getYear()+1900);
//		System.out.println((dob.get(Calendar.YEAR)+0));
//		System.out.println(dob.get(Calendar.MONTH));
//		System.out.println(dob.get(Calendar.DAY_OF_MONTH));
		System.out.print(getAge(dob, todayC));

	}

}
