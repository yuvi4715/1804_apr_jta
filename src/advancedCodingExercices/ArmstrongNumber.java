package advancedCodingExercices;
/**
 * Dominick Sermeno
 * Batch 1804
 * Q's: 43
 */
import java.util.Scanner;

public class ArmstrongNumber 
{
	public static void main(String[] args) 
	{
	   Scanner scan = new Scanner(System.in);
	   System.out.println("Please enter an integer.");
	   int num = scan.nextInt();
	   int armstrong = num;
	   int check = 0;
       int base = 1;
       int range = 0;
       int length = (int)(Math.log10(num)+1);
       while( num > 0)
       {   
    	   range = num % 10;
           num = num / 10;
           for(int i = 1; i <= length; ++i)
           {
                 base = base * range;
           }
           check = check + base;
           base = 1;
       }
       if( check == armstrong)
       {
    	   System.out.println(armstrong + " is an amstrong number");
       }
       else
       {
            System.out.println(armstrong +  " is not an amstrong number");
       }
       scan.close();///always close resources 
    }
}
