package easy_coding_exercises;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class GradesStatistics {
	
	static ArrayList<Integer> tempArray;
	static int[] grades;

	public static void main(String[] args) {
		
		try {
			tempArray = new ArrayList<>();
			Scanner in = new Scanner(new File("src\\main\\java\\grades.txt"));
			while (in.hasNext()) {
				try {
					int temp = in.nextInt();
					if (temp > -1 && temp < 101) {
						tempArray.add(temp);
					}
				} catch (Exception e) {
				}
			} 
			in.close();
			
			grades = new int[tempArray.size()];
			
			for (int i=0; i<tempArray.size(); i++) {
				grades[i] = tempArray.get(i);
			}
			
			int minimumGrade = minimumGrade();
			int maximumGrade = maximumGrade();
			double averageGrade = averageGrade();
			double standardDeviation = standardDeviation(averageGrade);
			
			System.out.println("The minimum grade is " + minimumGrade);
			System.out.println("The maximum grade is " + maximumGrade);
			System.out.println("The average grade is " + averageGrade);
			System.out.println("The standard deviation is " + standardDeviation);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} 
		
	}
	
	public static int minimumGrade() {
		int minimumGrade = -1;
		for (int i=0; i<grades.length; i++) {
			if (i==0) {
				minimumGrade = grades[0];
			} else if (grades[i] < minimumGrade) {
				minimumGrade = grades[i];
			}
		}
		return minimumGrade;
	}
	
	public static int maximumGrade() {
		int maximumGrade = -1;
		for (int i=0; i<grades.length; i++) {
			if (grades[i] > maximumGrade) {
				maximumGrade = grades[i];
			}
		}
		return maximumGrade;
	}
	
	public static double averageGrade() {
		double average = 0;
		for (int i=0; i<grades.length; i++) {
			average += grades[i];
		}
		return average / grades.length;
	}
	
	public static double standardDeviation(double average) {
		double stddev = 0;
		double[] tempArray = new double[grades.length];
		for (int i=0; i<grades.length; i++) {
			tempArray[i] = Math.pow((grades[i] - average),2);
		}
		for (int i=0; i<tempArray.length; i++) {
			stddev += tempArray[i];
		}
		return stddev / grades.length;
	}
	
}
