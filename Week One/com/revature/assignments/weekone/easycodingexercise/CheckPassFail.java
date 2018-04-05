/**
 * 
 */
package com.revature.assignments.weekone.easycodingexercise;

/**
 * @author Ed M
 * @date Apr 5, 2018
 * @time time 1:27:02 PM
 */
//Q32
public class CheckPassFail {

	/**
	 * 
	 */
	public CheckPassFail() {
		// TODO Auto-generated constructor stub
	}

	public static String checkPassFail(int value) {
		if((value >= 50)) 
			return "PASS";
		else if( (value <= 50)) 
			return "FAIL";
		return null;
		
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
			System.out.println("50: "+checkPassFail(50));
			System.out.println("51: "+checkPassFail(51));
			System.out.println("49: "+checkPassFail(49));
			System.out.println("01: "+checkPassFail(1));
			System.out.println("60: "+checkPassFail(60));
			
	}

}
