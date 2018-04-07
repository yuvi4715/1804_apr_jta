package coreJava;
/**
 * Dominick Sermeno
 * Batch 1804
 * Q's: 1 and 5
 * 
 */

public class SimpleCalculator 
{

	
	public void add(int first,int second)
	{
		int answer = -1;
		answer = first + second;
		System.out.println("Add: " + first + " + " +second +" = " + answer);
	}

	public void subtract(int first,int second)
	{
		int answer = -1;
		answer = first - second;
		System.out.println("Subtract: " + first + " - " +second +" = " + answer);
	}
	
	public void multiply(int first,int second)
	{
		int answer = -1;
		answer = first * second;
		System.out.println("Multiply: " + first + " * " +second +" = " + answer);
	}
	
	public void divide(int first,int second)
	{
		double answer = -1;
		answer = first / second;
		System.out.println("Divide: " + first + " / " +second +" = " + answer);
	}
	
}
