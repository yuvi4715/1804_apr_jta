package com.revature.singleton;
//Calendar class, only one connection
public class SingletonExample {
	//private static field instance
	static SingletonExample instance =null;
	
	//private constructor
	private SingletonExample() {}
	
	//public static method that returns instance
	public static SingletonExample getInstance() {
		if(instance==null) {
			instance =new SingletonExample();
		}
		return instance;
	}

}
