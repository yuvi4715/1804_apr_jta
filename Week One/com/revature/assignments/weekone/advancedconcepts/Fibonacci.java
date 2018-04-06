package com.revature.assignments.weekone.advancedconcepts;
//Q41
public class Fibonacci {

	public Fibonacci() {
		// TODO Auto-generated constructor stub
	}

	static long recursionFibonacci(long n) {
		if (n <= 1)
			return n;
		return recursionFibonacci(n - 1) + recursionFibonacci(n - 2);
	}
	//   Fn = Fn-1 + Fn-2
	static long dynamicFibonacci(long n) {
		 int temp[] = new int[(int) (n+1)]; 
		    int i;
		      		   
		    temp[0] = 0;
		    temp[1] = 1;
		     
		    for (i = 2; i <= n; i++)
		    {
		      temp[i] = temp[i-1] + temp[i-2];
		    }
		      
		    return temp[(int) n];
		
	}	
	// Example Results 0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144...
	
	public static void main(String[] args) {
		long toWhatNumber = 10;
		//100 takes to long to run
		System.out.println(recursionFibonacci(toWhatNumber));
		System.out.println(dynamicFibonacci(toWhatNumber));
	}

}
