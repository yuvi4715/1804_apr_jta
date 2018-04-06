package com.revature.advancedcodingexercises;

public class CharacterReplacement {

	/*
	 * 38. Write a method to replace a given character in a String with another
	 * character.
	 */
	public static void main(String[] args) {
		String toReplace = "Happy";
		System.out.println("The first string: " + toReplace);
		CharacterReplacement ReplaceMe = new CharacterReplacement();
		ReplaceMe.replacer(toReplace);

	}
	public void replacer(String hi) {
		String hello = 'S'+ hi.substring(1);
		System.out.println("The string after replacing: " + hello);
	}

}
