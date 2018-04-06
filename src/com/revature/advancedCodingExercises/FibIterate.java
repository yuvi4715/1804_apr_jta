package com.revature.advancedCodingExercises;

public class FibIterate {
//problem 40
	public static void main(String[] args) {
		fibIterator(100);
		for (int i = 0; i<100; i++) {
			System.out.println(fibRecursion(i));
		}
	}
	
	static int fibIterator(int n) {
        int x = 0, y = 1, z = 1;
        for (int i = 0; i < n; i++) {
            x = y;
            y = z;
            z = x + y;
            System.out.println(y);
            System.out.println(z);
        }
        return x;
    }

	static int fibRecursion(int  n) {
        if (n == 0 || n ==1) {
        	return n;
        }
        return fibRecursion(n-1) + fibRecursion(n-2);
    }
}
