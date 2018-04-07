package advanced_coding;
//Kevin Rivera - Revature
//Assignment Week 1: Advanced Coding: Problem 38.
//This class replaces a given character in a string, with another character.

public class Prob_38 {
	public static void main(String[] args) {
		String example = "This is a test";
		char oldChar = 's';
		char newChar = 'Z';
		
		System.out.println("Original: " + example);
		example = replaceChar(oldChar, example, newChar);
		System.out.println("New: " + example);
	}
	public static String replaceChar(char oldChar, String str, char newChar) {
		return str.replace(oldChar, newChar);
	}
}
