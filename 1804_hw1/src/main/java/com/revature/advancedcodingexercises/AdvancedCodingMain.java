package com.revature.advancedcodingexercises;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Comparator;
import java.util.Iterator;

// Solution to hw1 problem #38 - #39, #42 - #45

public class AdvancedCodingMain {
	
	/**
	 * 
	 * @param s - string that will have a character replaced
	 * @param c - character that will be put into string
	 * @param idx - index of character to be replaced
	 * @return This method will return a string with a replaced 
	 * 			character at the desired index, idx.
	 */
	public static String replaceChar(String s, char c, int idx) {
		
		char[] sChars = s.toCharArray();
		sChars[idx] = c;
		s = String.valueOf(sChars);
				
		return s;
	}
	
	/**
	 * 
	 * @param bday
	 * @return Given a calendar object that represents the birthday of a person as well as a name,
	 * 			determines and returns that persons age. If it is their birthday
	 * 			print the Happy birthday song.
	 */
	public static int calculateAge(Calendar bday, String name) {
		
		Calendar currDate = Calendar.getInstance();
		int birthYear = bday.get(Calendar.YEAR);
		int currYear = currDate.get(Calendar.YEAR);
		int birthMonth = bday.get(Calendar.MONTH) + 1;
		int currMonth = currDate.get(Calendar.MONTH) + 1;
		int birthDay = bday.get(Calendar.DAY_OF_MONTH);
		int currDay = currDate.get(Calendar.DAY_OF_MONTH);
		int age;
		
		if (birthMonth <= currMonth) {
			
			if (birthDay <= currDay) {
				
				age = currYear - birthYear;
				
				if (birthDay == currDay && birthMonth == currMonth) {
					System.out.println("Happy birthday to you!");
					System.out.println("Happy birthday to you!");
					System.out.println("Happy birthday dear " + name + "!");
					System.out.println("Happy birthday to you!");
				}
			} else {
				age = currYear - birthYear - 1;
			}
		} else {
			age = currYear - birthYear - 1;
		}
		 
		return age;
	}
	
	/**
	 * 
	 * @param num
	 * @return Returns true if num is an armstrong number or false if num
	 * 			is not an armstrong number
	 */
	public static boolean isArmstrong(int num) {
		
		String numString = Integer.toString(num);
		int numDigits = numString.length();
		char[] numStringArray = numString.toCharArray();
		int armstrongAcc = 0, currDigit;
		
		for (int i = 0; i < numDigits; i++) {
			
			currDigit = Integer.parseInt(Character.toString(numStringArray[i]));
			
			armstrongAcc += Math.pow(currDigit, numDigits);
		}
		
		if (num == armstrongAcc) {
			return true;
		}
		
		return false;
	}
	
	/**
	 * 
	 * @param s
	 * @return Given a string, s, return a reversed version of the string
	 */
	public static String reverseString(String s) {
		char[] sArray = s.toCharArray();
		char[] reversedArray = new char[s.length()];
		
		for (int i = 0; i < s.length(); i++) {
			
			reversedArray[i] = sArray[s.length()-i-1];
		}
		
		s = String.valueOf(reversedArray);
		return s;
	}
	
	public static boolean isPrime(int num) {
		
		for (int i = 2; i < num; i++) {
			
			if (num%i == 0) {
				return false;
			}
		}
		
		return true;
	}
	
	public static void main(String[] args) {
		
		// Test replaceChar() method
		String test = "Black";
		System.out.println("Before Method: " + test);		
		test = replaceChar(test, 'o', 2);
		System.out.println("After Method: " + test);
		
		// Test calculateAge() method
		Calendar bday = Calendar.getInstance();
		bday.set(Calendar.YEAR, 1993); //Test case for my own birthday
		bday.set(Calendar.MONTH, 9);
		bday.set(Calendar.DAY_OF_MONTH, 22);
		String name = "Austin";
		int age = calculateAge(bday, name);
		System.out.println("\n" + name + "'s Age: " + age + "\n");
		
		name = "Bob";
		bday = Calendar.getInstance();
		bday.set(Calendar.YEAR, 1986);
		age = calculateAge(bday, "Bob");
		System.out.println(name + "'s Age: " + age);
		
		// Test Employee comparators
		ArrayList<Employee> employeeList = new ArrayList<>();
		
		Employee emp1 = new Employee("Bob", "Technology", 42);
		Employee emp2 = new Employee("Austin", "Sales", 30);
		Employee emp3 = new Employee("Jerry", "Sales", 40);
		Employee emp4 = new Employee("John", "Quality Control", 42);
		Employee emp5 = new Employee("John", "Management", 28);
		Employee emp6 = new Employee("Tom", "Corperate", 53);
		
		employeeList.add(emp1);
		employeeList.add(emp2);
		employeeList.add(emp3);
		employeeList.add(emp4);
		employeeList.add(emp5);
		employeeList.add(emp6);		
	
		employeeList.sort(new NameComparator()); // Sort by name
		Iterator<Employee> iter = employeeList.iterator();
		
		System.out.println("\nSort employees by name:");
		while (iter.hasNext()) {
			Employee next = iter.next();
			
			System.out.println(next);
		}
		
		employeeList.sort(new DepartmentComparator()); // Sort by department
		iter = employeeList.iterator();
		
		System.out.println("\nSort employees by department:");
		while (iter.hasNext()) {
			Employee next = iter.next();
			
			System.out.println(next);
		}
		
		employeeList.sort(new AgeComparator()); // Sort by age
		iter = employeeList.iterator();
		
		System.out.println("\nSort employees by age:");
		while (iter.hasNext()) {
			Employee next = iter.next();
			
			System.out.println(next);
		}
		
		// Test isArmstrong() method
		System.out.println("\nTesting isArmstrong() method:");
		System.out.println("Is 54 armstong? " + isArmstrong(54));
		System.out.println("Is 153 armstrong? " + isArmstrong(153));
		System.out.println("Is 8208 armstrong? " + isArmstrong(8208));
		System.out.println("Is 1741725 armstrong? " + isArmstrong(1741725));
		
		// Test reverseString() method
		String s = "This string is a test.";
		System.out.println("\nOriginal String: " + s);
		System.out.println("Reversed String: " + reverseString(s));
		
		// Test isPrime() method
		System.out.println("\nTesting isPrime() method:");
		System.out.println("Is 4 a prime number? " + isPrime(4));
		System.out.println("Is 64 a prime number? " + isPrime(64));
		System.out.println("Is 33 a prime number? " + isPrime(33));
		System.out.println("Is 17 a prime number? " + isPrime(17));
		System.out.println("Is 6761 a prime number? " + isPrime(6761));
		System.out.println("Is 6211 a prime number? " + isPrime(6211));
		System.out.println("Is 7919 a prime number? " + isPrime(7919));
	}
}

// Write different comparators for Employee objects

class NameComparator implements Comparator<Employee> {

	@Override
	public int compare(Employee emp1, Employee emp2) {
		
		return emp1.getName().compareTo(emp2.getName());
	}
	
}

class DepartmentComparator implements Comparator<Employee> {

	@Override
	public int compare(Employee emp1, Employee emp2) {
		
		return emp1.getDepartment().compareTo(emp2.getDepartment());
	}
	
}

class AgeComparator implements Comparator<Employee> {

	@Override
	public int compare(Employee emp1, Employee emp2) {
		
		int age1 = emp1.getAge();
		int age2 = emp2.getAge();
		
		return age1 - age2;
	}
	
}
