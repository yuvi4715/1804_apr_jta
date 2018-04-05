package advanced_concepts;
//Kevin Rivera - Revature
//Assignment Week 1: Advanced Concepts - Problem 17.
//This class contains an example of StrinTokenizer and how to iterate and print its tokens.

import java.util.StringTokenizer;

public class StringTokenizer_Example {
	public static void main(String[] args) {
		//Create StringTokenizer with delimiter ":"
		StringTokenizer st = new StringTokenizer("pickels:mustard:ketchup:fries", ":");
		//Print each token in the StringTokenizer.
		while (st.hasMoreTokens())
			System.out.println("Token: " + st.nextToken());
	}
}
