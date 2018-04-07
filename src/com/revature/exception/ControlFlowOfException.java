package com.revature.exception;

public class ControlFlowOfException extends Exception{
	

	private static final long serialVersionUID = 1L;
	
	

	public static void main(String[] args) {


		try {
			
			System.out.println("Starting try block");
			int i = 50/0;
			//System.out.println(i);
			//System.out.println("Ending try block");
		}
		catch (ArithmeticException np) {
			System.out.println("try block ended and Starting catch block");
			System.out.println(np.getMessage());
			System.out.println("Ending catch block");
		}
		

	}

}
