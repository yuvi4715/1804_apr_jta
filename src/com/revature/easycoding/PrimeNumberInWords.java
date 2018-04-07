package com.revature.easycoding;

import java.util.Scanner;

public class PrimeNumberInWords {

	public static void main(String[] args) {
		PrimeNumberInWords prime = new PrimeNumberInWords();
		prime.PrimeNumberInWords();
		
	}
	
	public void PrimeNumberInWords() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter the value");
		int a = scan.nextInt();
		
		switch(a) {
		case 1 :
			System.out.println("ONE");
			break;
		case 2 :
			System.out.println("TWO");
			break;
		case 9 :
			System.out.println("NINE");
		default :
			System.out.println("Others");
			break;
		}
		
		if(a == 1 ) {
			System.out.println("ONE");
		}else if(a == 2){
			System.out.println("TWO");
		}else if(a == 9){
			System.out.println("NINE");
		}else {
			System.out.println("OTHERS");
		}
		
		
		
	}

}
