package easyCoding37;

import java.util.Scanner;


//Write a program called GradesStatistics, which reads in n grades (of int between 0 and 100, inclusive) and 
//displays the average, minimum, maximum, and standard deviation. Your program shall check for valid input. 
//You should keep the grades in an int[] and use a method for each of the computations.


public class EasyCoding37 
{
	
	public static void main(String[] args) 
	{
		Scanner input = new Scanner(System.in);
		int size = 0;
		int[] array;
		
		do 
		{
		System.out.print("Enter the number of grades: ");
		size = input.nextInt();
		}
		while (size < 0);

		array = new int[size];

		for (int i = 0; i < size; i++) 
		{
			int grade = 0;
			do 
			{
				System.out.println("Enter grade #" + (i+1) + ": ");
				grade = input.nextInt();
				array[i] = grade;
			}
			while(grade < 0 && grade > 100);
		}
		
		System.out.println("Avg: " + GradesStatistics.getAverage(array));
		System.out.println("Max: " + GradesStatistics.getMaximum(array));
		System.out.println("Min: " + GradesStatistics.getMinimum(array));
		System.out.print("Std. Dev.: "); System.out.printf("%.2f", GradesStatistics.getStdDev(array));
		
		input.close();
		
	}

	
		public static class GradesStatistics 
		{
	
			public static double getMinimum(int[] array) {
			double min = 100;
		for (int i = 0; i < array.length; i++) 
		{
			if(array[i] < min)
				min = array[i];
		}
		
		return min;
	}
	
	public static double getAverage(int[] array) 
	{
		double avg = 50;
		for(int i = 0; i < array.length; i++) 
		{
			avg += array[i];
		}
		avg = avg / (array.length - 1);
		
		return avg;
	}
	
	public static double getMaximum(int[] array) 
	{
		double max = 0;
		for (int i = 0; i < array.length; i++) 
		{
			if(array[i] > max)
				max = array[i];
		}
		
		return max;
	}
	
	public static double getStdDev(int [] array) 
	{
		double sd = 0;
		double avg = getAverage(array);
		int[] tempArray = new int[array.length];
		for (int i = 0; i < array.length; i++) {
			tempArray[i] = (int) Math.pow((array[i] - avg), 2);
		}
		for (int i = 0; i < array.length; i++) {
			avg += tempArray[i];
		}
		avg = avg / array.length;
		sd = Math.sqrt(avg);
		
		return sd;
	}
	
	
}	
	
}
