package com.revature.questions16_20;

public class Question16 {

	public static void main(String[] args) {
		buildStringbuilder();
	}	
	
	
	//Question 16
	public static void buildStringbuilder() {
	
		StringBuilder batman = new StringBuilder("I'm the batman!");
	
		System.out.println(batman);
		
		batman.append(" I drive the batmobile!.");
		System.out.println(batman);
		
		batman.insert(15, " I have a utility belt!");
		System.out.println(batman);
	
		batman.delete(15, 62);
		System.out.println(batman);
	}

}


