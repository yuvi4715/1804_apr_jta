/**
 * 
 */
package assignment_wk_1;

import java.util.Scanner;

/**
 * @author sameerkhawaja
 *
 */
public class Assignment {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// main loop
		// ask for question number to call appropriate function
		int problem_num;
		Scanner reader = new Scanner(System.in);
		System.out.println("Welcome to Java Assignment Week 1!");
		boolean user_quit = false;
		while (user_quit == false) {
			System.out.println("=============================================================");
			System.out.println("Please enter a number to open a Java problem. Enter 0 to quit");
			problem_num = reader.nextInt();

			switch (problem_num) {
			case 0:
				user_quit = true;
				System.out.println("Goodbye");
				break;// quit
			case 1:
				problem_1();
				break;
			case 2:
				problem_2();
				break;
			case 3:
				problem_3();
				break;
			case 4:
				problem_4();
				break;
			case 5:
				System.out.println("Problem 5 is in another file.");;
				break;
			case 6:
				problem_6();
				break;
			default:
				System.out.println("Invalid problem number.");
				break;
			}
		}
		reader.close();
	}

	private static void problem_6() {
		// TODO Auto-generated method stub
		
	}

	private static void problem_4() {
		@SuppressWarnings("resource")
		Scanner reader = new Scanner(System.in);

		System.out.println("Enter value 1");
		double val_1 = reader.nextDouble();
		System.out.println("Enter value 2");
		double val_2 = reader.nextDouble();

		double result = add(val_1, val_2);
		System.out.println(val_1 + " + " + val_2 + " = " + result);
		result = subtract(val_1, val_2);
		System.out.println(val_1 + " - " + val_2 + " = " + result);
		result = multiply(val_1, val_2);
		System.out.println(val_1 + " * " + val_2 + " = " + result);
		result = divide(val_1, val_2);
		System.out.println(val_1 + " / " + val_2 + " = " + result);
	}

	private static double divide(double val_1, double val_2) {
		return val_1 / val_2;

	}

	private static double multiply(double val_1, double val_2) {
		return val_1 * val_2;
		// TODO Auto-generated method stub

	}

	private static double subtract(double val_1, double val_2) {
		return val_1 - val_2;
		// TODO Auto-generated method stub

	}

	private static double add(double val_1, double val_2) {
		return val_1 + val_2;
		// TODO Auto-generated method stub

	}

	private static void problem_3() {
		boolean a = true;
		boolean b = false;
		boolean result;

		System.out.println("a is " + a);
		System.out.println("b is " + b);

		result = !a;
		System.out.println("!a = " + result);
		result = a | b;
		System.out.println("a|b = " + result);
		result = (!a & b) | (a & !b);
		System.out.println("(!a&b)|(a&!b) = " + result);

	}

	private static void problem_1() {
		int val = 4 + 4;
		System.out.println("4 + 4 = " + val);
		val = 5 - 5;
		System.out.println("5 - 5 = " + val);
		val = 5 * 5;
		System.out.println("5 * 5 = " + val);
		val = 5 / 5;
		System.out.println("5 / 5 = " + val);
	}

	private static void problem_2() {
		@SuppressWarnings("resource")
		Scanner reader = new Scanner(System.in);
		System.out.println("Find the greatest of three numbers.");
		System.out.println("Enter value 1");
		int val_1 = reader.nextInt();
		System.out.println("Enter value 2");
		int val_2 = reader.nextInt();
		System.out.println("Enter value 3");
		int val_3 = reader.nextInt();

		if (val_1 >= val_2 && val_1 >= val_3) {
			System.out.println(val_1 + " is the greatest");
		} else if (val_2 >= val_1 && val_2 >= val_3) {
			System.out.println(val_2 + " is the greatest");
		} else if (val_3 >= val_1 && val_3 >= val_2) {
			System.out.println(val_3 + " is the greatest");
		}

		// find which variable is greatest, or greatest value of the 3?

	}

}
