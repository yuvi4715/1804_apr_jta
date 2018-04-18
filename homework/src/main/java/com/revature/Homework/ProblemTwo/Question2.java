package com.revature.Homework.ProblemTwo;


public class Question2 {
	public static void main(String[] args) {
		int a=5,b=15,c=20,greatest=a;
		greatest=maximum(a, b, c);
		System.out.println("The greatest number is: "+greatest);
	} 
	public static int maximum(int a,int b, int c) {
		int greatest=a;
		if(a>b&&a>c) {
			greatest=a;
		} else if(b>a&&b>c) {
			greatest=b;
		} else if(c>b&&c>a) {
			greatest=c;
		}
		return greatest;
	}
}
