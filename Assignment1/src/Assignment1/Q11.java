package Assignment1;

public class Q11 
{	
	public static void main(String args[]) throws Q10
	{
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
	

	public static void messUp() throws Q10
	{
		throw new Q10();
	}
	
	public static void doThing() throws Q10
	{
		try
		{
			System.out.println("Starting try block.");
			messUp();
			System.out.println("Ending try block.");
		}
		catch(Q10 q)
		{
			System.out.println("Starting catch block.");
			q.getMessage();
			System.out.println("Leaving catch block.");
		}
		finally
		{
			System.out.println("\n An error has been encountered... Goodbye.");
		}
	}
}
