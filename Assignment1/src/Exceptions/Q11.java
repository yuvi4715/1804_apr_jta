//John Eifert
package Exceptions;

//This program answers questions 11-15

public class Q11 
{	
	public static void main(String args[]) throws Q10
	{
		//Throw an exception of type Q10:
		try
		{
			System.out.println("Starting try block");
			throw new Q10();
			//System.out.println("Leaving try block");
		}
		catch(Q10 e)
		{
			System.out.println("Starting catch block");
			e.getMessage();
			System.out.println("Leaving try block");
		}
		
		/*
		 * Throws, ducks, and catches an exception of type Q10, then implements a finally block 
		 * that prints a graceful goodbye message (per question 15, System.exit(0) is now called
		 * in the try block):
		*/
		try
		{
			System.out.println("Starting try block");
			messUp();
			System.exit(0);
			System.out.println("Leaving try block");
			
		}
		catch(Q10 e)
		{
			System.out.println("Starting catch block.");
			e.getMessage();
			System.out.println("Leaving catch block.");
		}
		finally
		{
			System.out.println("\n An error has been encountered... Goodbye.");
		}
	}
	

	//Throws and ducks an exception of type Q10:
	public static void messUp() throws Q10
	{
		throw new Q10();
	}
}
