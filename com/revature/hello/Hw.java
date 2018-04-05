package com.revature.hello;

import com.revature.*;


public class Hw {
	// class Inner{

	// }
	public static void main(String args[]) {
		
		new MultipleArguments();
//		new oop.GiftedPeople();
		// Core Java
		{// 1
			int x = 1 + 2;
			int y = 2 - 3;
			int z = 3 / 5;
			int w = 5 * 7;
			System.out.println("1: finished.");

			// 2
			int ans;
			if ((x > y) && (x > z))
				ans = x;
			else if (y > z)
				ans = y;
			else
				ans = z;
			System.out.println("2:  " + ans);

			System.out.println("3:");
			boolean a = true, b = false;
			System.out.println(!a);
			System.out.println(a | b);
			System.out.println((!a & b) | (a & !b));
		}

		// Syntax
		{
			System.out.println("4:");
			add(1, 2);
			sub(1, 2);
			mult(1, 2);
			div(1, 2);

			// 5
			System.out.println("5:");
			System.out.println(A.add(1, 2));
			A.subtract(1, 2);
			A.multiply(1, 2);
			A.divide(1, 2);

			// 6
			if (true)
				;
			else
				;
			for (int i = 0; i < 5; ++i)
				continue;
			do {
				;
			} while (false);
			char c = 'a';
			switch (c) {
			case 'a':
				break;
			case 'b':
				;
			default:
				;
			}
			int[] i = { 0, 1 };
			for (int x : i)
				++x;

		}
		// Class members
		{
			// 7
			// 8
			Consumer a = new Consumer();
			Consumer b = new Consumer(4);
			a.buy();
			a.buy(2);
			Consumer.tax();
			Consumer.money();

		}
		//{
			// 10
			// Create a custom exception class that overrides the getMessage( ) method
			class NewException extends Exception {
				public String getMessage() {
					return "newException";
				}
			}
			// 11 Create a class that manually throws an exception of your custom type
			 class Foo {
				public void bar() throws NewException {
					throw new NewException();
				}
				
				public String baz() {
					return "Success!";
				}
			}

			// 12 Use System.out.println( ) to note where you are in the control flow. Example:
			
			// “Starting try block”, “Ending try block”, “Starting catch block”, etc.
			// Duck the exception at least once
			// Implement a finally block that prints a graceful goodbye message
			// Use the System.exit(0) command in the try block and rerun the application.
			// Note the console output to see if the finally block executes.
		//}
		
	System.out.println("Called from the inner clas Foo" + new Foo().baz());
		
	}

	// 9
	interface Animal {
		public void eat();

		public void move();
	}

	public static int add(int x, int y) {
		return x + y;
	}

	public static int sub(int x, int y) {
		return x - y;
	}

	public static int mult(int x, int y) {
		return x * y;
	}

	public static int div(int x, int y) {
		return x / y;
	}
}

class A {
	public static int add(int x, int y) {
		return x + y;
	}

	public static int subtract(int x, int y) {
		return x - y;
	}

	public static int multiply(int x, int y) {
		return x * y;
	}

	public static int divide(int x, int y) {
		return x / y;
	}
}

class Consumer {

	final int f = 0;
	static int s = 1;

	public Consumer() {

	}

	public Consumer(int x) {
		;
	}

	public void buy() {

	}

	public void buy(int x) {
		;
	}

	public static int tax() {
		return ++s;
	}

	public static int money() {
		return s;
	}
}
