package com.revature.questions16_20;

import java.util.StringTokenizer;

public class Question17 {

	public static void main(String[] args) {
		tokenStrings();
	}
	
	
	public static void tokenStrings() {
		
		StringTokenizer pizza = new StringTokenizer("cheese tomato crust salami");
		
		while(pizza.hasMoreTokens()) {
			System.out.println(pizza.nextToken());
		}
		
	}
	
	
}
