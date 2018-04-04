package com.revature.oop;

// Part of the solution to hw1 problem #9

public abstract class Mammal implements Animal {

	public void eat() {
		System.out.println("Some mammals are herbivores that only eat plants, "
				+ "others are carnivores that only eat meat, and some are omnivores "
				+ "that eat both.");
	}

	public static void walk() {
		System.out.println("Most mammals walk on 4 legs, some walk on two, others dont walk at all.");
	}
}
