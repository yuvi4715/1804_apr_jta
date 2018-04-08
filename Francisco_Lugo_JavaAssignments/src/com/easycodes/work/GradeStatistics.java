package com.easycodes.work;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class GradeStatistics {
	public static void main(String[] args) {
		
		int count,temp, min, max, co = 1;
		double avr =0;
		boolean flag = true;
		Scanner input = new Scanner(System.in);
		ArrayList<Integer> al = new ArrayList<Integer>();
		
		System.out.print("How many grades will be introduced? ");
		System.out.println();
		
		try {
			count = input.nextInt();
			
			if(count != 0) {
			
				System.out.println("REMINDER: The grades should be from 0 to 100.");
				
				while(count != 0){
					
					System.out.println("Please input grade #" + co++);
					do {
						temp = input.nextInt();
						
						if((temp>=0) && (temp <=100)) {
							al.add(temp);
							flag = false;
						}
						else
							System.out.println("The number "+ temp + " is not within range, input another.");
						
					}while(flag);
						
					count--;
					}
			}
		}
		catch(NumberFormatException e) {
			System.out.println("The input was not a number, exiting...");
			System.exit(0);
		}
		
		for(int e: al) {
			avr += e;
		}
		
		avr = avr/al.size();
		System.out.println("The average score was: " + avr);
		
		min = Collections.min(al);
		max = Collections.max(al);
		
		System.out.println("The minimum grade was: " + min);
		System.out.println("The maximum grade was: " + max);
		System.out.println("Ending program, goodbye.");
		input.close();
		
	}

}
