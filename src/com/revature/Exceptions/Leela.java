package com.revature.Exceptions;

public class Leela {
//problem 11, 12, 13, 14, 15
	public static void main(String[] args) {
		
		try {
			System.out.println("First try block");
			Leela l = new Leela();
			System.exit(0);
			l.hasPopler();
		}
		catch(ProblemWithPoplersException e) {
			System.out.println("First catch block");
			System.out.println(e);
		}
		finally {
			System.out.println("Finally block");
			System.out.println("Come to fishy Joe's anyway!");
		}
	}
	
	public void hadPopler() throws ProblemWithPoplersException {
		throw new ProblemWithPoplersException();
	}

	public void hasPopler() throws ProblemWithPoplersException {
		hadPopler();
	}
}
