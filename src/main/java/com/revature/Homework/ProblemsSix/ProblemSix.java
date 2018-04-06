package com.revature.Homework.ProblemsSix;

import java.io.PrintStream;

public class ProblemSix {
	enum Numbers{
		One,
		Two
	};
	public static void main(String[] args) {
		test01(System.out);
	}
	public static void test01(PrintStream out) {
		boolean bol=true;
		//IF
		if(bol) {
			 out.println("Executed if");
		}
		//SWITCH
		Numbers one = Numbers.One;
		switch(one) {
		case One:
			out.println("Executed switch");
			break;
		case Two:
			break;
		}
		//FOR
		for(int i=0;i<3;i++)
		{
			out.println("For loop executed "+(i+1)+" times");
		}
		//WHILE
		while(bol) {
			out.println("Executed while loop");
			bol = false;
		}
		//DOWHILE
		do {
		out.println("do while loop executed");
		bol=true;
		}while(!bol);
		//BREAK
		loop:{
			for(int i=0;i<3;i++) {
		 		if(i%2==0) {
					out.println("Executed break statement");
		 			break loop;
		 		}
			}
		}
		//CONTINUE
		loop:{
			for(int i=0;i<3;i++) {
				if(i%2!=0)
					break loop;
				else {
					out.println("Executed continue statement");
					continue;
				}
			}
		}
		
	}
}
