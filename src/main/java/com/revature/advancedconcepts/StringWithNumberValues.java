package com.revature.advancedconcepts;

public class StringWithNumberValues {
	public static void main(String[] args) {
		/*
		 * 18. Create two String objects with number values (i.e. “20). Write a method
		 * that adds the two.
		 */
		StringWithNumberValues Adder = new StringWithNumberValues();
		String triangle = Integer.toString(3);
		System.out.println(triangle);
		String square = Integer.toString(4);
		System.out.println(square);

		Adder.addStringValues(triangle, square);

	}

	public int addStringValues(String StringValue1, String StringValue2) {
		int StringValue;
		StringValue = Integer.parseInt(StringValue1) + Integer.parseInt(StringValue2);
		System.out.println(StringValue);

		// 19. Request garbage collection in your method.
		System.gc();
		return StringValue;
	}

}
