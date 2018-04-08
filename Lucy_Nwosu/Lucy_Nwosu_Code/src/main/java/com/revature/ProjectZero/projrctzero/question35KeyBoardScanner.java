
package com.revature.projrctzero;

//Write a program called KeyboardScanner to prompt user for an int, a double, and a String. Print the input onto the console.
import java.util.*;


public class question35KeyBoardScanner {
	
	public static void main(String[] args) {
	
	int a;
	double b;
	String  s;
	
//main method
	
	Scanner sc = new Scanner(System.in);
	
	{
	System.out.println("Enter an integer: ");
	a = sc.nextInt();
	
	
	System.out.println("Enter a double: ");
	b = sc.nextDouble();
	
	
	System.out.println("Enter a string: ");
	s = sc.next();
	
	System.out.println("Integer a is "+a);
	System.out.println("Dobule b is "+b);
	System.out.println("String s is "+s);
	}
	
	sc.close();
	
	}
}
	



