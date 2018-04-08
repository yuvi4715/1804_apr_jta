package com.advancedcode.work;

import java.util.Calendar;

public class HappyBirthday {

	public static void main(String[] args) {

		int todayYear, todayMonth, today, beforeY, beforeM, beforeD;
		Calendar now = Calendar.getInstance();
		Calendar before = Calendar.getInstance();
		
		before.set(1992, 4,6);
		
		todayYear = now.get(Calendar.YEAR);
		todayMonth = now.get(Calendar.MONTH);
		today = now.get(Calendar.DAY_OF_MONTH);
		
		beforeY = before.get(Calendar.YEAR);
		beforeM = before.get(Calendar.MONTH);
		beforeD = before.get(Calendar.DAY_OF_MONTH);
		
		if((todayMonth - beforeM +1) <0) {
			
			System.out.println("Your age is: " + ((todayYear - beforeY)-1));
		}
		else if((todayMonth - beforeM+1) == 0) {
			if((today - beforeD) == 0) {
				System.out.println("Happy birthday!! Now your age is: " + (todayYear - beforeY));
			}
			else
				System.out.println("Your age is: " + ((todayYear - beforeY)-1));
		}
		else 
			System.out.println("Your age is: " + (todayYear - beforeY));
	}

}
