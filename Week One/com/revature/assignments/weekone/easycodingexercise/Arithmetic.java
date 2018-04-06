/**
 * 
 */
package com.revature.assignments.weekone.easycodingexercise;

import java.util.Scanner;

/**
 * @author Ed M
 * @date Apr 5, 2018
 * @time time 2:13:20 PM
 */
public class Arithmetic {

	/**
	 * 
	 */
	public Arithmetic() {
		// TODO Auto-generated constructor stub
	}

	@SuppressWarnings("null")
	public static int Arithmetic(){
		System.out.println("Input a int, a int and then a one of the main operator");
		Scanner sc = new Scanner(System.in);
		int i = sc.nextInt();
		int otheri = sc.nextInt();
		String s = sc.next();
		switch(s) {
		case "+": return i + otheri;
		case "-": return i - otheri;
		case "*": return i * otheri;
		case "/": return i / otheri;
		default:{
			System.out.println("you have entered the wrong thing");
			return (Integer) null;
		}
		}
	}

	public static void main(String[] args) {
		System.out.println(Arithmetic());
	}

}
