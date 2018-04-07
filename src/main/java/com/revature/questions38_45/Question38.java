package com.revature.questions38_45;

public class Question38 {

	public static void main(String[] args) {
		String hero = "I'm the Batman!";
		char oldchar = 'B';
		char newchar = 'C';
		hero = redundantStringReplace( oldchar, newchar,hero); //Replace the B in Batman with C to make him Catman
		System.out.println(hero);
		
	}
	
	
	public static String redundantStringReplace(char oldchar, char newchar, String replacedstr) {
		
		String s = replacedstr.replace(oldchar, newchar);
		return s;
	}
}
