package com.revature.easycodingexercises;

import javax.swing.plaf.synth.SynthSpinnerUI;

public class GradesStatistics {

	public static void main(String[] args) {
		int[] grades = new int[args.length];
		for (int i = 0 ; i < args.length ; i++) {
			try {
				grades[i] = Integer.parseInt(args[i]);
			} catch (Exception e) {
				System.out.println("Not a valid input");
				e.getMessage();
			}
		}
		
		average(grades);
		minimum(grades);
		maximum(grades);
		standardDeviation(grades);
	}
	
	static void average(int[] grades) {
		float total = 0;
		for (int grade : grades) {
			total += grade;
		}
		System.out.println("Average: " + total / grades.length);
	}
	
	static void minimum(int[] grades) {
		int min = grades[0];
		for (int grade : grades) {
			if (grade < min) {
				min = grade;
			}
		}
		System.out.println("Min: " + min);
	}
	
	static void maximum(int[] grades) {
		int max = grades[0];
		for (int grade : grades) {
			if (grade > max) {
				max = grade;
			}
		}
		System.out.println("Max: " + max);
	}
	
	static void standardDeviation(int[] grades) {
		float total = 0;
		for (int grade : grades) {
			total += grade;
		}
		float average = total / grades.length;
		
		float result = 0;
		for (int grade : grades) {
			float gradeMinusAverage = (float) grade - average;
			float squareOfGradeMinusAverage = (float) Math.pow(gradeMinusAverage, 2);
			result += squareOfGradeMinusAverage;
		}
		System.out.println("Standard Deviation: " + Math.sqrt(result));
	}
	
}
