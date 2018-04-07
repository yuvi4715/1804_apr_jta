package com.revature.questions32_37;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//I apologize in advance for the very inefficient avg, min, max and stdev.

public class Question37_GradeStatistics {

	public static List<Integer> grades = new ArrayList<>();
	
	
	public static void main(String[] args) {
		
		gradesStatistics();
	}
	
	
	static void gradesStatistics() {
		
		Scanner askUser = new Scanner(System.in);
		boolean enterGrades = true;
		
		while(enterGrades == true) {
		
			System.out.println("Please enter an integer grade between 0 and 100: \nSubmit any key to exit.");
			
			//This try/catch is probably inefficient and messy but I wanted to try using one. 
			try {
				int temp = Integer.parseInt(askUser.nextLine());
				if(temp < 0 || temp > 100) {
					System.out.println("Invalid grade, exiting. Previous grades recorded.");
					break;
				}
				grades.add(temp);
				
			} catch(NumberFormatException e){
				System.out.println("Logs completed5");
				enterGrades = false;
			} 
	
		}
		askUser.close();	
		
		System.out.println("Average:            " + gradeAvg(grades));
		System.out.println("Min:                " + gradeMin(grades));
		System.out.println("Max:                " + gradeMax(grades));
		System.out.println("Standard Deviation: " + gradeStDev(grades));
	}
	
	
	public static double gradeAvg(List<Integer> grades) {
		
		double gradeSum = 0;
	    for(int i = 0; i < grades.size(); i++){
	        gradeSum += (double) grades.get(i);
	    }
		return gradeSum/grades.size();
		
	}
	
	public static int gradeMin(List<Integer> grades) {
		
		int gradeMin = 100;

	    for(int i = 0; i < grades.size(); i++){
	    	
	    	if((int)grades.get(i) < gradeMin) {
	    		gradeMin = (int)grades.get(i);
	    	}
	    }
		return gradeMin;

	}
	
	
	public static int gradeMax(List<Integer> grades) {
		int gradeMax = 0;

	    for(int i = 0; i < grades.size(); i++){
	    	
	    	if((int)grades.get(i) > gradeMax) {
	    		gradeMax = (int)grades.get(i);
	    	}
	    }
		return gradeMax;
	}
	
	
	public static double gradeStDev(List<Integer> grades) {
		
		double mean = gradeAvg(grades);
		double temp = 0;
		for(double i :grades) {
			temp += (i-mean)*(i-mean);
		}   
		
	    double stDev = Math.sqrt(temp/(grades.size()-1));
		
		return stDev;
	}
	
	
}
