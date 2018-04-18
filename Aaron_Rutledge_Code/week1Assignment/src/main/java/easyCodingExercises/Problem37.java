package easyCodingExercises;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Problem37 {
	
	
	public static List<Integer> grades = new LinkedList<>();
	public static float mu = 0;
	public static int min = 0;
	public static int max = 0;
	public static double sigma = 0;
	
	
	
	public static void main(String[] args) {
		
		gradesStatistics();
		
		
	}
	
	public static void gradesStatistics() {
		
		Scanner cin = new Scanner(System.in);
		
		String str = new String();
		int temp = 0;
		
		do {
			System.out.println("Enter a grade to add it or type -1 to exit: ");
			str = cin.nextLine();
			
			temp = Integer.valueOf(str);
			if (temp >= 0 && temp <= 100) {
				grades.add(Integer.valueOf(str));
				System.out.println("Grade of " + Integer.valueOf(str) + "accecpted.");
				
			} else if (temp != -1) {
				
				System.out.println("Something went wrong. Try again.");
				
			}
			
			
		} while (temp != -1);
		System.out.println("Exiting grade entry.");
		cin.close();
		
		System.out.println("  Min: " + calcMin());
		System.out.println("  Max: " + calcMax());
		System.out.println("   Mu: " + calcMu());
		System.out.println("Sigma: " + calcSigma());
		

	}
	
	public static int calcMin() {
		
		min = 100;
		for(Integer i : grades) {
			
			if (i < min) {
				min = i;
			}
		}
		return min;
		
		
	}
	
	public static int calcMax() {
		
		
		max = 0;
		for(Integer i : grades) {
			
			if (i > max) {
				max = i;
			}
		}
		return max;
		
		
		
	}
	
	public static float calcMu() {
		
		float temp = 0;
		float sum = 0;
		for (Integer i : grades) {
			
			sum = sum + i;
			temp = temp + 1;
			
		}
		mu = sum/temp;
		return mu;
		
	}
	
	public static double calcSigma() {
		
		List<Float> dif = new LinkedList<>();
		for(Integer i : grades) {
			dif.add((i - mu)*(i-mu));
		}
		
		double muOfSqu = 0;
		float temp = 0;
		
		for(Float i : dif) {
			
			muOfSqu = muOfSqu + i;
			temp = temp + 1;
			
		}
		
		muOfSqu = muOfSqu / temp;
		
		sigma = Math.sqrt(muOfSqu);
		
		
		return sigma;
		
		
	}
	

}
