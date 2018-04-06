package exceptions;

public class TestCustomException
{
	public static void main(String[] args) 
	{
		try 
		{
			System.out.println("Starting the try block");
			//System.exit(0); If placed here the finally block does not execute
			new TestCustomException().usingArrays();
			
			//System.exit(0); if placed here the finally block does execute
			System.out.println("Ending try block");
		} 
		catch (CustomException e) 
		{
			System.out.println("Starting the catch block");
			System.out.println("Exception was caught!!");
			System.out.println("Ending the catch block");
		}
		finally
		{
			System.out.println("Starting the finally block");
			System.out.println("Remeber Luke....The FORCE will be with you....Always");
			System.out.println("Ending the finally block");
		}
	}
	
	void usingArrays() throws CustomException
	{
		String s2 = null;
		
		if (s2 == null) 
		{
			throw new CustomException();
		}
}
}
