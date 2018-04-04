package com.revature.advancedcodingexercises;

public class CharacterReplacement {

	/*
	 * 38. Write a method to replace a given character in a String with another
	 * character.
	 */
	public static void main(String[] args) {
		String toReplace = "Happy";
		System.out.println(toReplace);
		CharacterReplacement ReplaceMe = new CharacterReplacement();
		ReplaceMe.replacer(toReplace);
		System.out.println(toReplace);

	}
	public String replacer(String hi) {
		String hello = hi.substring(0) +'s'+ hi.substring(1);
		return hello;
	}

}
