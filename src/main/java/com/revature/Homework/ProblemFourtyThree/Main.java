package com.revature.Homework.ProblemFourtyThree;

import java.math.BigInteger;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("Enter number: ");
		String s;
		s=in.nextLine();
		int number = Integer.parseInt(s);
		int sum = 0,length = s.length();
		while(s.length()>0) {
			char c = s.charAt(0);
			s=s.substring(1);
			sum+=Math.pow(Integer.parseInt(c+""), length);
		}
		if(sum==number)
			System.out.println("Is an Armstrong Number");
		else 
			System.out.println("Is NOT an Armstrong Number");
	}	
}
