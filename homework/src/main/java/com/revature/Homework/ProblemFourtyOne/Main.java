package com.revature.Homework.ProblemFourtyOne;

import java.io.PrintStream;

public class Main {
	public static void main(String[] args) {
		test01(System.out);
	}	
	public static void test01(PrintStream out) {
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
			out.println(s);
		}
	}
}
