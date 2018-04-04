package com.revature.Homework.ProblemSeventeen;


import java.util.StringTokenizer;

public class ProblemSeventeenMain {

	public static void main(String[] args) {
		String s = "pickles:ketchup:mustard:onion" ;
		StringTokenizer tokenizer = new StringTokenizer(s, ":");
		while(tokenizer.hasMoreTokens())
			System.out.println(tokenizer.nextToken());
	}

}
