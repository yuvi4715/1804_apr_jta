package com.revature.bonus;

// Solution to hw1 bonus problem #49

public class Substring {
	
	/**
	 * 
	 * @param s
	 * @param idx
	 * @return Accepts a string and an index as parameters and will return a string
	 * 			that contains characters from index idx to the end of the string 
	 */
	public static String substring(String s, int idx) {
		
		char[] sArray = s.toCharArray();
		String subS = "";
		
		for (int i = idx; i < s.length(); i++) {
			
			subS += sArray[i];
		}
		
		return subS;
	}
	
	public static String substring(String s, int startIdx, int endIdx) {
		
		char[] sArray = s.toCharArray();
		String subS = "";
		
		for (int i = startIdx; i <= endIdx; i++) {
			
			subS += sArray[i];
		}
		
		return subS;
	}


	public static void main(String[] args) {
		
		//test substring method
		String test = "This is a test!";
		
		System.out.println(substring(test, 6));
		System.out.println(substring(test, 3, 10));
	}
}
