package com.revature.assignments.weekone.exceptions;

public class TryAndCatch {

	public TryAndCatch() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) throws CustomException {
		// CustomException ce = new CustomException();

		try {
			System.out.println("Start Try Block");
			throw new CustomException();

		} catch (CustomException ce) {
			System.out.println("End Try Block");
			System.out.println("Start Catch Block");
			System.out.println(ce.getMessage());
			System.out.println("End Catch Block");
		}

	}

}
