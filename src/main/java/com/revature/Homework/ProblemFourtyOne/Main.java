package com.revature.Homework.ProblemFourtyOne;

import java.math.BigInteger;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		for(int i=1;i<=50;i++)
		{
			String s ="";
			if(i%3==0) {
				s+="Fizz";
			}
			if(i%5==0) {
				s+="Buzz";
			}
			if(s.length()==0)
				s+=i;
			System.out.println(s);
		}
	}	
}
