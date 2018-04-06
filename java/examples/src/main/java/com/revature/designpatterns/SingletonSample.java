package com.revature.designpatterns;

public class SingletonSample {

	//private static field
	private static SingletonSample instance = null;
	
	//private constructor
	private SingletonSample() {
	}
	
	//static method
	public static SingletonSample getInstance() {
		if(instance ==null) {
			instance = new SingletonSample();
		}
		return instance;
	}
}
