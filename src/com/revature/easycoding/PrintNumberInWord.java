package com.revature.easycoding;

import java.util.Scanner;

//problem 34
public class PrintNumberInWord {

	public static void main(String[] args) {
		// get number from user
		Scanner reader = new Scanner(System.in);
		boolean valid= false;
		int controlFlowTest = 0;
		while(!valid) {
			System.out.println("Enter 1 for \"if-else\" test. Enter 2 for \"switch-case test\"");
			controlFlowTest = reader.nextInt();
			if(!(controlFlowTest == 1 || controlFlowTest == 2)) {
				System.out.println("Invalid entry.");
			}else {
				valid= true;
			}
		}
		System.out.println("Enter a number: ");
		int number = reader.nextInt();
		reader.close();
		String numString = null;
		
		//if else
		if(controlFlowTest ==1) {
			if(number == 1) {
				numString ="ONE";
			}else if(number == 2) {
				numString ="TWO";
				
			}else if(number == 3) {
				numString ="THREE";
				
			}else if(number == 4) {
				numString ="FOUR";
				
			}else if(number == 5) {
				numString ="FIVE";
				
			}else if(number == 6) {
				numString ="SIX";
				
			}else if(number == 7) {
				numString ="SEVEN";
				
			}else if(number == 8) {
				numString ="EIGHT";
				
			}else if(number == 9) {
				numString ="NINE";
			}
			else {
				numString ="OTHER";
			}
		}else if(controlFlowTest == 2) {
			//switch
			switch (number) {
			case 1:
				numString ="ONE";
				break;
			case 2:
				numString ="TWO";
				break;
			case 3:
				numString ="THREE";
				break;
			case 4:
				numString ="FOUR";
				break;
			case 5:
				numString ="FIVE";
				break;
			case 6:
				numString ="SIX";
				break;
			case 7:
				numString ="SEVEN";
				break;
			case 8:
				numString ="EIGHT";
				break;
			case 9:
				numString ="NINE";
				break;
			default:
				numString ="OTHER";
				break;
			}
		}
			
		
			
		
		
		
		
		System.out.println(numString);
		
	}
}

