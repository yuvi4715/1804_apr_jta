package com.revature.advancedcoding;

public class CharReplace {
//problem 38
	public static void main(String[] args) {
		String s = "hello";
		char x = 'l';
		char c = 'z';
		System.out.println(s);
		s = ReplaceCharacter(s, c, x);
		System.out.println(s);
	}
	
	public static String ReplaceCharacter (String s, char c, char x) {
		char[] charArray = s.toCharArray();
		
		for(int i=0; i< charArray.length; i++) {
			if(charArray[i] == x) {
				charArray[i] = c;
			}
		}
		
		s = String.valueOf(charArray);
		
		
		return s;
	}
}
