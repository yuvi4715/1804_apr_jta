package com.revature.easycodingexercises;

import java.util.Scanner;
import java.util.StringTokenizer;

public class GradeStatistics {
	
	/**
	 * 
	 * @param grades
	 * @return This method will return the average of all the grades fed into it
	 */
	public static double calculateAvg(int[] grades) {
		
		double total = 0;
		
		for (int i = 0; i < grades.length; i++) {
			total += grades[i];
		}
		
		return total/grades.length;
	}
	
	/**
	 * 
	 * @param grades
	 * @return This method will return the standard deviation of all the grades fed into it
	 */
	public static double calculateStd(int[] grades) {
		
		double avg = calculateAvg(grades);
		double diffMean, total = 0;
		
		for (int i = 0; i < grades.length; i++) {
			
			diffMean = grades[i] - avg;
			
			total += diffMean * diffMean;
		}
		
		return Math.sqrt(total / grades.length);
	}
	
	/**
	 * 
	 * @param grades
	 * @return This method will return the minimum value of grades
 	 */
	public static int findMin(int[] grades) {
		int min = 101;
		
		for (int i = 0; i < grades.length; i++) {
			if (grades[i] < min) {
				min = grades[i];
			}
		}
		
		return min;
	}
	
	/**
	 * 
	 * @param grades
	 * @return This method will return the maximum value of grades
 	 */
	public static int findMax(int[] grades) {
		int max = -1;
		
		for (int i = 0; i < grades.length; i++) {
			if (grades[i] > max) {
				max = grades[i];
			}
		}
		
		return max;
	}
	
	public static void main(String[] args) {
		
		Scanner reader = new Scanner(System.in);
		String input, acc = "";
		int currInt = 0, counter = 0;
		
		
		System.out.println("Enter an integer  between 0 - 100 or a 'f' to finish.");
		input = reader.next();

		// Gets arbitrary amount of integers from user until the 'd' character is read
		while (!input.equals("f")) {
						
			try {
				currInt = Integer.parseInt(input);
			} catch (NumberFormatException e) {
				System.out.println("Please make sure to input is a valid integer or 'f'");
				currInt = -1;
			}
			
			if (currInt > -1 && currInt < 101) {
				acc += input + ":";
				counter++;
			} else {
				System.out.println("Make sure that integer input is between 0 - 100");
			}
			
			System.out.println("Enter an integer  between 0 - 100 or a 'f' to finish.");
			input = reader.next();
		}
		
		reader.close();
		
		// Put user input into array
		StringTokenizer tokenizer = new StringTokenizer(acc, ":");
		int grades[] = new int[counter];
		
		for (int i = 0; i < counter; i++) {
			grades[i] = Integer.parseInt(tokenizer.nextToken());
		}
		
		System.out.println("\nSTATISTICS");
		System.out.println("Average: " + calculateAvg(grades));
		System.out.println("Standard Deviation: " + calculateStd(grades));
		System.out.println("Minimum: " + findMin(grades));
		System.out.println("Maximum: " + findMax(grades));
	}
}
