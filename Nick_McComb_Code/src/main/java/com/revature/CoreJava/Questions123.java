package com.revature.CoreJava;

public class Questions123 {
	
	public static void main(String[] args) {
		System.out.println("Question 1:");
		int x = 5+5;
		System.out.println("5 plus 5 is " + x);
		x = 5-5;
		System.out.println("5 minus 5 is " + x);
		x = 5*5;
		System.out.println("5 times 5 is " + x);
		double y = 5.0/5.0;
		System.out.println("5 divided by 5 is " + y);
		
		System.out.println("\nQuestion 2:");
		String words[] = {"Hello", "Goodbye", "Words"};
		for(int i = 0; i < words.length; i++) {
			System.out.println(words[i]);
		}
		
		for(String s : words) {
			System.out.println(s);
		}
		
		int r = 0;
		while(r < 10) {
			System.out.println(r);
			r++;
		}

		r = 0;
		do {
			System.out.println(r);
			r++;	
		} while (r < 10);
		
		System.out.println("\nQuestion 3:");
		boolean a = true;
		boolean b = false;
		System.out.println(!a);
		System.out.println(a || b);
		System.out.println((!a&&b) || (a&&!b));
	}
	
}
