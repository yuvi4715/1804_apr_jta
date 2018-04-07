package core_java;

import java.util.Scanner;

/**
 * 
 * @author katherine Obioha
 *
 *         This class answers Question 4
 */
public class Syntax_Java4 {

	static Scanner in = new Scanner(System.in);

	public static void main(String[] args) {
		int t = 3;
		int d = 4;
		// TODO Auto-generated method stub
		arithmetic(t, d);

	}

	static void arithmetic(int y, int f) {
		System.out.println("Pick a letter: A-add, S-subtract, M-multiply, D-divide");
		char x = in.next().charAt(0);
		switch (x) {
		case 'A':
			System.out.println("Add");
			System.out.println("2 + 2:" + "\n" + (y + f));
			break;
		case 'S':
			System.out.println("Subtract");
			System.out.println("2 - 2:" + "\n" + (y - f));
			break;
		case 'M':
			System.out.println("Multiply");
			System.out.println("2 x 2:" + "\n" + (y * f));
			break;
		case 'D':
			System.out.println("Divide");
			System.out.println("2 / 2:" + "\n" + (y / f));
			break;
		}

	}
}
