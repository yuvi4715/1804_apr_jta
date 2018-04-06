package com.revature.EasyCodingExercises;

public class CheckPassFail {
	//problem32
	public static void main(String[] args) {
		try {
			int mark = Integer.parseInt(args[0]);

			if (mark >= 50) {
				System.out.println("PASS");
			}
			else {
				System.out.println("FAIL");
			}
		}
		catch(Exception e){
			System.out.println(e);
		}
	}
}
