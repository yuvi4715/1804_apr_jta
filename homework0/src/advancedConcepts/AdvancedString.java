package advancedConcepts;

import java.util.StringTokenizer;

public class AdvancedString 
{
	StringBuilder sBuilder = new StringBuilder("Race Car");
	
	
	public void reverseStatment(StringBuilder sentence)
	{
		System.out.println("Statment: " + sentence);
		sentence = sentence.reverse();
	    System.out.println(" The reverse of this statment is:  " + sentence);	
	    System.gc();
	}
	
	public void replaceCharacters(StringBuilder sentence)
	{
		System.out.println("Statment: " + sentence);
		sentence = sentence.replace(5, 8, "Truck");
	    System.out.println(" The new statment is:  " + sentence);	
	    System.gc();
	}
	
	public void insertString(StringBuilder sentence)
	{
		System.out.println("Statment: " + sentence);
		sentence = sentence.insert(5,"Fast");
	    System.out.println(" The new statment is:  " + sentence);	
	    System.gc();
	}
	
	
	public void stringTokenizer() 
	{
		String token = "May:The:Force:Be:With:You";
		StringTokenizer t = new StringTokenizer(token, ":");
		while (t.hasMoreTokens()) 
		{
			System.out.println(t.nextToken());
		}
	    System.gc();
	}
	 public void stringAdder(String num1, String num2)
	 {
			int result = ((Integer.parseInt(num1)) + (Integer.parseInt(num2))) ;			
			System.out.println(result);
		    System.gc();
	 }
	
}
