package com.revature.questions38_45;

public class Question43 {

	public static void main(String[] args) {
		
		System.out.println(armstrongNumber(1));	//true
		System.out.println(armstrongNumber(3)); //true
		System.out.println(armstrongNumber(5));  //true
		System.out.println(armstrongNumber(100)); //false
		System.out.println(armstrongNumber(153)); //true
		System.out.println(armstrongNumber(1000));  //false
		System.out.println(armstrongNumber(1634)); //true
		System.out.println(armstrongNumber(25645)); //false
		System.out.println(armstrongNumber(54748)); //true

	}
	
	
	public static boolean armstrongNumber(int num) {
		
		StringBuilder tempnum = new StringBuilder(String.valueOf(num));
		boolean armstrongNumber = false;
		int tempArmstrong = 0;
		for(int i = 0; i < tempnum.length(); i++) {
			char unicodeterror = tempnum.charAt(i);
			tempArmstrong += Math.pow(Character.getNumericValue(unicodeterror), tempnum.length());
		}
		
		if(tempArmstrong == (double)num) {
			armstrongNumber = true;
		}
		
		return armstrongNumber;
		
	}
}
