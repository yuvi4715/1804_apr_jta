package com.advancedcode.work;

public class FiboCode {

	public static void main(String[] args) {

		int n = 100;
		
		fiboIte(n);
		
		for (int i = 0; i <= n; i++) {
	           System.out.println(fiboRec(i));
	       }
	   }

	   private static void fiboIte(int n) {

		   int a = 0;
           int b = 1;
           for (int i = 1; i < n; i++) {
               int num = a + b;
               System.out.println(num);
               a = b;
               b = num;
           }
		
	}

	public static int fiboRec(int n) {
	       if (n == 0) {
	           return 0;
	       } else if (n == 1) {
	           return 1;
	       } else {
	           return fiboRec(n - 1) + fiboRec(n - 2);
	       }
	   }

	}


