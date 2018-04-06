package com.revature.advancedconcepts;

import java.util.StringTokenizer;

import java.lang.Runtime;

public class StringFun {

	public static void main(String[] args) {
		
		// StringBuilders
		
		StringBuilder theStringBuilder = new StringBuilder("Daredevil is cool.");
		theStringBuilder.append(" Iron Fist is cool too.");
		theStringBuilder.insert(18, " Jessica Jones is super cool.");
		
		int ironFistIndex = theStringBuilder.indexOf("Iron Fist");
		theStringBuilder.replace(ironFistIndex, ironFistIndex + 9, "Luke Cage");
		
		System.out.println(theStringBuilder);
		
		// StringTokenizers
		
		String tags = "pop,rock,punk,top-40,classic-rock";
		StringTokenizer theStringTokenizer = new StringTokenizer(tags, ",");
		while (theStringTokenizer.hasMoreTokens()) {
			System.out.println(theStringTokenizer.nextToken());
		}
		
		// Write a method that adds two strings
		System.out.println(addTwoNumberStrings("10", "5"));
		
		// request Garbage Collection
		System.gc();
		
		// create a Runtime object and note at least three methods
		Runtime rt = Runtime.getRuntime();
		System.out.println("Available Processors: " + rt.availableProcessors());
		System.out.println("Free Memory: " + rt.freeMemory());
		System.out.println("Total Memory: " + rt.totalMemory());
	}
	
	public static int addTwoNumberStrings(String num1, String num2) {
		return Integer.parseInt(num1) + Integer.parseInt(num2);
	}

}
