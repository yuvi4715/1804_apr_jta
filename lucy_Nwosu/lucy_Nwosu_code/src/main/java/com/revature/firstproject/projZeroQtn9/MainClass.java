package com.revature.projZeroQtn9;

//Create three objects as follows:
//Animal one = new Human(); 	Mammal two = new Human(); 	Human three = new Human();
//Call each of the methods for each of the objects: eat(), move(), walk(). Note the results.

public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Animal one = new Human();   
		Mammal two = new Human();
		Human three = new Human();
	
		
		
		System.out.println("For Animal interface");
		one.eat(); //it's reference object is of Human Class
		one.move(); // default method in interface
		//one.walk(); this method call will throw compilation error as walk method doesn't exist in interface
		System.out.println();
		
		System.out.println("For Mammal Class");
		two.eat(); //it's reference object is of Human Class
		two.move(); // default method in interface
		two.walk(); //this method is static, so method of reference object wont be called
		System.out.println();
		
		System.out.println("For Human Class");
		three.eat(); //it's reference object is of Human Class
		three.move();// default method in interface
		three.walk();//this method is static, so method of reference object

	}
}
