package com.revature.questions38_45;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Questions38_45 {

	public static void main(String[] args) {
		
		//Question 38
		String hero = "I'm the Batman!";
		char oldchar = 'B';
		char newchar = 'C';
		hero = redundantStringReplace( oldchar, newchar,hero);
		System.out.println(hero);
		
		
		//Question 39
		
		Calendar dob = new GregorianCalendar(1993, 1, 2);
		System.out.println("Age: " + happyBirthday(dob));
		//test birthday
		Calendar dob2 = new GregorianCalendar(1993, 3, 5); //Months start at zero
		System.out.println("Age: " + happyBirthday(dob2));
		
		
		//Question 40 Theoretically should work but it's messing up my JVM
		System.out.print("Fibonacci series(R): ");
		for(int i=0;i<=100;i++){
			System.out.print(fibonacciRecursive(i)+" ");
		}
		System.out.println();
		
		System.out.print("Fibonacci series(I): ");
		for(int i=0;i<=100;i++){
			System.out.print(fibonacciIterative(i)+" ");
		}
		System.out.println();
		
		
		//Question 41
	}
	
	
	
	//Question 38
	public static String redundantStringReplace(char oldchar, char newchar, String replacedstr) {
		
		
		String s = replacedstr.replace(oldchar, newchar);
		
		return s;
	}
	
	
	//Question 39
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
	
	
	//Question 40

	public static int fibonacciRecursive(int n){
		if(n<=1){
			return 1;
		}
		else{
			return fibonacciRecursive(n-1)+fibonacciRecursive(n-2);
		}
	}
	
	public static int fibonacciIterative(int n){
		int i=0,result=1,prevresult=1;
		while(i<n-1){
			int temp=result;
			result=result+prevresult;
			prevresult=temp;
			i++;
		}
		
		return result;
}
	
	//Question 41
	
	
}
