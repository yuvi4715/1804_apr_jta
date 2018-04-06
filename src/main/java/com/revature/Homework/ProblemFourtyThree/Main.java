package com.revature.Homework.ProblemFourtyThree;

import java.io.PrintStream;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		test01(System.out);
	}	
	public static void test01(PrintStream out) {
		Scanner in = new Scanner(System.in);
		out.println("Enter number: ");
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
			out.println("Is an Armstrong Number");
		else 
			out.println("Is NOT an Armstrong Number");
	}
}
