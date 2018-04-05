package easyCodingExercises;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner; 

public class GradesStatistics {

	public static void main(String[] args) {


		Scanner scan = new Scanner(System.in);
		
		//size of the array
		 System.out.println("How many grades are you adding?");
		int n = scan.nextInt();
		int[] intArray = new int[n];
		
		
		// fill array
		for (int i = 0; i < intArray.length; i++)
	    {
	        System.out.println("Please enter number");
	        intArray[i] = scan.nextInt();
	    }

				
		
		System.out.println(calculateSD(intArray));
		System.out.println(sum(intArray));
		System.out.println(maxMin(intArray)[0] +" min");
		System.out.println(maxMin(intArray)[1]+ " max");
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



