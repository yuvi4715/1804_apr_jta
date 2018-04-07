package com.revature.easycoding;

import java.util.Scanner;

public class OddEven {

	public static void main(String[] args) {
		OddEven oe = new OddEven();
		oe.OddEven();

	}
	
	public void OddEven() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter a number to Check whether it's ODD or EVEN");
		int a = scan.nextInt();
		if((a%2) == 0) {
			System.out.println(a + " is Even number.");
		}else {
			System.out.println(a + " is Odd number.");
		}
	}

}
