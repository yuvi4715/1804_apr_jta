package com.revature.questions09;

public interface Animal {

	public default void eat() {
		System.out.println("Animals eat things that are edible.");
	}
	
	public static void move() {
		System.out.println("Animals need to move to get to places.");
		
	}
}
