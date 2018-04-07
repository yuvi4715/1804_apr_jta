package com.revature.questions32_37;

public class Question34 {

	public static void main(String[] args) {
		
		int a = 1;
		int b = 9;
		
		numToWordIf(a);
		numToWordSwitch(b);
	}
	
	public static void numToWordIf(int num) {
		
		if (num == 1) {
			System.out.println("ONE");
		} else if (num == 2) {
			System.out.println("TWO");
		} else if (num == 3) {
			System.out.println("THREE");
		} else if (num == 4) {
			System.out.println("FOUR");
		} else if (num == 5) {
			System.out.println("FIVE");
		} else if (num == 6) {
			System.out.println("SIX");
		} else if (num == 7) {
			System.out.println("SEVEN");
		} else if (num == 8) {
			System.out.println("EIGHT");
		} else if (num == 9) {
			System.out.println("NINE");
		} else {
			System.out.println("OTHER");
		}
	}

	public static void numToWordSwitch(int num) {

		switch (num) {
		//I normally really dislike not breaking code by newlines but this method took too much space
		//for how simple it method is.
		
		case 1:	System.out.println("ONE"); break;
		case 2:	System.out.println("TWO"); break;
		case 3: System.out.println("THREE"); break;
		case 4: System.out.println("FOUR"); break;
		case 5: System.out.println("FIVE"); break;
		case 6: System.out.println("SIX"); break;
		case 7: System.out.println("SEVEN"); break;
		case 8: System.out.println("EIGHT"); break;
		case 9: System.out.println("NINE"); break;
		default: System.out.println("OTHER"); break;
		}

	}
	
}
