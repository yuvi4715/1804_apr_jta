package syntax;
//Kevin Rivera - Revature
//Assignment Week 1: Syntax - Problem 4.
//This program does the 4 basic operations using methods in a single class.

public class Prob_4 {
	public static void main(String[] args) {
		int a = 4;
		int b = 2;
		System.out.println(Prob_4.add(a, b));
		System.out.println(Prob_4.sub(a, b));
		System.out.println(Prob_4.mult(a, b));
		System.out.println(Prob_4.div(a, b));
	}
	
	public static int add(int x, int y) {
		return x + y;
	}
	
	public static int sub(int x, int y) {
		return x - y;
	}
	
	public static int mult(int x, int y) {
		return x*y;
	}
	
	public static int div(int x, int y) {
		return x/y;
	}
}
