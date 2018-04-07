package com.revature.Homework.ProbleFiftyEight;

import java.util.LinkedList;
import java.util.List;

public class Main {
	public static void main(String[] args) {
		int[] a = {
			1,2,4
		};
		int[] b = {
			1,2,3	
		};
		List<Integer> sharedElements = new LinkedList<>();
		boolean sharesElements = false;
		for(int i=0;i<a.length;i++) {
			for(int j=0;j<b.length;j++) {
				if(a[i]==b[j])
				{
					sharesElements=true;
					sharedElements.add(a[i]);
				}
			}
		}
	
		if(sharesElements) {
			System.out.println("Share elements");
			for(Integer i:sharedElements)
				System.out.print(i+" ");
		} else {
			System.out.println("Do not share elements");
		}
	}
}
