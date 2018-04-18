package easyCodingExercises;

import java.util.Scanner;

public class Problem36 {
	
	public static void main(String[] args) {
		
		arithmetic();
	
	}
	
	
	
	
	public static void arithmetic() {
		
		int arg0 = 0;
		int arg1 = 0;
		
		char opp = ' ';
		
		Scanner cin = new Scanner(System.in);
		
		
		System.out.println("Enter an integer: ");
		arg0 = Integer.valueOf(cin.nextLine());
		
		System.out.println("Enter another integer: ");
		arg1 = Integer.valueOf(cin.nextLine());
		
		System.out.println("Print an operatotor: ");
		opp = cin.nextLine().charAt(0);
		
		if (opp == '+') {
			
			
			System.out.println(arg0 + " + " + arg1 + " = " + (arg0 + arg1));
			
		} else if (opp == '-') {
			
			System.out.println(arg0 + " - " + arg1 + " = " + (arg0 - arg1));
			
		} else if (opp == '*') {
			
			System.out.println(arg0 + " * " + arg1 + " = " + (arg0 * arg1));
			
		} else if (opp == '/') {
			
			System.out.println(arg0 + " / " + arg1 + " = " + (arg0 / arg1) + "R" + (arg0%arg1));
			
		} else {
			
			System.out.println("You had one job...");
			
		}
		
		cin.close();
		
		
		
		
		
		
		
		
		
		
		
	}
	
	
	
	
	
	
	

}
