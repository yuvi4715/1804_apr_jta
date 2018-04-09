//Use the System.exit(0) command in the try block and rerun the application. Note the console output to see if the finally block executes.

package Exceptions;

public class question15 {

	public static void main(String[] args) {
		try {
		    System.out.println("try block");
		    System.exit(0);
		    System.out.println("post try block");

		}
		catch (Exception ex) {
			System.out.println("catch block");
		}
		finally {
			System.out.println("finally block");
		    System.exit(1);
			System.out.println("post finally block");

		}
	}

}
