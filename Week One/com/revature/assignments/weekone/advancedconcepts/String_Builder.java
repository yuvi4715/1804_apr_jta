package com.revature.assignments.weekone.advancedconcepts;

public class String_Builder {

	public String_Builder() {
		// TODO Auto-generated constructor stub
	}
	//// Q16
	// Use Three StringBuilder Methods
	public static String stringBuilder() {
		StringBuilder temp = new StringBuilder("This is a String made with StringBuilder");
		int capacity  = temp.capacity();
		StringBuilder pmet = temp.reverse();
		return pmet.toString();
		
	}
}
