package exceptionsQuestion14;

import java.io.PrintStream;

//Implement a finally block that prints a graceful goodbye message

public class ImplementFinallyBlock 
{


		public static void main(String[] args) 
		{
			Test1(System.out);
		}
		
		public static void Test1(PrintStream out) 
		{
			try 
			{
				out.println("¡Buenos días¡");
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
	