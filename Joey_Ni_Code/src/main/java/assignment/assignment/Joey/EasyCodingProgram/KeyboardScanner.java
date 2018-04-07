package assignment.Joey.EasyCodingProgram;

import java.util.Scanner;

/**4. Write a program called KeyboardScanner
 *  to prompt user for an int, a double, and a String. 
 *  Print the input onto the console.
 * @author joeyi
 *
 */

public class KeyboardScanner{
	public static void main(String[] args) {
		
		Scanner sc =new Scanner(System.in);
		System.out.println("Enter an int");
		if(sc.hasNextInt()) System.out.println(sc.nextInt());
		System.out.println("Enter a double");
		if(sc.hasNextDouble()) System.out.println(sc.nextDouble());
		System.out.println("Enter a String");
		System.out.println(sc.next());
		sc.close();
	}
	
	

}
