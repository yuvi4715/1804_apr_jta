package advancedcoding_java;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 * 
 * @author katherine Obioha
 * 
 * 
 *
 */
public class AdvancedCodingOne {

	static Scanner in = new Scanner(System.in);

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AdvancedCodingOne one = new AdvancedCodingOne();

		System.out.println("Replace a given String: Ten");
		one.replacestring();

		System.out.println();
		System.out.println("If number is a multiple of 3 print Fizz, multiple of 5 print Buzz, "
				+ "multiole of 5 and 3 print FIZZBUZZ");
		one.fizzBuzz();

		System.out.println();
		System.out.println("Reverse A String");
		one.reverseString();

		System.out.println();
		System.out.println("Enter a number to check if it is a Prime number");
		int y = in.nextInt();
		boolean t = one.PrimeNumber(y);
		System.out.println(y + " " + " is Prime: " + t);

		System.out.println();
		System.out.println("Enter a number to check if it is an armstrong number or not");
		int q = in.nextInt();
		one.armstrong(q);

		System.out.println();
		System.out.println("Check if its your birthday");
		one.Calendarcheck(2018, 03, 1); //year,month, date - for testing
		
		System.out.println("");
		System.out.println("Print Fibonacci sequence using both recursive and iteration");
		one.fibonacci();

		System.out.println();
		System.out.println("Using recursion");
		for (int i = 0; i < 100; i++) {
			System.out.println(fibonnacciRecursion(i));
		}
	}

	public void replacestring() {
		String ten = "Ten";
		String edit = ten.replace('e', 'o');
		System.out.println(edit);
	}

	public void Calendarcheck(int n, int y, int t) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy MMM dd HH:mm:ss");
		Calendar ob = new GregorianCalendar(n, y, t);
		Date d = new Date();
		
		String b = sdf.format(ob.getTime());
		String a = sdf.format(d.getTime());
		// use a string token to parse each individual string

		String[] birthday = new String[4];
		String[] actualdate = new String[4];

		StringTokenizer tokenizer = new StringTokenizer(b, " ");
		int i = 0;
		while (tokenizer.hasMoreTokens()) {
			birthday[i] = tokenizer.nextToken();
			i++;

		}
		StringTokenizer tokenizer1 = new StringTokenizer(a, " ");
		int h = 0;
		while (tokenizer1.hasMoreTokens()) {
			actualdate[h] = tokenizer1.nextToken();
			h++;
		}
		
		if (birthday[1].equals(actualdate[1])) {
			
			if (birthday[2].equals(actualdate[2])) {
				
				String u = "Happy Birthday to you, ";
				
				System.out.println(u + u + u + u + "!");
			}
			else {
				System.out.println("Not your birthday, sorry");
			}
			
		} else {
			
			System.out.println("Not your birthday, sorry");
		}

	}

	public void fibonacci() {
		System.out.println("Using Iteration");
		int t = 0;
		int w = 1;
		int d = 1;
		System.out.println(t);
		for (int i = 0; i < 100; i++) {
			t = w;
			w = d;
			d = t + w;
			System.out.println(t);
		}

	}

	static int fibonnacciRecursion(int n) {

		if ((n == 1) || (n == 0)) {

			return n;
		}
		return fibonnacciRecursion(n - 1) + fibonnacciRecursion(n - 2);

	}

	public void fizzBuzz() {
		System.out.println("From 1 - 50");
		for (int i = 1; i <= 50; i++) {
			if (i % (5 * 3) == 0) {
				System.out.println(i + " " + "FizzBuzz");
			} else if (i % 3 == 0) {
				System.out.println(i + " " + "Fizz");
			} else if (i % 5 == 0) {
				System.out.println(i + " " + "Buzz");
			} else {
				System.out.println(i);
			}
		}
	}

	public void reverseString() {
		StringBuilder n = new StringBuilder();
		System.out.println("ReverseMe");
		String e = "ReverseMe";
		for (int i = e.length() - 1; i >= 0; i--) {
			n.append(e.charAt(i));
		}
		System.out.println(n.toString());
	}

	public boolean PrimeNumber(int n) {
		if (n == 2) {
			return true;
		} else if (n % 2 == 0) {
			return false;
		} else {
			for (int i = 3; i * i <= n; i += 2) {
				if (n % i == 0) {
					return false;
				}
			}
		}
		return true;
	}

	public void armstrong(int t) {

		int n = t;
		int[] a = new int[3];
		int i = 0;
		while (n > 0) {
			System.out.println(n % 10);
			a[i] = n % 10;
			n = n / 10;
			i++;
		}

		System.out.println(a[0] + "" + a[1] + "" + a[2]);

		if (((int) (Math.pow((a[0]), 3) + Math.pow((a[1]), 3) + Math.pow((a[2]), 3))) == t) {

			System.out.println("It is an armstrong number");
		} else {
			System.out.println("It is not an armstrong number");
		}

	}

}
