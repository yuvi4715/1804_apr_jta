package com.revature.reflection;

public class ReflectionExample {

	public static void main(String[] args) {
		
		ReflectionExample re = new ReflectionExample();
		Runtime run = Runtime.getRuntime();
		
		System.out.println(run.freeMemory());
		System.out.println(run.totalMemory());
		System.out.println(run.maxMemory());
		System.out.println(run.availableProcessors());

		//approach 1
		System.out.println(re.getClass().getName());
		
		//approach 2
		try {
			Class<?> c = Class.forName("com.revature.reflection.ReflectionExample");
			System.out.println(c.getName());
			System.out.println(c.isInterface());
			System.out.println(c.isEnum());
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		//approach 3
		//.class
		
	}

}
