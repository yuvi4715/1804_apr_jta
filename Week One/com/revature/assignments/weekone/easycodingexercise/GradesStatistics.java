/**
 * 
 */
package com.revature.assignments.weekone.easycodingexercise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Ed M
 * @date Apr 5, 2018
 * @time time 2:28:47 PM
 */
public class GradesStatistics {
	private static int[] gradeStorage;
	private static int size;
	private static ArrayList<Integer> grades = new ArrayList<Integer>();

	public GradesStatistics() {
		// TODO Auto-generated constructor stub
	}

	public static String computations() {
		// average, minimum, maximum, and standard deviation
		int average =0;
		int min = 101;
		int max = 0;
		  for (Integer num : grades) {  
			average += num;
			if( num <= min)
				min =  num;
			if( num >= max)
				max =  num;
			
			//System.out.println(planets[i]);
		}
		int standardDeviation = 0;
		average = average/grades.size();
		
		for(double other: grades) {
            standardDeviation += Math.pow(other - average, 2);
        }

		standardDeviation = (int) Math.sqrt(standardDeviation/10);
		return ("average:"+average+" minimum: "+min+ "maximum: "+max+ "standard deviation:"+standardDeviation);
    }

	public static void main(String[] args) throws Exception {
		// int count = 0;
		// ArrayList<Integer> temp = new ArrayList<Integer>();
		System.out.println("Input Grades 0 - 100 and enter -1 to end stream");
		Scanner sc = new Scanner(System.in);
		int i = 0;
		String tempq;
		while (((i = sc.nextInt()) > 0)) {
			if (i == -1)
				break;
			if (i >= 0 && i <= 100) {
				grades.add(i);
			} else if (!(i >= -1 && i <= 100)) {
				System.out.println("Not a Proper Input");
				throw new Exception();
			}
		}
		// size = temp.size();
		// int[] gradeStorage = temp.stream().mapToInt(Integer::intValue).toArray();
		 System.out.println(grades.toString());
		 System.out.println(computations());
	}

}
