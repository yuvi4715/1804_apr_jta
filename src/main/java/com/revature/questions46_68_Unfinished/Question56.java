package com.revature.questions46_68_Unfinished;

public class Question56 {

	public static void main(String[] args) {
		
		evenOrOdd(11);
		evenOrOdd(111);
		evenOrOdd(122);
		evenOrOdd(123);
		evenOrOdd(1000);
		evenOrOdd(1001);
		evenOrOdd(0);
		evenOrOdd(-2);
		evenOrOdd(200);
		evenOrOdd(201);
		
		evenOrOddMod(11);
		evenOrOddMod(111);
		evenOrOddMod(122);
		evenOrOddMod(123);
		evenOrOddMod(1000);
		evenOrOddMod(1001);
		evenOrOddMod(0);
		evenOrOddMod(-2);
		evenOrOddMod(200);
		evenOrOddMod(201);
	}
	
	
	public static void evenOrOdd(int a) {
		
		int temp_a = a/2;
		
		if(temp_a*2 == a) {
			System.out.println(a + " is even");
		}else {
			System.out.println(a + " is odd");
		}
	}
	
	public static void evenOrOddMod(int a) {
		
		if(a % 2 == 0) {
			System.out.println(a + " is even");
		}else {
			System.out.println(a + " is odd");
		}
	}
	
	
	
}
