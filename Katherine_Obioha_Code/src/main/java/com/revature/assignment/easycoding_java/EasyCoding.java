package easycoding_java;

import java.util.Scanner;
/**
 * 
 * @author katherine Obioha
 * 
 * Question 32 - 37
 * CheckpassFail - Pass if int mark variable greater or equals to 50 Fail if less than 50
 * CheckOdddEven - is the number odd or even
 * PrintANumberInWord
 * KeyBoardScanner
 * Arithemetic -- take three command-line arguments: two integers followed by an arithmetic operator (+, -, * or /). 
 * 				  The program shall perform the corresponding operation on the two integers and print the result.
 * GradeStatistics -- which reads in n grades (of int between 0 and 100, inclusive) and displays the average, minimum, maximum,
 * 					  and standard deviation. Your program shall check for valid input. 
 */
public class EasyCoding {

	Scanner in = new Scanner(System.in);

	public static void main(String[] args) // assuming args is of size 3

	{
		// TODO Auto-generated method stub
		EasyCoding e = new EasyCoding();
		System.out.println("Printing numbers in words");
		e.printnumberinword();
		System.out.println("");
		System.out.println("Check if number is odd or even");
		e.checkoddeven();
		System.out.println("");
		System.out.println("Check Pass or Fail with user input");
		e.checkpassfail();
		System.out.println("");
		System.out.println("Read user input");
		e.KeyboardScanner();
		// e.Arithmetic(args[0], args[1], args[2]); //assumption method
		System.out.println("");
		System.out.println("Perform some statistics operation");
		e.GradesStatistics();

	}

	public void checkpassfail() {
		System.out.println("Please insert an integer");
		int mark = in.nextInt();
		if (mark >= 50) {
			System.out.println("PASS");
		} else {
			System.out.println("FAIL");
		}
	}

	public void checkoddeven() {
		System.out.println("Please insert an integer");
		int number = in.nextInt();
		if ((number % 2) == 0) {
			System.out.println("EVEN");
		} else {
			System.out.println("ODD");
		}
	}

	public void printnumberinword() {

		for (int i = 0; i < 3; i++) {
			System.out.println("Please insert an integer");

			int number = in.nextInt();

			switch (number) {

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
			case 10:
				System.out.println("TEN");
				break;
			default:
				System.out.println("OTHER");
				break;
			}

		}
		System.out.println("Going to nested-if function");
		for (int i = 0; i < 2; i++) {
			System.out.println("Please insert an integer");
			int number = in.nextInt();

			if (number <= 9) {
				if (number == 1) {
					System.out.println("ONE");
				} else if (number == 2) {
					System.out.println("TWO");
				} else if (number == 3) {
					System.out.println("THREE");
				} else if (number == 4) {
					System.out.println("FOUR");
				} else if (number == 5) {
					System.out.println("FIVE");
				} else if (number == 6) {
					System.out.println("SIX");
				} else if (number == 7) {
					System.out.println("SEVEN");
				} else if (number == 8) {
					System.out.println("EIGHT");
				} else if (number == 9) {
					System.out.println("NINE");
				}
			} else {
				System.out.println("OTHER");
			}

		}
	}

	public void KeyboardScanner() {
		System.out.println("Please insert an integer");
		int u = in.nextInt();
		System.out.println("Please insert a double");
		double q = in.nextDouble();
		System.out.println("Please insert a string");
		String a = in.next();

		System.out.println("Integer: " + u + " " + "Double: " + q + " " + "String: " + a);
	}

	public void Arithmetic(String numbera, String numberb, String operator) {
		int number1 = Integer.parseInt(numbera);
		int number2 = Integer.parseInt(numberb);
		if (operator.equals("+")) {
			System.out.println(number1 + number2);
		}
		if (operator.equals("-")) {
			System.out.println(number1 - number2);
		}
		if (operator.equals("*")) {
			System.out.println(number1 * number2);
		}
		if (operator.equals("/")) {
			System.out.println(number1 / number2);
		}
	}

	public void GradesStatistics() {
		System.out.println("Please input 4 numbers between 0 and 100");
		int number[] = new int[4];
		for (int i = 0; i < 4; i++) {
			number[i] = in.nextInt();
		}
		double r = average(number);
		minimum(number);
		maximum(number);
		standarddev(number, r);
	}

	// population standard
	private void standarddev(int[] number, double d) {
		// TODO Auto-generated method stub

		int sum = 0;

		for (int i = 0; i < number.length; i++) {
			sum += (Math.pow((number[i] - d), 2));
		}

		System.out.println(Math.sqrt((sum / number.length)));
	}

	private void maximum(int[] number) {
		// TODO Auto-generated method stub
		int max = 0;
		for (int i = 0; i < 4; i++) {
			if (number[i] > max) {
				max = number[i];
			}
		}
		System.out.println("Maximum: " + max);
	}

	private void minimum(int[] number) {
		// TODO Auto-generated method stub
		int min = 1000;
		for (int i = 0; i < 4; i++) {
			if (number[i] < min) {
				min = number[i];
			}
		}
		System.out.println("Minimum: " + min);
	}

	private double average(int[] number) {
		// TODO Auto-generated method stub
		double sum = 0;
		for (int i = 0; i < number.length; i++) {
			sum = sum + number[i];
		}
		System.out.println("Average: " + (double) (sum / number.length));
		return (double) (sum / number.length);
	}
}
