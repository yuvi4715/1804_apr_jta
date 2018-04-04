package com.revature.Homework.ProblemsSix;


public class ProblemSix {
	enum Numbers{
		One,
		Two
	};
	public static void main(String[] args) {
		boolean bol=true;
		//IF
		if(bol) {
			 System.out.println("Executed if");
		}
		//SWITCH
		Numbers one = Numbers.One;
		switch(one) {
		case One:
			System.out.println("Executed switch");
			break;
		case Two:
			break;
		}
		//FOR
		for(int i=0;i<3;i++)
		{
			System.out.println("For loop executed "+(i+1)+" times");
		}
		//WHILE
		while(bol) {
			System.out.println("Executed while loop");
			bol = false;
		}
		//DOWHILE
		do {
		System.out.println("do while loop executed");
		bol=true;
		}while(!bol);
		//BREAK
		loop:{
			for(int i=0;i<3;i++) {
		 		if(i%2==0) {
					System.out.println("Executed break statement");
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
					System.out.println("Executed continue statement");
					continue;
				}
			}
		}
		
	}
}
