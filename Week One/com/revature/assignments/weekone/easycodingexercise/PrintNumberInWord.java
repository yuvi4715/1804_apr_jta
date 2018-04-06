/**
 * 
 */
package com.revature.assignments.weekone.easycodingexercise;

/**
 * @author Ed M
 * @date Apr 5, 2018
 * @time time 1:40:07 PM
 */
//Q34
public class PrintNumberInWord {

	/**
	 * 
	 */
	public PrintNumberInWord() {
		// TODO Auto-generated constructor stub
	}

	public static String  printNumberIntoWords(int value) {
		switch(value) {
		case 1:return "ONE";
		case 2:return "TWO";
		case 3:return "THREE";
		case 4:return "FOUR";
		case 5:return "FIVE";
		case 6:return "SIX";
		case 7:return "SEVEN";
		case 8:return "EIGHT";
		case 9:return "NINE";
		default:return "OTHER";
		
		}
		
	}
	public static void main(String[] args) {
		System.out.println("0: "+printNumberIntoWords(0));
		
		System.out.println("1: "+printNumberIntoWords(1));
		System.out.println("2: "+printNumberIntoWords(2));
		System.out.println("3: "+printNumberIntoWords(3));
		System.out.println("4: "+printNumberIntoWords(4));
		System.out.println("5: "+printNumberIntoWords(5));
		System.out.println("6: "+printNumberIntoWords(6));
		System.out.println("7: "+printNumberIntoWords(7));
		System.out.println("8: "+printNumberIntoWords(8));
		System.out.println("9: "+printNumberIntoWords(9));
		
		System.out.println("10: "+printNumberIntoWords(10));
		System.out.println("50: "+printNumberIntoWords(50));

	}

}
