package com.revature.Homework.ProblemFourtyFive;

import java.io.PrintStream;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		test01(System.out);
	}
	public static void test01(PrintStream out) {
		Scanner in = new Scanner(System.in);
		out.println("Enter Number:");
		int number=in.nextInt();
		boolean isPrime=true;
		for(int i=2;i<Math.sqrt(number);i++) {
			if(number%i==0) {
				isPrime=false;
				break;
			}
		}
		if(isPrime) {
			out.println("Is Prime");
		} else 
			out.println("IS not Prime");
	}
}
