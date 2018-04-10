package com.revatureadvancedcoding;

//problem 44
public class StringReverse {

	public static void main(String[] args) {
		String s = "hello";
		System.out.println(s);
		s = ReplaceCharacter(s);
		System.out.println(s);
	}
	
	public static String ReplaceCharacter (String s) {
		char[] charArray = s.toCharArray();
		char[] temp = new char [s.length()];
		
		
		for(int i=0; i< charArray.length; i++) {
			temp[i] = charArray[charArray.length-1-i];
		}
		
		s = String.valueOf(temp);
		
		
		return s;
	}

}
