package com.revature.advancedcodingexercises;

import java.util.Calendar;
import java.util.Date;

public class AdvancedCodingExercises {

	public static void main(String[] args) {
		String replacingChar = replaceChar("I ran I ran so far away", 'a', 'e');
		System.out.println(replacingChar);
		
//		Calendar theCalendar = Calendar.getInstance();
//		Date theDate = theCalendar.getTime();
//		Date theDate2 = theCalendar.getTime();
//		System.out.println(theDate.compareTo(new Date(98, 11, 20)));
//		System.out.println(theDate.compareTo(theDate));
		
		Date myBirthday = new Date(88, 4, 5);
		Date bd = Calendar.getInstance().getTime();
		System.out.println(birthday(myBirthday));
		System.out.println(fibonacci(12));
		System.out.println(fibonacciRecursive(12));

	}
	
	static String replaceChar(String string, char char1, char char2) {
		return string.replace(char1, char2);
	}

	static int birthday(Date birthdayDate) {
		Calendar theCalendar = Calendar.getInstance();
		Date now = theCalendar.getTime();
		int age = now.getYear() - birthdayDate.getYear();
		if (now.getMonth() < birthdayDate.getMonth()) {
			age--;
		}
		if (now.getMonth() == birthdayDate.getMonth()) {
			if (now.getDay() < birthdayDate.getDay()) {
				age--;
			}
		}
		if (now.getMonth() == birthdayDate.getMonth()) {
			if (now.getDay() == birthdayDate.getDay()) {
				System.out.println("Happy Birthday!!");
			}
		} 
		return age;
	}
	
	static int fibonacci(int n) {
		int a = 0;
		int b = 1;
		int c = 0;	
		
		for (int i = 2 ; i <= n ; i++) {
			c = a + b;
			a = b;
			b = c;
		}
		
		return c;
	}

	static int fibonacciRecursive(int n)  {
	    if (n == 0) {
	    	return 0;
	    } 
	    else if (n == 1)  {
	    	return 1;
	    } else {
	    	return fibonacciRecursive(n - 1) + fibonacciRecursive(n - 2);
	    }
	}
	    	
	    	
}
					
