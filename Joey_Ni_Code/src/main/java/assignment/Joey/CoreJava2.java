package assignment.Joey;

import java.util.Scanner;
/**
 * a program to search for the greatest 
 * of three numbers using Short-circuit
 * Operators and print the result.  
 * @author Joey Ni
 *
 */
public class CoreJava2 {
	public static void main(String[]args) {
		System.out.println("Please enter 3 integers separated by space");
		Scanner console = new Scanner(System.in);
		try{
			int x=console.nextInt();
			int y=console.nextInt();
			int z=console.nextInt();
			shortCircuitOp(x,y,z);
		} finally {
			console.close();
		}
		
	}
	
	public static void shortCircuitOp(int x, int y, int z) {
		int largest;
		
		if (x!=y && x>y) largest =x;
		else largest=y;
		if (largest!=z && z>largest) largest=z;
		System.out.println("The largest number is "+largest);
	}
}
