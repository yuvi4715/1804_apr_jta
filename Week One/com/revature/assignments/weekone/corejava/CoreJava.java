/**
 * 
 */
package com.revature.assignments.weekone.corejava;

/**
 * @author Ed M
 * @date Apr 6, 2018
 * @time time 2:56:46 PM
 */
///Q1- Q3
public class CoreJava {

	/**
	 * 
	 */
	public CoreJava() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		int hardCodedNumber1 = 2;
		int hardCodedNumber2 = 5;
		int hardCodedNumber3 = 9;

		boolean a = true;
		boolean b = false;

		System.out.println(
				"Q1: " + hardCodedNumber1 + "+" + hardCodedNumber2 + "=" + (hardCodedNumber1 + hardCodedNumber2));
		if ((hardCodedNumber1 > hardCodedNumber2) && (hardCodedNumber1 > hardCodedNumber3))
			System.out.println("Q2: " + hardCodedNumber1 + ">" + hardCodedNumber2 + "&" + hardCodedNumber3);
		else if ((hardCodedNumber2 > hardCodedNumber1) && (hardCodedNumber2 > hardCodedNumber3))
			System.out.println("Q2: " + hardCodedNumber2 + ">" + hardCodedNumber1 + "&" + hardCodedNumber3);
		else if ((hardCodedNumber3 > hardCodedNumber1) && (hardCodedNumber3 > hardCodedNumber2))
			System.out.println("Q2: " + hardCodedNumber3 + ">" + hardCodedNumber1 + "&" + hardCodedNumber2);
		System.out.println(
				"Q3: " + "!a = " + (!a) + ", a | b  = " + (a | b) + ", (!a & b) | (a & !b) = " + ((!a & b) | (a & !b)));

	}
}
