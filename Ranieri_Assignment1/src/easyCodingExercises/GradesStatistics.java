package easyCodingExercises;

import java.util.Arrays;
import java.util.Scanner; 

public class GradesStatistics {

	public static void main(String[] args) {

		int[] thisIsAnIntrray = new int[10];
		
	}
	
	// standard deviation
	public static double calculateSD(int numArray[])
    {
        double sum = 0.0, standardDeviation = 0.0;

        for(double num : numArray) {
            sum += num;
        }

        double mean = sum/10;

        for(double num: numArray) {
            standardDeviation += Math.pow(num - mean, 2);
        }

        return Math.sqrt(standardDeviation/10);
    }
	
	
	// sumation
	public static int sum(int numArray[]) {
		
		int sum = Arrays.stream(numArray).sum();
		return sum;
	}

	
	public static int [] maxMin(int numArray[]) {
		
		int smallest = numArray[0];
		int largest = numArray[0];
		
		for (int i : numArray) {
		    if (i < smallest) {
		        smallest = i;
		    } // end finding smallest
		    else if (i > largest) {
		        largest = i;
		    } // end finding largest number 
		} // 
		int [] minMax = {smallest,largest};
		return minMax;
	}
}
