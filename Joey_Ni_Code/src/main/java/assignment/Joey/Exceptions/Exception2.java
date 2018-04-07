package assignment.Joey.Exceptions;
import assignment.Joey.Customer.*;
/**a class that manually throws an exception of your custom type
 * Use System.out.println( ) to note where you are in the control flow.
 * Duck the exception at least once
 * Implement a finally block that prints a graceful goodbye message
 *  Example: “Starting try block”
 *  Use the System.exit(0) command in the try block and rerun the application. 
 *  Note the console woutput to see if the finally block executes.
 * @author joeyi
 *
 */
public class Exception2{
	public static void main(String[] args) throws Exception1 {
		
		new Customer("hello");
		new Customer("world");
		for(int i=0; i<10; i++) {
			new Customer(); //create 10 random customers
		}
		
		Customer.printCustomerList();
		//Customer.getCustomerInfo("should not find this");
		//Customer.getCustomerInfo(123);
		
		try {
			System.out.println("testing in the try block before systesm.exit(0)");
		//	System.exit(0);
		//	System.out.println("this will also not print and system.exit abruptly creates no error");
		}finally 
		{   System.out.println("test finally");
	    }
     }
}
