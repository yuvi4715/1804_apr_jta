package easyCodingExercises;

import java.util.Random;
public class GradeStatistics
{
	public static void main(String[] args) 
	{
		int[] grades = new int[50];
		Random rand = new Random();
		int temp = 0;
		for (int i = 0; i < grades.length; i++)
		{
			temp = rand.nextInt(101);
			grades[i] = temp;
		}
		average(grades,grades.length);
		minimum(grades,grades.length);
		maximum(grades,grades.length);
		standardDeviation(grades,grades.length);
		
	}
	

	public static void average(int[] a, int n)
	{
		double avg;
		avg = avg(a,n);
		System.out.println("The Average is : " + avg);
	}
	
	public static double avg(int[] a, int n)
	{
		double avg = 0;
		for (int i = 0; i < n; i++)
		{
			avg = avg + a[i];
		}
		avg = avg/n;
		return avg;
	}
	
	public static void minimum(int[] a, int n)
	{
		int min = 0;
		for (int i = 0; i < n; i++)
		{
			if (a[i] < min)
			{
				min = a[i];
			}
		}
		System.out.println("The Minimum is : " + min);
	}
	

	public static void maximum(int[] a, int n)
	{
		int max = 0;
		for (int i = 0; i < n; i++)
		{
			if (a[i] > max)
			{
				max = a[i];
			}
		}
		System.out.println("The Maximum is : " + max);
	}
	
	public static void standardDeviation(int[] a, int n)
	{
		double avg = avg(a,n);
		double square = 0;
		double stdDev = 0;
		for (int i = 0; i < n; i++)
		{
			square = square + Math.pow(a[i] - avg,2);
		}
		square = square /(n-1);
		
		stdDev = Math.sqrt(square);

		System.out.println("The Standard Deviation is : " + stdDev);
	}
		
	 
	
}
