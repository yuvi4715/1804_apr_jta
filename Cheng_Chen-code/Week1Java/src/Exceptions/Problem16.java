package Exceptions;

public class Problem16 
{
	public static void main(String[] args) 
	{
		StringBuilder s = new StringBuilder("Test");
		System.out.println(s);
		
		s.append("Hello!");
		System.out.println(s);
		
		s.insert(2, "Greetings!");
		System.out.println(s);
		
		s.reverse();
		System.out.println(s);
	}
}
