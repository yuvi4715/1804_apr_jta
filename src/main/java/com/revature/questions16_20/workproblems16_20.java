package com.revature.questions16_20;

import java.util.StringTokenizer;

public class workproblems16_20 {

	
	public static void main(String[] args) {
		
		//buildStringbuilder();
		//tokenStrings();
		//addStrings();
		//requestGarbageman();
		//
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
	
	//Question 17
	public static void tokenStrings() {
		
		StringTokenizer pizza = new StringTokenizer("cheese tomato crust salami");
		
		while(pizza.hasMoreTokens()) {
			System.out.println(pizza.nextToken());
		}
		
	}

	//Question 18
	public static void addStrings() {
		
		String a = "77";
		String b = "50";
		
		System.out.println(Integer.parseInt(a) + Integer.parseInt(b));
	}
	
	//Question 19
	public static void requestGarbageman() {
		System.gc();
	}
	
	
	public static void runtimeStuff() {
	//	Runtime running = Runtime
	}

	
}

