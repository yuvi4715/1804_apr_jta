package com.revature.Homework.ProblemTwo;


public class Question2 {
	public static void main() {
		int a=5,b=15,c=20,greatest=a;
		if(a>b&&a>c) {
			greatest=a;
		} else if(b>a&&b>c) {
			greatest=b;
		} else if(c>b&&c>a) {
			greatest=c;
		}
		System.out.println("The greatest number is: "+greatest);
	} 
}
