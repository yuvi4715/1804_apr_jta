package advancedCodingExcercises;

import java.util.Scanner;

// problem 43 - check if an entered integer between 100 and 999 is armstrong or not
public class ArmStrong {
	
	static void input() {
		Scanner k = new Scanner(System.in);
		System.out.println("Enter a number from 100 to 999 that you would like to be checked");
		int n = k.nextInt();
		if (n >999 | n < 100) {
			System.out.println("Sorry, but this program doesnt check support that range, defaulting to 100");
			n = 100;
		}
		k.close();
		checkNumber(n);
	}
		
		
	static void checkNumber(int n) {
		int c = 0;
		int a;
		int temp;
		
		temp = n;
		while(n>0) {
			a = n%10;
			n = n/10;
			c = c+(a*a*a);
		}
		
		if(temp==c) {
			System.out.println("The value entered is Armstrong");
		}
		else {
			System.out.println("The value entered is NOT Armstrong");
		}
	}
	
	public static void main(String[] args) {
		input();
	}
}
