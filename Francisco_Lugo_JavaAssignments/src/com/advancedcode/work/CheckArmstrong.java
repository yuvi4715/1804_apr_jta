package com.advancedcode.work;

import java.util.Scanner;

public class CheckArmstrong {

	public static void main(String[] args) {

		int str,temp;
		int x=0,y=0,z=0,sum=0,original=0;
		Scanner input = new Scanner(System.in);
		
		try {
			str = input.nextInt();
			System.out.println(str);
			temp = str;
	System.out.println(str/100);
			if((str /100) >0) {
				x = temp/100;
				temp = temp%100;
			
				y = temp/10;
				temp = temp%10;
				
				z = temp;
			}
			else if((str/10) > 0) {
				x = 0;
				y = temp/10;
				temp = temp%10;
				
				z = temp;
			}
			else {
				x=0;
				y=0;
				z=temp;
			}
			
			System.out.println(x + ", " + y + ", " + z);
			sum = (x*x*x) + (y*y*y) + (z*z*z);
			
			if(str == sum) {
				System.out.println("The entered number is an Armstrong Number " + sum);
			}
			else {
				System.out.println("The number " + original + " is not an Armstrong Number " + sum);
				System.out.println(x + ", " + y + ", " + z);
			}
			
			
		}
		catch(NumberFormatException e) {
			System.out.println("Did not enter numbers!");
		}

		input.close();
	}

}
