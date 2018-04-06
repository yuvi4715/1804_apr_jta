/**
 * 
 */
package com.revature.assignments.weekone.javasyntax;

/**
 * @author Ed M
 * @date Apr 6, 2018
 * @time time 3:10:47 PM
 */
//Q5
public class OutOfClassMethodCall {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int testTemp00 = 14;
		int testTemp01 = 2;
		System.out.println("Q5: numbers: " + testTemp00 + " & " + testTemp01 + " ,Add = "
				+ FourOperators.add(testTemp00, testTemp01) + " ,subtract = "
				+ FourOperators.subtract(testTemp00, testTemp01) + " ,divide = "
				+ FourOperators.divide(testTemp00, testTemp01) + " ,Multiply = "
				+ FourOperators.multiply(testTemp00, testTemp01));

	}

}
