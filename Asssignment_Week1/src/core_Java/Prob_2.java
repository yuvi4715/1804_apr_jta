package core_Java;
//Kevin Rivera - Revature
//Assignment Week 1: Core Java - Problem 2.
//This program finds the greatest out of three numbers using relational operators.

public class Prob_2 {
	public static void main(String[] args) {
		int a = 3;
		int b = 6;
		int c = 2;
		
		if (a > b && a > c)
			System.out.println("a is the greatest number: " + a);
		if (b > a && b > c)
			System.out.println("b is the greatest number: " + b);
		if (c > a && c > b)
			System.out.println("c is the greatest number: " + c);
		
	}
}
