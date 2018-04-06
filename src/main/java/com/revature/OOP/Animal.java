package com.revature.OOP;

public interface Animal {

	abstract void eat();
	default void move() {
		System.out.println("Animal is moving to new location.");
	}

}
