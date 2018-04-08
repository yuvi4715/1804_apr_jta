package com.advancedcode.work;

public class ReverseString {

	public static void main(String[] args) {

		String str = "Hello world";
		char[] ch = str.toCharArray();
		int max = ch.length;
		
		for(int i = max; i >0; i--) {
			System.out.print(ch[i-1]);
		}

	}

}
