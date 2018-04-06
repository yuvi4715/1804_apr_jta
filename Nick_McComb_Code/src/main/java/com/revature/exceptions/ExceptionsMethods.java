package com.revature.exceptions;

public class ExceptionsMethods {

	public void olympicShotput() {
		try {
			System.out.println("Starting try block");
			throw new ShotputException();
			//System.out.println("Ending try block");
		} catch (ShotputException e) {
			System.out.println("Starting catch block");
			System.out.println(e.getMessage());
			System.out.println("Ending catch block");
			System.exit(0);
		} finally {
			System.out.println("Starting finally block");
			System.out.println("You have reached the finally block.  Good bye and good night.");
			System.out.println("Ending finally block");
		}
	}
	
	public void amateurShotput() throws ShotputException {
		
	}
}
