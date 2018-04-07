package com.revature.questions46_68;

public class Question57 {

	public static void main(String[] args) {

		String a1 = "madam";
		String a2 = "Madam";
		String a3 = "matey 111";
		String a4 = "m a d a m";
		String a5 = "madam111";
				
		System.out.println(checkPalindrome(a1));
		System.out.println(checkPalindrome(a2));
		System.out.println(checkPalindrome(a3));
		System.out.println(checkPalindrome(a4));
		System.out.println(checkPalindrome(a5));
	}
	
	public static boolean checkPalindrome(String temp) {
		
		StringBuilder temp1 = new StringBuilder(temp);
		StringBuilder temp2 = new StringBuilder(temp1.reverse());
		temp1.reverse();

		String temp3 = temp1.toString();
		String temp4 = temp2.toString();

		if(temp3.equals(temp4)) {
			return true;
		}else {
			return false;
		}

	}
	
	
}
