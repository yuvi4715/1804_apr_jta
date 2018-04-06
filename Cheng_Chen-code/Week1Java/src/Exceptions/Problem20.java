package Exceptions;

public class Problem20 {

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		Runtime r = Runtime.getRuntime();
		System.out.println("Testing available processors " + r.availableProcessors());

		System.out.println("Testing free memory " + r.freeMemory());

		System.out.println("Testing max memory " + r.maxMemory());
	}

}
