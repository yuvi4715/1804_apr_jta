package com.revature.Homework.ProblemTen;


public class ProblemTen  {
	public static void main(String... strings ) {
		try {
			throw new ProblemTenException();
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
