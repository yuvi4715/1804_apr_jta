package com.easycodes.work;

public class PrintNumberInWord {

	public static void main(String[] args) {
		
		for(int i = 1; i <11; i++)
			printNum(i);
	}
	
	static void printNum(int e) {
		switch(e) {
		case 1:
			System.out.println("ONE");
			break;
		case 2:
			System.out.println("TWO");
			break;
		case 3:
			System.out.println("THREE");
			break;
		case 4: 
			System.out.println("FOUR");
			break;
		case 5:
			System.out.println("FIVE");
			break;
		case 6:
			System.out.println("SIX");
			break;
		case 7:
			System.out.println("SEVEN");
			break;
		case 8:
			System.out.println("EIGHT");
			break;
		case 9:
			System.out.println("NINE");
			break;
		default:
			System.out.println("VALUE IS NOT WITHIN THE NUMBERS 1-9");
			break;
		}
	}
}
