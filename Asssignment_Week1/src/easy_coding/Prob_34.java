package easy_coding;
//Kevin Rivera - Revature
//Assignment Week 1: Easy Coding Exercises - Problem 34.
//This class prints the word that corresponds the number.

public class Prob_34 {
	public static void main(String[] args) {
		printNumInWordIfElse(3);
		printNumInWordIfElse(6);
		printNumInWordIfElse(0);
		printNumInWordSwitch(0);
		printNumInWordSwitch(5);
		printNumInWordSwitch(9);
	}

	public static void printNumInWordIfElse(int num) {
		if (num == 0)
			System.out.println("Zero");
		else if (num == 1)
			System.out.println("One");
		else if (num == 2)
			System.out.println("Two");
		else if (num == 3)
			System.out.println("Three");
		else if (num == 4)
			System.out.println("Four");
		else if (num == 5)
			System.out.println("Five");
		else if (num == 6)
			System.out.println("Six");
		else if (num == 7)
			System.out.println("Seven");
		else if (num == 8)
			System.out.println("Eight");
		else if (num == 9)
			System.out.println("Nine");

	}

	public static void printNumInWordSwitch(int num) {
		switch (num) {
		case 0:
			System.out.println("Zero");
			break;
		case 1:
			System.out.println("One");
			break;
		case 2:
			System.out.println("Two");
			break;
		case 3:
			System.out.println("Three");
			break;
		case 4:
			System.out.println("Four");
			break;
		case 5:
			System.out.println("Five");
			break;
		case 6:
			System.out.println("Six");
			break;
		case 7:
			System.out.println("Seven");
			break;
		case 8:
			System.out.println("Eight");
			break;
		case 9:
			System.out.println("Nine");
			break;
		}
	}
}
