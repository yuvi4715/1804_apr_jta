package syntax;
//Kevin Rivera - Revature
//Assignment Week 1: Syntax - Problem 6.
//This program contains examples for control statements (if, if-else, switch-case).

public class Prob_6 {
	public static void main(String[] args) {
		//if statement
		if (true)
			System.out.println("This is an if statement.");
		
		//if-else statement
		if (false)
			System.out.println("It'll never get in here, so, hello mom!");
		else
			System.out.println("Since the previous condition was false, this code is executed.");
		
		//switch-case statement
		int a = 3;
		switch(a) {
		case 1:
			System.out.println("This runs when a = 1");
			break;
		case 2:
			System.out.println("This runs when a = 2");
			break;
		case 3:
			System.out.println("This runs when a = 3");
			break;
		default:
			System.out.println("This runs when all previous cases fail.");
		}
		
	}
}
