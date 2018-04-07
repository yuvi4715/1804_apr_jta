package com.revature.Homework.ProblemSixtyTwo;

public class ComputePI  {
	public static void main(String[] args) {
		double PI=0d;
		for(int i=0;i<100000;i++) {
			PI+= Math.pow(-1, i)/(2*i+1);
		}
		PI*=4;
		System.out.println("Calculated PI (Gregory-Leibniz) "+PI);
		System.out.println("It around to " +((PI/Math.PI)*100)+"% close");
	}
}
