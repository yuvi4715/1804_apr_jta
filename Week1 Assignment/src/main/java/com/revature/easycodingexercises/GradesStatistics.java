package com.revature.easycodingexercises;

import java.util.Scanner;

public class GradesStatistics {
	public static void main(String[] args) {
		/*
		 * 37. Write a program called GradesStatistics, which reads in n grades (of int
		 * between 0 and 100, inclusive) and displays the average, minimum, maximum, and
		 * standard deviation. Your program shall check for valid input. You should keep
		 * the grades in an int[] and use a method for each of the computations.
		 */
		Scanner user = new Scanner(System.in);
		GradesStatistics computations = new GradesStatistics();
		System.out.println("How much grades are you entering in? ");
		int numberOfGrades = user.nextInt();
		int[] grades = new int[numberOfGrades];
		int scores;
		int limit = 0, x = 0;
		while (limit != numberOfGrades) {
			System.out.println("Please enter your grades: ");
			scores = user.nextInt();
			if (scores <= 100 & scores >= 0) {
				grades[x] = scores;
				x++;
				limit++;
			}
			if (scores > 100 || scores < 0) {
				System.out.println("Error: The grade entered has to be a value in between 0 to 100!");
				System.out.println("Please try again.");
			}
		}

		computations.average(grades, numberOfGrades);
		computations.minimum(grades);
		computations.maximum(grades);
		computations.standardDeviation(grades, numberOfGrades);
		user.close();
	}

	void average(int[] grades, int numberOfGrades) {
		int sumGrades = 0;
		for (int i = 0; i < grades.length; i++) {
			sumGrades += grades[i];
		}
		System.out.println("Sum: " + sumGrades);
		int avg = sumGrades / numberOfGrades;

		System.out.println("The average grade is: " + avg);
	}

	void minimum(int[] grades) {
		int min = 100;
		for (int i = 0; i < grades.length; i++) {
			if (grades[i] < min) {
				min = grades[i];
			}
		}
		System.out.println("The lowest grade is: " + min);
	}

	void maximum(int[] grades) {
		int max = 0;
		for (int i = 0; i < grades.length; i++) {
			if (grades[i] > max) {
				max = grades[i];
			}
		}
		System.out.println("The highest grade is: " + max);
	}

	void standardDeviation(int grades[], int numberOfGrades) {
		double powerSum1 = 0;
		double powerSum2 = 0;
		double standardDev = 0;

		for (int i = 0; i < grades.length; i++) {
			powerSum1 += grades[i];
			powerSum2 += Math.pow(grades[i], 2);
			standardDev = Math.sqrt(numberOfGrades * powerSum2 - Math.pow(powerSum1, 2)) / numberOfGrades;

		}
		System.out.println("The standard deviation is: " + standardDev);
	}
}
