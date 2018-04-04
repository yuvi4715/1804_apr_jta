package com.revature.Homework.ProblemFourtyFive;

import java.math.BigInteger;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("Enter Number:");
		int number=in.nextInt();
		boolean isPrime=true;
		for(int i=2;i<Math.sqrt(number);i++) {
			if(number%i==0) {
				isPrime=false;
				break;
			}
		}
		if(isPrime) {
			System.out.println("Is Prime");
		} else 
			System.out.println("IS not Prime");
	}
}
