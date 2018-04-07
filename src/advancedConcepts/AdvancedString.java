package advancedConcepts;
/**
 * Dominick Sermeno
 * Batch 1804
 * Q's: 16-20
 */
import java.util.StringTokenizer;

public class AdvancedString 
{
	
	public static void main(String args[])
	{
		StringBuilder sBuilder = new StringBuilder("Race Car");
		reverseStatment(sBuilder);
		replaceCharacters(sBuilder);
		insertString(sBuilder);
		stringTokenizer(); 
		stringAdder("40", "60");
		//exec() could be used to execute the string builder in a new process
		//freeMemory() could be used to determine how much memory our strings are occupying to conserve memory space
		//gc() could be used request the garbage collector to handle unused strings as seen later in this program
	}
	
	
	public static void reverseStatment(StringBuilder sentence)
	{
		System.out.println("Statment: " + sentence);
		sentence = sentence.reverse();
	    System.out.println(" The reverse of this statment is:  " + sentence);	
	    System.gc();
	}
	
	public static void replaceCharacters(StringBuilder sentence)
	{
		System.out.println("Statment: " + sentence);
		sentence = sentence.replace(5, 8, "Truck");
	    System.out.println(" The new statment is:  " + sentence);	
	    System.gc();
	}
	
	public static void insertString(StringBuilder sentence)
	{
		System.out.println("Statment: " + sentence);
		sentence = sentence.insert(5,"Fast");
	    System.out.println(" The new statment is:  " + sentence);	
	    System.gc();
	}
	
	
	public static void stringTokenizer() 
	{
		String token = "May:The:Force:Be:With:You";
		StringTokenizer t = new StringTokenizer(token, ":");
		while (t.hasMoreTokens()) 
		{
			System.out.println(t.nextToken());
		}
	    System.gc();
	}
	 public static void stringAdder(String num1, String num2)
	 {
			int result = ((Integer.parseInt(num1)) + (Integer.parseInt(num2))) ;			
			System.out.println(result);
		    System.gc();
	 }
	
}
