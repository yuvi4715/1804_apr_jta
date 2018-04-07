package AdvancedCodingPrograms;
/**3. Write a Java program to print the first 100 Fibonacci numbers using iteration.
 *  Rewrite using recursion.
 *  Fibonacci numbers are the numbers in the following integer sequence, 
 *  called the Fibonacci sequence, and characterized by the fact that 
 *  every number after the first two is the sum of the two preceding ones:[1][2]
 * @author joeyi
 *
 */
public class Fibonacci {
	public static void main(String[] args) {
		//printFibo();
		printFibo(0,1); //recursive with seed as initial param
	}
	
	
	public static void printFibo() {
		int start=0;
		int seed=1;
		int next=0;
		System.out.println(start);
		System.out.println(seed);
		for(int i=0; i<10;i++)
		{
			next=start+seed; //calc next int
			start=seed; //move index to next int
			seed=next;
			System.out.println(next);
		}
	}
	//recursive
	public static Integer printFibo(int x, int y) {
		
		if(x==0) { //print initial
			System.out.println(x);
			System.out.println(y);
		}
		int next=x+y;
		System.out.println(next);
		if (next<100) return printFibo(y,next);
		return null;
		
	}
}
