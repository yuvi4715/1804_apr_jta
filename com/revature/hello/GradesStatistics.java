package com.revature.hello;

import java.util.Scanner;

public class GradesStatistics {
	// Write a program called GradesStatistics, which reads in n grades (of int
	// between 0 and 100, inclusive) and displays the average, minimum, maximum, and
	// standard deviation. Your program shall check for valid input. You should keep
	// the grades in an int[] and use a method for each of the computations.

	static int[] grades;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.println("Enter the total number of grades to be entered: ");
		int n = sc.nextInt();
		grades = new int[n];
		System.out.println("Enter grades: ");
		for (int i = 0; i < n; ++i) {
			int grade = sc.nextInt();
			if (grade > 100 || grade < 0) {
				System.out.println("Invalid grade: " + grade);
				return;
			}
			grades[i] = grade;
		}
		
		System.out.println("Echoing grades: ");
		for (int g : grades)
			System.out.println(g);

		System.out.println("mean of " + grades.length + " grades = " + mean());
		System.out.println("max = " + max());
		System.out.println("min = " + min());
		System.out.println("standard deviation = " + stdDev());
	}

	public static float mean() {
		float sum = 0;

		for (int i = 0; i < grades.length; ++i) {
			sum += grades[i];
		}
		return sum / grades.length;
	}

	public static float min() {
		int min = 100;

		for (int i = 0; i < grades.length; ++i) {
			if (grades[i] < min)
				min = grades[i];

		}
		return min;
	}

	public static float max() {
		int max = 0;

		for (int i = 0; i < grades.length; ++i) {
			if (grades[i] > max)
				max = grades[i];

		}
		return max;
	}

	public static float stdDev() {
		float sum = 0;
		float mean = mean();

		for (int i = 0; i < grades.length; ++i) {
			sum += Math.pow((grades[i] - mean), 2);
		}
		return (float) Math.sqrt(sum / grades.length);
	}
}
