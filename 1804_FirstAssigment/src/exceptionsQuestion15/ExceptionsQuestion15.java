package exceptionsQuestion15;

import java.io.PrintStream;

//Use the System.exit(0) command in the try block and rerun the application. 
//Note the console output to see if the finally block executes.

public class ExceptionsQuestion15 
{

		public static void main(String[] args) 
		{
			Test1(System.out);
		}
		
		public static void Test1(PrintStream out) 
		{
			 try 
			 {
					out.println("¡Buenos días!");
					System.exit(0);
			 } 
			 
			 catch(Exception e)
			 {
					
			 } 
			 
			 finally
				{
					out.println("¡Hasta luego!");
				}
		}

		
}
