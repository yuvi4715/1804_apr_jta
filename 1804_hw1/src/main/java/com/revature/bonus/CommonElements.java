package com.revature.bonus;

import java.util.Iterator;
import java.util.TreeSet;

// Solution to hw1 bonus problem #58

public class CommonElements {

	public static int[] commonElements(int[] a1, int[] a2) {
		
		TreeSet<Integer> commonElements = new TreeSet<>();
		
		for (int i = 0; i < a1.length; i++) {
		
			for (int j = 0; j < a2.length; j++) {
				
				if (a1[i] == a2[j]) {
					
					commonElements.add(a1[i]);
				}
			}
		}
		
		Iterator<Integer> iter = commonElements.iterator();
		int[] cElm = new int[commonElements.size()];
		
		for (int i = 0; i < commonElements.size(); i++) {
			
			cElm[i] = iter.next();
		}
		
		return cElm;
	}
	
	public static void main(String[] args) {
		
		// Test commonElements function
		int[] a1 = {1,2,3,4,5,6,7,8,9};
		int[] a2 = {4,7,8,1,9,9,12};
		
		int[] common = commonElements(a1, a2);
		
		System.out.println("Common Elements:");
		for (int i = 0; i < common.length; i++) {
			
			System.out.println(common[i]);
		}
	}
}
