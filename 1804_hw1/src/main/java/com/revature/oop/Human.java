package com.revature.oop;

// Part of the solution to hw1 problem #9

public class Human extends Mammal implements Animal {

	public void move() {
		System.out.println("Humans can move many ways, usually by walking or travelling in vehicles.");		
	}
	
	public void eat() {
		System.out.println("Humans are omnivores that eat both plants and meat.");
	}
	
	public static void walk() {
		System.out.println("Humans walk on 2 legs.");
	}
		
}
