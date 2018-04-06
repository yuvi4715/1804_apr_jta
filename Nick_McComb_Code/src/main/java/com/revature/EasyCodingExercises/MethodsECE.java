package com.revature.EasyCodingExercises;

import java.util.ArrayList;
import java.util.Scanner;

public class MethodsECE {

	public boolean CheckPassFail(int mark) {
		if(mark >= 50) {
			System.out.println("PASS");
			return true;
		}
		else {
			System.out.println("FAIL");
			return false;
		}
	}
	
	// Treats even as true and odd as false for the return (for easier testing)
	public boolean CheckEvenOdd(int number) {
		if(number % 2 == 0) {
			System.out.println("EVEN");
			return true;
		}
		else {
			System.out.println("ODD");
			return false;
		}
	}
	
	void PrintNumberInWord(int number) {
//		if(number == 1) {
//			System.out.println("ONE");
//		}
//		else if(number == 2) {
//			System.out.println("TWO");
//		}
//		else if(number == 3) {
//			System.out.println("THREE");
//		}
//		else if(number == 4) {
//			System.out.println("FOUR");
//		}
//		else if(number == 5) {
//			System.out.println("FIVE");
//		}
//		else if(number == 6) {
//			System.out.println("SIX");
//		}
//		else if(number == 7) {
//			System.out.println("SEVEN");
//		}
//		else if(number == 8) {
//			System.out.println("EIGHT");
//		}
//		else if(number == 9) {
//			System.out.println("NINE");
//		}
//		else {
//			System.out.println("OTHER");
//		}
		
		switch (number) {
			case 1:
				System.out.println("ONE");
				break;
			case 2:
				System.out.println("TWO");
				break;
			case 3:
				System.out.println("THREE");
				break;
			case 4:
				System.out.println("FOUR");
				break;
			case 5:
				System.out.println("FIVE");
				break;
			case 6:
				System.out.println("SIX");
				break;
			case 7:
				System.out.println("SEVEN");
				break;
			case 8:
				System.out.println("EIGHT");
				break;
			case 9:
				System.out.println("NINE");
				break;
			default:
				System.out.println("OTHER");
				break;
		}
	}
	
	void KeyboardScanner() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Please enter an integer:");
		int i = sc.nextInt();
		System.out.println("Please enter a double:");
		double d = sc.nextDouble();
		System.out.println("Please enter a String");
		String s = sc.nextLine();
		
		System.out.println("int you entered:" + i);
		System.out.println("double you entered" + d);
		System.out.println("String you entered" + s);
	}
	
	public int Arithmetic(int a, int b, char op) {
		int c;
		switch(op) {
			case '+':
				c = a+b;
				System.out.println(a + " plus " + b + " is " + c);
				return c;
			case '-':
				c = a-b;
				System.out.println(a + " minus " + b + " is " + c);
				return c;
			case '*':
				c = a*b;
				System.out.println(a + " times " + b + " is " + c);
				return c;
			case '/':
				c = a/b;
				System.out.println(a + " divided by " + b + " is " + c);
				return c;
			default:
				System.out.println("Error - unrecognized operator");
				return 0;
		}
	}
	
	void GradesStatistics(int...n) {
		int index = 0;
		double mean = 0;
		int a[];
		a = new int[n.length];
		for(int i:n) {
			if(i < 0 || i > 100) {
				System.out.println("Invalid input " + i);
			}
			else {
				a[index] = i;
			}
			index++;
		}
		mean = mean(a);
		System.out.println("Average grade: " + mean(a));
		System.out.println("The lowest grade was " + min(a) + ", and the highest grade was " + max(a));
		//standard deviation calculation
		System.out.println("Grade standard deviation was: " + stdv(mean, a));
	}
	
	int min(int a[]) {
		int min = 100;
		for(int i : a) {
			if(i < min) {
				min = i;
			}
		}
		return min;
	}
	
	int max(int a[]) {
		int max = 0;
		for(int i : a) {
			if(i > max) {
				max = i;
			}
		}
		return max;
	}
	
	double mean(int a[]) {
		int sum = 0;
		for(int i : a) {
			sum += i;
		}
		return sum/a.length;
	}
	
	double stdv(double mean, int a[]) {
		double sum = 0;
		for(int i : a) {
			sum += ((a[i]-mean)*(a[i]-mean));
		}
		return Math.sqrt(sum /= a.length);
	}
}
