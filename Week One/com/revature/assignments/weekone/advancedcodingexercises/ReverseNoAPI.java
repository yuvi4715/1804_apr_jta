/**
 * 
 */
package com.revature.assignments.weekone.advancedcodingexercises;

/**
 * @author Ed M
 * @date Apr 6, 2018
 * @time time 1:16:22 PM
 */
///Q44
public class ReverseNoAPI {

	/**
	 * 
	 */
	public ReverseNoAPI() {
		// TODO Auto-generated constructor stub
	}

	public static String reverseNoAPI(String normal) {
		char[] temp = normal.toCharArray();
		char[] reversedArray = new char[normal.length()];
		int otherTemp = 0;
		for (int i = temp.length-1; i>=0; i--) {
			//System.out.println(temp[i]);
			reversedArray[otherTemp] = temp[i];
			otherTemp++;
		}
		String reversedString = new String(reversedArray);
		return reversedString;
	}

	public static void main(String[] args) {
		System.out.println(reverseNoAPI("Today is Friday"));

	}

}
