package Problems11To20;

public class Problem14 
{
	public static void main(String[] args) throws MyException
	{
		try 
		{
			System.out.println("Starting try block.");
			System.out.println("Doing something.");
			System.out.println("Ending Try Block.");
		}
		catch(Exception e)
		{
			System.out.println("Starting Catch block. \n Thows Exception.");
		}
		finally
		{
			System.out.println("I bid you goodbye! Have a nice day!");
		}
	}

}
