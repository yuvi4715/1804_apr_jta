import java.util.Scanner;

public class Problem37 
{
	 public static void main(String[] args) 
	 {		
		 Scanner in = new Scanner(System.in);	
		 int[] grades = new int[10];
		 int min = 0, max = 0;
		 int NumGrades=0;
		 System.out.println("Enter Number");
		
		 while(in.hasNextInt()) 
		 {
			 System.out.println("Enter Number");
			 int temp = in.nextInt();
			
			 if(NumGrades==0) 
			 {
				 min=temp;
				 max=temp;
			 }
			
			 if(temp<min)
				 min=temp;
			
			 if(temp>max)
				 max=temp;
			
			 grades[NumGrades]=temp;	
			 NumGrades++;
			 if(NumGrades == grades.length)
				 grades=expandArray(grades);
		 }
		
		 int sum=0;
		 for(int f:grades) 
		 {
			 sum+=f;
		 }
		
		 int avg = average(sum, NumGrades);
		
		 int stdDev = StandardDeviation(grades, avg, NumGrades);
		
		 System.out.println("Min = "+min+" \nMax = "+max +" \nMean = "+avg+" \nStandard Deviation = "+stdDev);
	 }
	 
	 public static int average(int sum, int total)
	 {
		 return (sum/total);
	 }
	 
	 public static int StandardDeviation(int[] grades, int avg, int total)
	 {
		 int stdSum = 0;
		 for(int f:grades) 
		 {
			 stdSum+=(f-avg)*(f-avg);
		 }
		
		 int stdMean = (stdSum/total);
		 int stdDev = (int)Math.sqrt(stdMean);
		 
		 return stdDev;
	 }
	 
	 public static int[] expandArray(int[] input) 
	 {
		 int[] result = new int[input.length*2];
		 for(int i=0;i<input.length;i++) 
		 {
			 result[i]=input[i];
		 }
		 return result;
	 }
}
