/**
 * 
 */
package com.revature.assignments.weekone.easycodingexercise;

/**
 * @author Ed M
 * @date Apr 5, 2018
 * @time time 1:33:10 PM
 */
//Q34
public class CheckOddEven {

	/**
	 * 
	 */
	public CheckOddEven() {
		// TODO Auto-generated constructor stub
	}

	public static String checkOddEven(int value) {
		if(value%2 == 0) {
			return "Even Number";
		}else if(value%2 == 1) {
			return "Odd Number";
		}
		return null;
	}

	public static void main(String[] args) {
		System.out.println("50: "+checkOddEven(50));
		System.out.println("51: "+checkOddEven(51));
		System.out.println("49: "+checkOddEven(49));
		System.out.println("01: "+checkOddEven(1));
		System.out.println("60: "+checkOddEven(60));
		

	}

}
