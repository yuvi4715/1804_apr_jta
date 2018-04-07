package com.revature.questions32_37;

public class Question32  {

	public static void main(String[] args) {
		
		int a = 10;
		int b = 100;
		
		CheckPassFail(a); //Fail
		CheckPassFail(b); //Pass
		
	}
	
	
	public static void CheckPassFail (int mark){
		if (mark >= 50) {
			System.out.println("PASS");
		} else {
			System.out.println("FAIL");
		}
		
	}
}
