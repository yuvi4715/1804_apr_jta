package assignment.Joey.AdvancedCodingPrograms;
/**7. Write a method to reverse a String without using API functions.
*/
public class StringReversal {
	public static void main(String[] args) 
	{
		System.out.println(reverseString("hello"));
		System.out.println(reverseString("world"));
		System.out.println(reverseString("joey"));
	}
	
	
	public static String reverseString(String s)
	{	
		char [] c= new char [s.length()]; //3
		int count=c.length-1;  //0,1,2
		for(int i =0; i<=count; i++)
		{
			c[i]=s.charAt(count-i);			
		}
		
		return String.copyValueOf(c);
	}
}
