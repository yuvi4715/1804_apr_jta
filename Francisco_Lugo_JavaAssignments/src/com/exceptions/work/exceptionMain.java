package com.exceptions.work;

public class exceptionMain {

	public static void main(String[] args) throws exceptionClass {
		int x;
		String str = "123";
		
		System.out.println("Working code begins.");
		System.out.println("Starting try block");
		
		try {
			System.out.println("Entered try block");
			x = Integer.parseInt(str);
			System.out.println(x);
			System.out.println("Leaving try block");
		}
		catch(NumberFormatException e){
			System.out.println("Entered catch block");
			throw new exceptionClass("This is an error, something went wrong!");
		}
		finally {
			System.out.println("Entered finally block");
		System.out.println("A graceful goodbye message~");
		
		}
		System.out.println("Working code ends");
/*		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~");
		System.out.println("Code with error begins");
		
		str = "hello";
		System.out.println("Starting try block");
		try {

			System.out.println("Entered try block");
			x = Integer.parseInt(str);
			System.out.println(x);
			System.out.println("Leaving try block");
		}
		catch(NumberFormatException e){
			System.out.println("Entered catch block");
			throw new exceptionClass("This is an error, something went wrong!");
		}
		finally {
			System.out.println("Entered finally block");
		System.out.println("A graceful goodbye message~");
		
		}
		System.out.println("Code with error ends");*/
		System.out.println("~~~~~~~~~~~~~~~~~");
		
		try {
			System.out.println("Goodbye, forcing shutdown!");
			System.exit(0);
			new exceptionMain().divideZero();
		}
		catch(exceptionClass e)
		{
			System.out.println("A thing is here.");
		}
		finally {
			System.out.println("Final code has been run");
		}
	}
	
	void divideZero() throws exceptionClass {
		int x,a=10,b=0;
		
		if(b==0) {
			throw new exceptionClass("Tried dividing by zero");
		}
		else {
			x = a/b;
			System.out.println(x + " is the result of " + a + " / " + b);
		}
	}
}
