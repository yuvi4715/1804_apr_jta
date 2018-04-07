package com.revature.easycoding;

import java.util.Scanner;

public class CheckPassFail {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter your Mark to check pass or fail: ");
		int mark = scan.nextInt();
		
		if(mark >= 50) {
			System.out.println("Congurats you have Passed");
		}else {
			System.out.println("Sorry!! you have Failed");
		}

	}

}
