package assignment.Joey.EasyCodingProgram;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import org.apache.commons.math3.stat.descriptive.moment.StandardDeviation;

/**6. Write a program called GradesStatistics, 
 * which reads in n grades (of int between 0 and 100, inclusive) 
 * and displays the average, minimum, maximum, and standard deviation. 
 * Your program shall check for valid input. 
 * You should keep the grades in an int[] and 
 * use a method for each of the computations.
 * @author joeyi
 *
 */
public class GradesStatistics {
	static double[] grades;
	static Double avg=null;
	Float average=null;
	Double sd = null;
	
	public static void main(String[] args) throws FileNotFoundException {
		
		ArrayList<Double> temp = new ArrayList <>();
		Scanner sc= new Scanner(new File("C:\\Users\\joeyi\\spring-workspace\\1804_apr_java_spring\\src\\main\\resources\\grades"));
		while(sc.hasNextInt())
		{
			temp.add((double) sc.nextInt());
		}
		sc.close();
		//grades=temp.toArray(new Double [temp.size()]);
		grades = temp.stream().mapToDouble(d->d).toArray();
		for(double i: grades) {System.out.println(i);}
		//for(int i: grades) {System.out.println(i);}
		//System.out.println(grades.toString());
		System.out.println(returnMin());
		System.out.println(returnMax());
		System.out.println(returnAvg(grades));
		StandardDeviation std = new StandardDeviation();
		System.out.println("STD from Math API:"+std.evaluate(grades));
		System.out.println("STD from method:"+calcSTD(grades));
		}
	
	public static double returnMin() {
		int min=100; //set min to max
		for(int i=0; i<grades.length;i++) {
			if (min>grades[i]) min=(int) grades[i];
		} //if [1] is less than [0], if [2] is less than [1]
		return min;
	}
	
	public static double returnMax() {
		int max=0; //set min to max
		for(int i=0; i<grades.length;i++) {
			if (max<grades[i]) max=(int) grades[i];
		}
		return max;	
	}
	
	public static double returnAvg(double[] temp) {
		
		avg=((returnSum(temp))/temp.length);
		return avg;	
	}
	
	public static double returnAvg() {
		
		return avg;
	}
	
	public static double returnSum(double [] temp) {
		double sum=0;
		for(int i=0; i<temp.length;i++) {
			sum+=temp[i];
		}
		return sum;
	}
	/**
	 *  calculate mean of array.

  loop through values

       array value = (indexed value - mean)^2    

  calculate sum of the new array.

  divide the sum by the array length

  square root it 
	 * @return
	 */
	public static double calcSTD(double [] temp) {
		double std;
		double avg=returnAvg(temp);
		double [] gradesTemp = new double[temp.length];
		for(int i=0; i<temp.length;i++) 
		{
			gradesTemp[i]=Math.pow((temp[i]-avg),2);
		}
		double sum= returnSum(gradesTemp);
		std= Math.sqrt(sum/gradesTemp.length);
		return std;
	}
	
	

}
