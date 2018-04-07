package com.revature.questions38_45;


public class Fibo{
	
	public static void main(String[] args) {
		System.out.print("Fibonacci series(R): ");
		for(int i=0;i<=100;i++){
			System.out.print(fibonacciRecursive(i)+" ");
		}
		System.out.println();
		
		System.out.print("Fibonacci series(I): ");
		for(int i=0;i<=100;i++){
			System.out.print(fibonacciIterative(i)+" ");
		}
		System.out.println();
	}
	
	public static int fibonacciRecursive(int n){
		if(n<=1){
			return 1;
		}
		else{
			return fibonacciRecursive(n-1)+fibonacciRecursive(n-2);
		}
	}
	
	public static int fibonacciIterative(int n){
		int i=0,result=1,prevresult=1;
		while(i<n-1){
			int temp=result;
			result=result+prevresult;
			prevresult=temp;
			i++;
		}
		
		return result;
	}
}
