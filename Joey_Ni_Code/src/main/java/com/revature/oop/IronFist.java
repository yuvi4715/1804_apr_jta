package com.revature.oop;

public class IronFist {

	public IronFist() {
		super();
		// TODO Auto-generated constructor stub
		System.out.println("IF - default constructor");
	}
	
	public IronFist(boolean rich){
		System.out.println("IF - 1 param constructor");
	}
	
	public IronFist(boolean rich, String name){
		System.out.println("Iron Fist is rich and his name is " +name);
	}

}
