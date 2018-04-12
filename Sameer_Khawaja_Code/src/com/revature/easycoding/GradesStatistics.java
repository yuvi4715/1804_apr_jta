package com.revature.easycoding;

import java.util.InputMismatchException;
import java.util.Scanner;

//problem 37
public class GradesStatistics {

	public static void main(String[] args) {
		// get number from user
		Scanner reader = new Scanner(System.in);
		System.out.print("Enter how many students: ");
		int numberOfStudents;

		while (true) {
			try {
				numberOfStudents = reader.nextInt(); // store grade in array
				break;
			} catch (InputMismatchException e) {
				System.out.println("Invalid entry");
				System.out.print("Enter how many students: ");
				reader.next();
			}

		}

		int[] studentGrades = new int[numberOfStudents]; // array to keep grades

		// get grades
		for (int i = 0; i < numberOfStudents; i++) {
			System.out.print("Enter grade for student " + (i + 1) + ": ");
			while (true) {
				int grade = 0;
				while (true) {
					try {
						grade = reader.nextInt(); // store grade in array
						break;
					} catch (InputMismatchException e) {
						System.out.println("Invalid entry");
						System.out.print("Enter grade for student " + (i + 1) + ": ");
						reader.next();
					}
				}
				if (grade > 0 && grade <= 100) {
					studentGrades[i] = grade;
					break;
				} else {
					System.out.println("Invalid entry");
					System.out.print("Enter grade for student " + (i + 1) + ": ");
				}
			}

		}

		reader.close();

		// calculate average, min, max, stddev

		double average = 0;
		for (int i = 1; i < studentGrades.length; i++) {
			average += studentGrades[i];
		}
		average /= studentGrades.length;

		int maxValue = studentGrades[0];
		for (int i = 1; i < studentGrades.length; i++) {
			if (studentGrades[i] > maxValue) {
				maxValue = studentGrades[i];
			}
		}

		int minValue = studentGrades[0];
		for (int i = 1; i < studentGrades.length; i++) {
			if (studentGrades[i] < minValue) {
				minValue = studentGrades[i];
			}
		}

		double stddev = 0;

		for (int num : studentGrades) {
			stddev += Math.pow(num - average, 2);
		}
		stddev = Math.sqrt(stddev/numberOfStudents);
		
		System.out.println("Average: " + average);
		System.out.println("Min: " + minValue);
		System.out.println("Max: " + maxValue);
		System.out.println("Standard Deviation: " + stddev);

	}

}
