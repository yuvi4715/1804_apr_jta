package com.revature.advancedconcepts;


//problems 16-20
public class StringProblems {

	public static void main(String[] args) {
		StringBuilder str = new StringBuilder("String Builder");
		System.out.println(str);
		
		str.append(" append");
		System.out.println(str);
		
	
		str.setCharAt(str.lastIndexOf("a", str.length()), 'A');
		System.out.println(str);
		
		str.deleteCharAt(str.length()-1);
		System.out.println(str);
		
		
		
		
		
		
	}

}
