package com.revature.Homework.ProblemThirtySeven;

import java.util.Scanner;

public class Main {
	 public static void main(String[] args) {		
		 Scanner in = new Scanner(System.in);	
		double[] grades = new double[10];
		double Minimum = 0,Maximum = 0;
		int gradeCount=0;
		System.out.println("Enter Number");
		while(in.hasNextDouble()) {
			System.out.println("Enter Number");
			double temp = in.nextDouble();
			if(gradeCount==0) {
				Minimum=temp;
				Maximum=temp;
			}
			if(temp<Minimum)
				Minimum=temp;
			if(temp>Maximum)
				Maximum=temp;
			
			grades[gradeCount]=temp;
			gradeCount++;
			if(gradeCount==grades.length)
				grades=expandArray(grades);
			
		}
		double sum=0,stdDevSum=0;
		for(double f:grades) {
			sum+=f;
		}
		double mean = sum/gradeCount;
		for(double f:grades) {
			stdDevSum+=(f-mean)*(f-mean);
		}
		double stdDevMean = (stdDevSum/gradeCount);
		double stdDev = Math.sqrt(stdDevMean);
		System.out.println("Minimum = "+Minimum+" Maximum = "+Maximum
							+", Mean = "+mean+", Standard Deviation = "+stdDev);
	}
	 
	 public static double[] expandArray(double[] input) {
		 double[] result = new double[input.length*2];
		 for(int i=0;i<input.length;i++) {
			 result[i]=input[i];
		 }
		 return result;
	 }
}
