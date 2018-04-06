package com.revature.advancedcodingexercises;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class AdvancedCodingExercises {

	public static void main(String[] args) {
		String replacingChar = replaceChar("I ran I ran so far away", 'a', 'e');
		System.out.println(replacingChar);

		Date myBirthday = new Date(88, 4, 5);
		Date bd = Calendar.getInstance().getTime();
		System.out.println(birthday(myBirthday));
		printFibonacci();
		fizzBuzz();
		
		// Question 42.
		Employee employee2 = new Employee("Sam", "Marketing", 28);
		Employee employee1 = new Employee("John", "Engineering", 30);
		Employee employee3 = new Employee("Pam", "HR", 25);
		ArrayList<Employee> al = new ArrayList<>();  
		al.add(employee1);
		al.add(employee2);
		al.add(employee3);
		al.sort((a, b) -> { return a.getName().compareTo(b.getName()); });
		al.sort((a, b) -> { return a.getDepartment().compareTo(b.getDepartment()); });
		al.sort((a, b) -> { return new Integer(a.getAge()).compareTo(new Integer(b.getAge())); });
		for (Employee e : al) {
			System.out.println(e);
		}
		
		System.out.println(isArmstrong(408));
		System.out.println(reverse("evol"));
		
		for (int i = 2 ; i < 50 ; i++) {
			if (isPrime(i)) {
				System.out.println(i);
			}
		}
			
	}
	
	// Question 38
	static String replaceChar(String string, char char1, char char2) {
		return string.replace(char1, char2);
	}

	// Question 39
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
	
	// Question 40
	static int fibonacci(int n) {
		int a = 0;
		int b = 1;
		int c = 0;	
		
		if (n == 1) {
			return 1;
		}
		
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
	
	static void printFibonacci() {
		for (int i = 0 ; i < 100 ; i++) {
			System.out.println(fibonacci(i));
		}
	}
	
	// Question 41
	static void fizzBuzz() {
		for (int i = 1 ; i <= 50 ; i++) {
			if (i % 3 == 0 && i % 5 == 0) {
				System.out.println("FizzBuzz");
			} else if (i % 3 == 0) {
				System.out.println("Fizz");
			} else if (i % 5 == 0) {
				System.out.println("Buzz");
			} else {
				System.out.println(i);
			}
		}
	}
	  
	// Question 43
	static boolean isArmstrong(int n) {
		int num1 = (int) Math.floor(n / 100);
		int num2 = (int) Math.floor((n % 100) / 10);
		int num3 = n % 10;
	
		return n == ( Math.pow(num1, 3) + Math.pow(num2, 3) + Math.pow(num3, 3) );
	}
	
	// Question 44
	static String reverse(String str) {
		StringBuilder sb = new StringBuilder("");
		for (int i = str.length() - 1 ; i >= 0 ; i--) {
			sb.append(str.charAt(i));
		}
		return sb.toString();
	}
	
	// Question 45
	static boolean isPrime(int n) {
		if (n == 2) {
			return true;
		}
		
		for (int i = 2 ; i < n ; i++) {
			if (n % i == 0) {
				return false;
			}
		}
		
		return true;
	}
	    	
}
					
