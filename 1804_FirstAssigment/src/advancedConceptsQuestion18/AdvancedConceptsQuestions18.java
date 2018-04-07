package advancedConceptsQuestion18;

import java.io.PrintStream;


//Create two String objects with number values (i.e. “20"). 
//Write a method that adds the two.

public class AdvancedConceptsQuestions18 
{

	public static void main(String[] args) 
	
	{
		AddStrings(System.out);
	}
	
	public static void AddStrings(PrintStream out) 
	{
		
		String x = "400",y = "500";
		int Integer1 = Integer.parseInt(x);
		int Integer2 = Integer.parseInt(y);
		
		out.println("Totals: "+(Integer1+Integer2));
		
	}
	
	
}
