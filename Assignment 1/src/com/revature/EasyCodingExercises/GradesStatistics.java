package com.revature.EasyCodingExercises;

public class GradesStatistics {

	public static void main(String[] args) {
		int[] grades = new int[args.length];
		
		try {
			for(int i = 0; i < args.length; i++) {
				if(Integer.parseInt(args[i]) <= 100 && Integer.parseInt(args[i]) >= 0 ){
					grades[i] = Integer.parseInt(args[i]);
				}
				else {
					throw new notBetween100Exception();
				}
			}
		}
		catch (notBetween100Exception e) {
			System.out.println(e);
		}
		catch(Exception e) {
			System.out.println(e);
		}
		
		double average = GradesStatistics.average(grades);
		System.out.println("average: " + average);
		int minimum = GradesStatistics.minimum(grades);
		System.out.println(minimum);
		int maximum = GradesStatistics.maximum(grades);
		System.out.println(maximum);
		
		
	}      
	
	public static double average(int[] grades) {
		int sum = 0;
		int count = 0;
		int average;
		for(int i = 0; i < grades.length; i++) {
			sum += grades[i];
			count++;
		}
		average = sum/count;
		return average;
	}
	
	public static int minimum(int[] grades) {
		int minimum = grades[0];
		for(int i = 0; i < grades.length; i ++) {
			if(grades[i] < minimum) {
				minimum = grades[i];
			}
		}
		return minimum;
	}
	public static int maximum(int[] grades) {
		int maximum = grades[0];
		for(int i = 0; i < grades.length; i ++) {
			if(grades[i] > maximum) {
				maximum = grades[i];
			}
		}
		return maximum;
	}
	
	public static double standardDeviation(int[] grades) {
		double mean = average(grades);
		double root;
		int count = 0;
		double squaredResult = 0;
		for(int i = 0; i < grades.length; i++) {
			squaredResult += Math.pow(grades[i],2) - mean;
			count++;
		}
		root = Math.pow(squaredResult/count,1/2);
		return root;
	}
	
}
	
	class notBetween100Exception extends Exception {

		/**
		 * 
		 */
		private static final long serialVersionUID = 1993403274868820519L;
		
		public String getMessage() {
			return "Input number is not between 0-100";
		}
	}