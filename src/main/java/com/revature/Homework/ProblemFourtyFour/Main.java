package com.revature.Homework.ProblemFourtyFour;

import java.math.BigInteger;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("Enter String:");
		String s="",reversed = "";
		s=in.nextLine();
		for(int i=s.length()-1;i>=0;i--) {
			reversed += s.charAt(i);
		}
		System.out.println(reversed);
	}	
}
