package com.revature.Homework.ProblemSixty;

public class Main {
	public static void main(String[] args) {
		int[] a = {
			1,2,3,4,5,2,3	
		};
		boolean[] isDistinct = new boolean[a.length];
		for(int i=0;i<isDistinct.length;i++)
			isDistinct[i]=true;
		for(int i=0;i<a.length;i++) {
			for(int j=i;j<a.length;j++) {
				if(i==j)
					continue;
				if(a[i]==a[j]) {
					isDistinct[i]=false;
					isDistinct[j]=false;
				}
			}
		}
		for(int i=0;i<isDistinct.length;i++) {
			if(isDistinct[i])
				System.out.println(a[i]);
		}
	}
}
