package com.revature.assignments.weekone.advancedcodingexercises;

public class ReplaceCharInString {

	public ReplaceCharInString() {
		// TODO Auto-generated constructor stub
	}

	public static String replace(String oringialString, char tobeReplaced, char tobeReplacedWith) {
		char[] temp = oringialString.toCharArray();
		for (int i = 0; i < oringialString.length(); i++) {
			if (temp[i] == tobeReplaced)
				temp[i] = tobeReplacedWith;
		}
		
		return String.copyValueOf(temp);

	}

	public static void main(String[] args) {
		System.out.println(replace("Today is Thursday", 'a', 'u'));
	}

}
