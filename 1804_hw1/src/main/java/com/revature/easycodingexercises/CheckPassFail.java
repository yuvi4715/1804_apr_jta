package com.revature.easycodingexercises;

// Solution to hw1 problem #32

public class CheckPassFail {

	public static void passFail(int mark) {
		
		if (mark >= 50) {
			System.out.println("PASS");
		} else {
			System.out.println("FAIL");
		}
	}
	
	public static void main(String[] args) {
		
		passFail(43);
		passFail(70);
		passFail(32);
		passFail(49);
		passFail(51);
		passFail(50);
		passFail(100);
		passFail(95);
	}
}
