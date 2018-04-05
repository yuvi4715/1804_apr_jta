package easy_coding_exercises;

import java.util.InputMismatchException;
import java.util.Scanner;

public class KeyboardScanner {
	
	static int i;
	static double d;
	static String s;
	static boolean done = false;
	
	public static void main(String[] args) {
		
		while (!done) {
			try {
				Scanner in = new Scanner(System.in);
				System.out.print("Please enter an integer: ");
				i = in.nextInt();
				System.out.print("Please enter a double: ");
				d = in.nextDouble();
				System.out.print("Please enter a String: ");
				s = in.next();
				done = true;
			} catch (InputMismatchException e) {
				System.out.println("Invalid input!");
			}
		}
		System.out.println("You entered the following: ");
		System.out.println(i);
		System.out.println(d);
		System.out.println(s);
	}
}
