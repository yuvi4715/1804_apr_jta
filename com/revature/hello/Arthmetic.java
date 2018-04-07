package com.revature.hello;

public class Arthmetic {

	public static void main(String[] args) {
		if (args.length != 3) {
			System.out.println("Invalid args[]");
			return;
		}

		// Arithmetic
		float x = Integer.parseInt(args[0]);
		float y = Integer.parseInt(args[1]);
		char op = args[2].charAt(0);
		float result = 0;

		if (op == '+')
			result = x + y;
		else if (op == '-')
			result = x - y;
		else if (op == '*')
			result = x * y;
		else if (op == '/')
			result = x / y;
		System.out.println(result);
	}
}