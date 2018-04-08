//John Eifert
package Advanced_Concepts;

import java.util.StringTokenizer;

public class Q17 
{
	public static void main(String args[])
	{
		String thing="pickles:ketchup:mustard:onion";
		
		StringTokenizer splitter = new StringTokenizer(thing, ":");
		
		int term=splitter.countTokens();
		for(int i=0; i<term; i++)
		{
			System.out.println(splitter.nextToken());
		}
	}
}
