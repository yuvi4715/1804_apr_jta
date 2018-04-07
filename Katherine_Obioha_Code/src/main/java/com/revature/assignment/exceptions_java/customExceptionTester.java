package exceptions_java;

/**
 * 
 * @author kathe
 *
 *	Testing the custom exception class
 */
public class customExceptionTester {


	
	public static void main(String[]args) throws exception
	{
		duckingexceptions();
		System.out.println(" ");
		testingexception();
		System.out.println(" ");
		systemexitmethod();
	}
		
		private static void systemexitmethod() {
		// TODO Auto-generated method stub
		try
		{	System.out.println("We are about to exit this method");
			System.exit(0);
		}
		finally
		{
			System.out.println("This will not get executed because program exited");
		}
	}
		// duck the exception
		private static void duckingexceptions() throws exception {
		
		try 
		{
			testingexception();
		}
		finally
		{
			System.out.println("We ducked the exception");
		}
	}
		
		//throwing the exception
		public static void testingexception()
	
	{		System.out.println("Starting try block");
				try {
					System.out.println("Throwing my custom exception");
					throw new exception("Custom exception is thrown");
					
				} catch (exception e) {
				// TODO Auto-generated catch block
				System.out.println("Catching my custom exception");
				e.printStackTrace();
			}
			finally
			{
				System.out.println("In the finally block, the end");
			}
		}
	}


