package com.revature.Homework.ProblemFiftyThree;

import java.io.PrintStream;

public class Main {

	public static void main(String[] args) {
		int[] a = {
			1,
			2,
			3,
			3
		};
		test01(System.out,a);
	}
	public static void test01(PrintStream out,int[] a) {
		boolean hasDuplicate = false;
		outsideLoop:{
			for(int i=0;i<a.length;i++) {
				for(int j=i;j<a.length;j++) {
					if(a[i]==a[j])
						hasDuplicate=true;
					break outsideLoop;
				}
			}
		}
		if(hasDuplicate)
			out.println("Has Duplicate");
		else 
			out.print("Does not have duplicates");
	}

}
