//Write a program to search for the greatest of three numbers using Short-circuit Operators and print the result. 

package CoreJava;
import java.util.Scanner;

public class question2 {
	// ???
	private static Scanner in;

	public static void main(String args[])
   {
      int x, y, z;
      System.out.println("Enter three integers ");
      // ???
      in = new Scanner(System.in);
 
      x = in.nextInt();
      y = in.nextInt();
      z = in.nextInt();
 
      if ( x >= y && x >= z )
         System.out.println(x);
      else if ( y >= x && y >= z )
         System.out.println(y);
      else if ( z >= x && z >= y )
         System.out.println(z);
      else   
         System.out.println("Please try again.");
   }
}
