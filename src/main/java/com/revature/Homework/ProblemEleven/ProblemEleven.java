package com.revature.Homework.ProblemEleven;


public class ProblemEleven  {
	public static void main(String... strings ) {
		try {
			throw new ProblemElevenException();
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
