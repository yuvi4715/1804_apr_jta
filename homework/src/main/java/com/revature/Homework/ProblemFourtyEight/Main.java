package com.revature.Homework.ProblemFourtyEight;

import java.io.PrintStream;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		test01(System.out);
	}
	public static void test01(PrintStream out) {
		Scanner in = new Scanner(System.in);
		out.println("Enter a number:");
		int number = in.nextInt();
		long multiple = 1;
		for(int i=1;i<=number;i++) {
			multiple*=i;
		}
		out.println(multiple);
	}
}
