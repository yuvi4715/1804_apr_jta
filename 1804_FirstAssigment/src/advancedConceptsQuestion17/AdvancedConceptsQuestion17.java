package advancedConceptsQuestion17;

import java.io.PrintStream;
import java.util.StringTokenizer;

//Create a new String with delimited tokens, 
//such as “pickles:ketchup:mustard:onion” and 
//use StringTokenizer to parse out and print each token.


public class AdvancedConceptsQuestion17 
{

	public static void main(String[] args) 
	{
		
		Test1(System.out);
		
		
	}
	
	public static void Test1 (PrintStream out) 
	{
		
		String str = "pickles:ketchup:mustard:onion";
		StringTokenizer tokenizer = new StringTokenizer(str, ":");
		
		while(tokenizer.hasMoreElements())
		{	
			System.out.println(tokenizer.nextToken());
		}
		
			
	}
	
	
	
	
}
