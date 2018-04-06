package easyCodingExcersizes;
//34 - use nested if and switch to print out the string version of number entered.
import java.util.Scanner;

public class PrintNumberInWord {
	
	static int number;
	
	static void wordByIf() {
		System.out.println("By if statements");
		if (number == 1) {
			System.out.println("ONE");
		}else if (number == 2) {
			System.out.println("TWO");
		}if (number == 3) {
			System.out.println("THREE");
		}else if (number == 4) {
			System.out.println("FOUR");
		}if (number == 5) {
			System.out.println("FIVE");
		}else if (number == 6) {
			System.out.println("SIX");
		}if (number == 7) {
			System.out.println("SEVEN");
		}else if (number == 8) {
			System.out.println("EIGHT");
		}if (number == 9) {
			System.out.println("NINE");
		}else {
			System.out.println("Other");
		}
		
	}
	
	static void wordBySwitch() {
		System.out.println("By Switch method");
		switch (number ) {
		case 1:
			System.out.println("ONE");
			break;
		case 2:
			System.out.println("TWO");
			break;
		case 3:
			System.out.println("THREE");
			break;
		case 4:
			System.out.println("FOUR");
			break;
		case 5:
			System.out.println("FIVE");
			break;
		case 6:
			System.out.println("SIX");
			break;
		case 7:
			System.out.println("SEVEN");
			break;
		case 8:
			System.out.println("EIGHT");
			break;
		case 9:
			System.out.println("NINE");
			break;
		default:
			System.out.println("OTHER");
		}
		
		
	}
	
	public static void main(String[] args) {
		System.out.println("Enter a number from 1 to 9");
		Scanner k = new Scanner(System.in);
		number = k.nextInt();
		k.close();
		wordByIf();
		wordBySwitch();
	}

}
