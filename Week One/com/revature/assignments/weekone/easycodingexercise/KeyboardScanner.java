/**
 * 
 */
package com.revature.assignments.weekone.easycodingexercise;

import java.util.Scanner;

/**
 * @author Ed M
 * @date Apr 5, 2018
 * @time time 1:57:46 PM
 */
public class KeyboardScanner {

	/**
	 * 
	 */
	//Q25
	public KeyboardScanner() {
		// TODO Auto-generated constructor stub
	}
	public static String keyboardScanner() {
		System.out.println("Input a int, double, and String in this order");
		Scanner sc = new Scanner(System.in);
		int i = sc.nextInt();
		double d = sc.nextDouble();
		String s = sc.next();
		return (Integer.toString(i) + " " + Double.toString(d) + " " + s);
		
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(keyboardScanner());

	}

}
