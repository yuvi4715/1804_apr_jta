package exceptionsQuestion12;

import java.io.PrintStream;


public class ExceptionQuestion12b {
	
//	Use System.out.println( ) to note where you are in the control flow. 
//	Example: “Starting try block”, “Ending try block”, “Starting catch block”, etc.
	
	
		public static void main(String... strings ) {
			test01(System.out);
		}
		
		public static void test01(PrintStream out) {
			try {
				out.println("Starting try block");
				throw new ExceptionQuestion12();
			}catch(Exception e) {
				out.println("Starting catch block");
			} finally {
				out.println("Starting finally block");
			}
	}
}

