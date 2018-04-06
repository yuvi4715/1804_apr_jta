package AdvancedCodingExercises;

public class Problem38 
{
	public static void main(String[] args) 
	{		
		String test = "Glarble";
		System.out.println(ReplaceChar(test, 'X', 4));
	}
	
	public static String ReplaceChar(String s, char c, int loc) 
	{
		 if( loc > (s.length()-1))
			 return null;
		 
		 String Replaced = s.substring(0, loc);
		 Replaced+=c;
		 Replaced+=s.substring(loc+1);
		 return Replaced;
	}
}
