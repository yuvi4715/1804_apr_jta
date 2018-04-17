package com.revature.advancedCodingExercises;

public class Armstrong {
	
	//problem 43
	public static void main(String[] args) {
		String input = args[0];
		
		
		System.out.println(isArmstrong(input));
	}
	
	public static boolean isArmstrong(String arm) {
		int checkNumber = Integer.parseInt(arm);
		String[] sa;
		int finalNum = 0;
		sa = arm.split("");
		
		for (int i = 0; i<sa.length; i++) {
			finalNum += Math.pow(Integer.parseInt(sa[i]),sa.length);
		}
		
		if (checkNumber == finalNum) {
			return true;
		}
		else {
			return false;
		}
	}
}
