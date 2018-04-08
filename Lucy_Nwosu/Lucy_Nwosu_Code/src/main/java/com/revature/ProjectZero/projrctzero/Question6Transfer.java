package com.revature.projrctzero;

public class Question6Transfer {
	
	
	//TRANSFER STATEMENTS
	
	//continue
	
	public static void main(String[] args) {
  
		System.out.println("Odd Numbers");
		for (int i = 1; i <= 10; ++i) {
			if (i % 2 == 0)
				continue;
			// Rest of loop body skipped when i is even
			System.out.println(i + "\t");
		}
		
		System.out.println("Numbers 1 - 10");
		for (int i = 1;; ++i) {
			if (i == 11)
				break;
			// Rest of loop body skipped when i is even
			System.out.println(i + "\t");
	}
	
	}

}
