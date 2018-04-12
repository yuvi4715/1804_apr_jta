package com.revature.boxing;

public class AutoExample {

	public static void main(String[] args) {
	int i = 10;
	Integer I = new Integer(i);
	System.out.println();
	
	/*
	 * Boxing
	 */
	int 	num1 = 5;
	Integer num2 = new Integer(num1);
	
	/*
	 * Unboxing
	 */
	Integer num3 = new Integer(5);
	int 	num4 = num3.intValue();
	
	
	/*
	 * Autoboxing - Since Java 1.5
	 */
	int 	num5 = 5;
	Integer num6 = num5;
	
	
	/*
	 * Auto Unboxing - Since Java 1.5
	 */
	Integer num7 = 5;
	int num8 = num7;
	}

}
