package assignment.Joey.EasyCodingProgram;

import java.util.Scanner;

/**5. Write a program called Arithmetic that takes three command-line arguments: 
 * two integers followed by an arithmetic operator (+, -, * or /).
 *  The program shall perform the corresponding operation on the two integers 
 *  and print the result.
 * @author joeyi
 *
 */

public class Arithmetic {
	public static void main(String[] args) {
		Integer arg1=null;
		Integer arg2=null;
		String operator=null;
		Integer result;
		Scanner readIn = new Scanner(System.in);
		if (readIn.hasNextInt()) arg1 = readIn.nextInt();
		if (readIn.hasNextInt()) arg2 = readIn.nextInt();
		if (readIn.hasNext()) operator = readIn.next();
		switch(operator)
		{
		case "+": result=arg1+arg2; break;
		case "-": result=arg1-arg2; break;
		case "*": result=arg1*arg2; break;
		case "/": result=arg1/arg2; break;
		default: result=null; System.out.println("Invalid operator input. Separate by space");
		}
		System.out.println("Result:" +result);
		
		readIn.close();
	}
}
