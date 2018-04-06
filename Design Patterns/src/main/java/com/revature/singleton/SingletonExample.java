package com.revature.singleton;

public class SingletonExample {

	/*
	 * Singleton Design Pattern: Used to enforce that only one instance of an object may occur at a time
	 * 
	 * Singleton design pattern requires 3 things: 
	 * 		- Private static reference of the class type, often declared as 'instance'
	 * 		- Private constructor
	 * 		- public static method that returns class type, often named 'getInstance()'
	 */
	
	//Requirement 1: private static member variable
	private static SingletonExample instance;
	
	//Requirement 2: private constructor
	private SingletonExample() {}
	
	//Requirement 3: public static method that returns the same instance of the class
	public static SingletonExample getInstance() {
		if (instance == null) {
			instance = new SingletonExample();
		}
		return instance;
	}
	
	public static void main(String[] args) {
		SingletonExample ex1 = SingletonExample.getInstance();
		SingletonExample ex2 = SingletonExample.getInstance();
		
		if (ex1.hashCode() == ex2.hashCode()) {
			System.out.println("Yep, they are the same instance");
		} else {
			System.out.println("Noooope, they arent equal");
		}
	}
	
}
