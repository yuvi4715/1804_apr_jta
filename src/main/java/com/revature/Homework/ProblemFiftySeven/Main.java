package com.revature.Homework.ProblemFiftySeven;

public class Main {
	public static void main(String[] args) {
		int[] integers = {
			2,
			1,
			3,
			5,
			4,
			6
		};
		quickSort(integers, 0, integers.length-1);
		for(Integer i:integers)
			System.out.println(i);
	}
	public static void quickSort(int[] a,int low,int high) {
		int i = low;
        int j = high;
		int pivot = a[low + (high-low)/2];
		while (i <= j) {
           while (a[i] < pivot) {
                i++;
            }
            while (a[j] > pivot) {
                j--;
            }
            if (i <= j) {
                exchangeNumbers(a,i, j);
                i++;
                j--;
            }
        }
        if (low < j)
            quickSort(a,low, j);
        if (i < high)
            quickSort(a,i, high);
	}
	 public static void exchangeNumbers(int[] a,int i, int j) {
	        int temp = a[i];
	        a[i] = a[j];
	        a[j] = temp;
	    }
}
