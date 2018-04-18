package com.revature.Homework.ProblemFourtyFour;

import java.io.PrintStream;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		test01(System.out);
	}	
	public static void test01(PrintStream out) {
		Scanner in = new Scanner(System.in);
		out.println("Enter String:");
		String s="",reversed = "";
		s=in.nextLine();
		for(int i=s.length()-1;i>=0;i--) {
			reversed += s.charAt(i);
		}
		out.println(reversed);
	}
}
