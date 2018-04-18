package com.revature.Homework.ProblemNine;

import java.io.PrintStream;

public class ProblemNineMain {
	public static void main(String[] args) {
		test01(System.out);
	}
	public static void test01(PrintStream out) {
		Animal one = new Human();
		Mammal two = new Human();
		Human three = new Human();
		
		one.eat(out);
		one.move(out);
		
		two.eat(out);
		two.move(out);
		two.walk(out);
		
		three.eat(out);
		three.move(out);
		three.walk(out);
	}
}
