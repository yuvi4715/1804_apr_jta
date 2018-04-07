package com.revature.easycoding;

import java.util.Scanner;

public class Grades {
	static int count = 10;
	static int [] grades = new int[count];
	static int i = 0;

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Enter the 10 Grads");
		int tempgrade;
		
		do {
			tempgrade = scan.nextInt();
		if(tempgrade > 100 || tempgrade <0) {
			System.out.println("Entered grade is in valid.");
			continue;
		}else {
				//tempgrade = scan.nextInt();
				if(i <10) {grades[i] = tempgrade;
				System.out.println("You have entered " + grades[i]);
				i++;	
		}
		}
		}while(i<10);
		scan.close();
		
		average(grades);
		standardDev(grades);
		
	}
	
	public static void average(int [] grades) {
		double avg = 0;
		for(int grade : grades) {
		avg += grade; 
	}
		avg = avg/grades.length;
		System.out.println("Average : "+ avg);
	}
	
	public static void minimum(int [] grades) {
//		int min = 40;
//		for(int grade : grades) {
//			
//		}
	}
	
	public static void standardDev(int [] grades) {
		
		double avg = 0;
		for(int grade : grades) {
		avg += grade; 
	}
		double standardDeviation=0.0;
		avg = avg/grades.length;
		for(double grade : grades) {
			standardDeviation += Math.pow(grade - avg, 2);
	}
		System.out.println(Math.sqrt(standardDeviation/10));
	}

}
