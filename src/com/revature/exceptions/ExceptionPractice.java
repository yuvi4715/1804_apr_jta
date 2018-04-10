package com.revature.exceptions;

//problems 10-15
public class ExceptionPractice {

	public static void main(String[] args) {
		new ExceptionPractice().attempt();

	}

	public void attempt() {

		try {
			System.out.println("entered try block");
			failattempt();
			//System.exit(0);  //this command kills the program
			System.out.println("leaving try block"); //statement is never printed since thread goes to catch block
		} catch (CustomException e) {
			System.out.println("entered catch block");
			System.out.println(e.getMessage());
			System.out.println("leaving catch block");
		}finally {
			System.out.println("Exiting program");
		}
		

	}

	public void failattempt() throws CustomException {
		System.out.println("entered fail attempt method");
		throw new CustomException();
	}

}
