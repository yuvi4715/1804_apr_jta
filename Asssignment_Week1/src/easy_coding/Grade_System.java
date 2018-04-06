package easy_coding;

import java.util.Scanner;

//Kevin Rivera - Revature
//Assignment Week 1: Easy Coding Exercises - Problem 37.
//This program takes an n amount of grades, stores them in an array
//and calculates some statistics of these grades.

public class Grade_System {
	
	public static double getMinimum(int[] array) {
		double min = 100;
		for (int i = 0; i < array.length; i++) {
			if(array[i] < min)
				min = array[i];
		}
		
		return min;
	}
	
	public static double getAverage(int[] array) {
		double avg = 50;
		for(int i = 0; i < array.length; i++) {
			avg += array[i];
		}
		avg = avg / (array.length - 1);
		
		return avg;
	}
	
	public static double getMaximum(int[] array) {
		double max = 0;
		for (int i = 0; i < array.length; i++) {
			if(array[i] > max)
				max = array[i];
		}
		
		return max;
	}
	
	public static double getStdDev(int [] array) {
		double sd = 0;
		double avg = getAverage(array);
		int[] tempArray = new int[array.length];
		//For each number, subtract the mean and square the result
		for (int i = 0; i < array.length; i++) {
			tempArray[i] = (int) Math.pow((array[i] - avg), 2);
		}
		//Get the mean of THOSE squared results, use previous avg variable
		for (int i = 0; i < array.length; i++) {
			avg += tempArray[i];
		}
		avg = avg / array.length;
		//THEN the square root of that and we're done
		sd = Math.sqrt(avg);
		
		return sd;
	}
	
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int size = 0;
		int[] array;
		
		//Get size of array, number of grades
		do {
		System.out.print("Enter the number of grades: ");
		size = input.nextInt();
		}while (size < 0);
		//Initialize array
		array = new int[size];
		//Enter each grade into the array
		for (int i = 0; i < size; i++) {
			int grade = 0;
			do {
				System.out.println("Enter grade #" + (i+1) + ": ");
				grade = input.nextInt();
				array[i] = grade;
			}while(grade < 0 && grade > 100);
		}
		
		//Get computations
		System.out.println("Avg: " + Grade_System.getAverage(array));
		System.out.println("Max: " + Grade_System.getMaximum(array));
		System.out.println("Min: " + Grade_System.getMinimum(array));
		System.out.print("Std. Dev.: "); System.out.printf("%.2f", Grade_System.getStdDev(array));
		
	}
	
}