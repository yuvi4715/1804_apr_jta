//John Eifert
package Easy_Coding_Exercises;

import java.util.Scanner;

public class Q35KeyboardScanner
{
	public static void main(String args[])
	{
		Scanner in = new Scanner(System.in);
		
		System.out.print("Give me an int: ");
		int i=Integer.parseInt(in.nextLine());
		System.out.println(i);
		
		System.out.print("Give me a double: ");
		double d=Double.parseDouble(in.nextLine());
		System.out.println(d);
		
		System.out.print("Give me a string: ");
		String s=in.nextLine();
		System.out.println(s);
		
		in.close();
	}
}
