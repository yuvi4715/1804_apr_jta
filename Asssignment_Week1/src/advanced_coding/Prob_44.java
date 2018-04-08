package advanced_coding;
//Kevin Rivera - Revature
//Assignment Week 1: Advanced Coding: Problem 44.
//This class reverses a String without using API functions

public class Prob_44 {
	public static void main(String[] args) {
		String str = "Hola";
		System.out.println(str);
		str = reverse(str);
		System.out.println(str);
	}
	
	public static String reverse(String str) {
		String newString = "";
		for (int i = 0; i < str.length(); i++) {
			newString = newString + str.charAt(str.length() - i - 1);
		}
		
		return newString;
	}
}
