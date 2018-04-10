package com.revatureadvancedcoding;

//problem 43
public class Armstrong {

	public static void main(String[] args) {
		int c, a, temp;
		c = a = temp = 0;
		int armstrong = 371;// It is the number to check armstrong
		temp = armstrong;

		while (temp > 0) {
			a = temp % 10; // gives us ones, tens, then hundreds place values
			temp = temp / 10;
			c = c + (a * a * a);// store sum of (one's place^3), then (ten's place^3+ one's place^3), etc
		}
		if (armstrong == c)
			System.out.println(armstrong + " is a armstrong number");
		else
			System.out.println(armstrong + " is not armstrong number");
	}

}
