package com.revature.syntax;

public class ControlFlow {
	public static void main(String[] args) {
		
		// if/else if/else
		
		String name = "Daredevil";
		if (name == "Daredevil") {
			System.out.println("The name is Daredevil");
		} else if (name == "Jessica Jones") {
			System.out.println("The name is Jessica Jones");
		} else {
			System.out.println("The name is something else");
		}
		
		// For Loop
		
		System.out.println("For Loop");
		for (int i = 0 ; i < 3 ; i++) {
			System.out.println(i);
		}
		
		// Enhanced For Loop
		
		System.out.println("Enhanced For Loop");
		int[] arr = {1, 2, 3, 4, 5};
		for (int n : arr) {
			System.out.println(n);
		}
		
		// while loop
		
		int i = 0;
		while (i < 10) {
			System.out.println(i);
			i += 1;
		}
		
		// do-while loop 
		
		int count = 0;
		do {
			System.out.println("This will print at least once");
			count -= 1;
		} while (count > 0);

		// switch statements 
		
		String girlfriend = "Elektra";
		switch(girlfriend) {
		case "Sarah":
			System.out.println("The girlfriends name is Sarah");
			break;
		case "Elektra":
			System.out.println("The girlfriends name is Elektra");
			break;
		default:
			System.out.println("The girlfriends name is something else");
			break;
		}
		
	}
	
	
}
