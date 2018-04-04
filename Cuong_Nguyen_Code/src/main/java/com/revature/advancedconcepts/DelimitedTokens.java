package com.revature.advancedconcepts;

import java.util.StringTokenizer;

public class DelimitedTokens {
	/*
	 * 17. Create a new String with delimited tokens, such as
	 * “pickles:ketchup:mustard:onion” and use StringTokenizer to parse out and
	 * print each token.
	 */
	public static void main(String[] args) {

		String separateit = "pickles:ketchup:mustard:onion";
		StringTokenizer delimitedTokens = new StringTokenizer(separateit, ":");
		while (delimitedTokens.hasMoreTokens()) {
			System.out.println(delimitedTokens.nextToken());
		}
	}
}
