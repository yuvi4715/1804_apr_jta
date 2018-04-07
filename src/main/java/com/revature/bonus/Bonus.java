package com.revature.bonus;

import java.util.Arrays;
import java.util.HashMap;

public class Bonus {

	public static void main(String[] args) {
		System.out.println(factorial(5));
		System.out.println(isPalindrome("amanaplanacanalpanama"));
		
		int[] arr = {1, 2, 3, 4, 4, 5};
		System.out.println(findDuplicate(arr));
		
		int[] arrToSort = {33, 54, -333, 200, 4, 90, -2};
		System.out.println("Array to sort: " + Arrays.toString(arrToSort));
		selectionSort(arrToSort);
		System.out.println("Sorted Array: " + Arrays.toString(arrToSort));
	}
	
	// Question 48
	static int factorial(int n) {
		int result = 1;
		while (n >= 1) {
			result *= n;
			
			n -= 1;
		}
		return result;
	}
	
	// Question 53
	static int findDuplicate(int[] arr) {
		HashMap<Integer, Boolean> hm = new HashMap<>(); 
		
		for (int i = 0 ; i < arr.length ; i++) {
			if (hm.get(arr[i]) != null) {
				return arr[i];
			} else {
				hm.put(arr[i], true);
			}
		}
		
		return -1;
	}
	
	// Question 56
	static boolean isPalindrome(String str) {
		StringBuilder reverse = new StringBuilder("");
		for (int i = str.length() - 1 ; i >= 0 ; i--) {
			reverse.append(str.charAt(i));
		}
		return reverse.toString().equals(str);
	}
	
	// Question 57
	static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	
	static void selectionSort(int[] arr) {
		for (int lastUnsortedIndex = arr.length - 1 ; lastUnsortedIndex > 0 ; lastUnsortedIndex--) {
			int largest = 0;
			for (int i = 0 ; i <= lastUnsortedIndex ; i++) {
				if (arr[i] > arr[largest]) {
					largest = i;
				}
			}
			swap(arr, largest, lastUnsortedIndex);
		}
	}

}
