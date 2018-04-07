package core_java;

/**
 * @author katherine Obioha
 * 
 * This class contains question 1 & 2 & 3 . I also used this class to show all control statements in Java - Question 6
 */
import java.util.Scanner;

public class Core_Java {

	static Scanner in = new Scanner(System.in);

	public static void main(String[] args) {

		String n;
		do {

			System.out.println("Performing simple arithemetic");
			arithmetic();
			System.out.println("Finding the maximum number in an array");
			maximum();
			System.out.println("Entering logic operations");
			logic();
			System.out.println("Enter q to exit program");
			n = in.next();
		} while (!n.equals("q"));
	}

	// 1. Write a program to add, subtract, multiply and divide two non-zero
	// hard-coded numbers.

	static void arithmetic() {
		for (int i = 0; i < 3; i++) {
			System.out.println("Pick a letter: A-add, S-subtract, M-multiply, D-divide");
			String x = in.next();
			switch (x.toUpperCase()) {
			case "A":
				System.out.println("Add");
				System.out.println("2 + 2:" + "\n" + (2 + 2));
				break;
			case "S":
				System.out.println("Subtract");
				System.out.println("2 - 2:" + "\n" + (2 - 2));
				break;
			case "M":
				System.out.println("Multiply");
				System.out.println("2 x 2:" + "\n" + (2 * 2));
				break;
			case "D":
				System.out.println("Divide");
				System.out.println("2 / 2:" + "\n" + (2 / 2));
				continue;
			}
		}
	}

	static void maximum() {
		System.out.println("Finding the maximum number between {1000000, 890, 90000000}");
		int[] x = { 1000000, 890, 90000000 };

		if (x[0] > x[1] && x[0] > x[2])

			System.out.println(x[0]);

		else if (x[1] > x[0] && x[1] > x[2])

			System.out.println(x[1]);

		else

			System.out.println(x[2]);
	}

	static void logic() {
		boolean a = true;
		boolean b = false;
		System.out.println("When a = true, and b = false. Find !a, a|b, (!a & b) | (a & !b)");
		System.out.println("!a =" + !a);
		System.out.println("a|b = " + (a | b));
		System.out.println("(!a & b) | (a & !b) =" + ((!a & b) | (a & !b)));
	}
}
