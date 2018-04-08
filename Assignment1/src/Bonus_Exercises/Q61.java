//John Eifert
package Bonus_Exercises;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Q61
{
	public static void main(String args[])
	{
		BufferedReader istream = null;
		ArrayList<String> list = new ArrayList<String>();
		String thisStr;
		
		try
		{
			istream = new BufferedReader(new FileReader("C:\\Git_Repos\\1804_apr_jta\\Assignment1\\src\\Bonus_Exercises\\LoremIpsum.txt"));
			
			String line;
			while((line=istream.readLine()) != null)
			{
				StringTokenizer splitter = new StringTokenizer(line, " ");
				while(splitter.hasMoreTokens())
				{
					thisStr=splitter.nextToken().toLowerCase();
					
					if(!list.contains(thisStr))
					{
						list.add(thisStr);
					}
				}
			}
			
			System.out.print("The distinct words from the provided file are: ");
			for(int i=0; i<list.size(); i++)
			{
				System.out.print(list.get(i) + " ");
			}
			
		}
		catch(Exception e)
		{
			System.out.println("Something went wrong...");
			e.printStackTrace(System.out);
		}
	}
}
