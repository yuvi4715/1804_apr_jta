//John Eifert
package Easy_Coding_Exercises;

import java.util.Scanner;
import java.util.ArrayList;

public class Q37GradesStatistics
{
	public static void main(String args[])
	{
		Scanner in = new Scanner(System.in);
		
		//Reads in the number of grades from user input:
		System.out.print("How many grades are there? ");
		int numGrades=Integer.parseInt(in.nextLine());
		
		ArrayList<Integer> grades = new ArrayList<Integer>();
		
		boolean isValid=true;
		
		//Reads in the grades from user input:
		int newGrade=0;
		for(int i=0; i<numGrades; i++)
		{
			isValid=true;
			System.out.print("Please enter a grade: ");
			try
			{
				newGrade=Integer.parseInt(in.nextLine());
			}
			catch(Exception e)
			{
				System.out.println("You seem to have entered something other than an integer.  Please try again.");
				isValid=false;
			}
			//Check for valid input:
			if(isValid)
			{
				if(newGrade >= 0 && newGrade <= 100)
				{
					grades.add(newGrade);
				}
				else
				{
					isValid=false;
					while(!isValid)
					{
						System.out.println("You seem to have entered an invalid grade.  Please try again.");
						System.out.print("Please enter a grade: ");
						newGrade=Integer.parseInt(in.nextLine());
						if(newGrade >= 0 && newGrade <= 100)
						{
							grades.add(newGrade);
							isValid=true;
						}
					}
				}
			}
			else
			{
				i--;
			}
		}
		
		//Finds and prints the Statistics:
		double average=0;
		for(int i=0; i<grades.size(); i++)
		{
			average+=grades.get(i);
		}
		average=average/grades.size();
		System.out.println("Average = " + average);
		
		int min=100;
		for(int i=0; i<grades.size(); i++)
		{
			if(grades.get(i) < min)
			{
				min=grades.get(i);
			}
		}
		System.out.println("Minimum = " + min);
		
		int max=0;
		for(int i=0; i<grades.size(); i++)
		{
			if(grades.get(i) > max)
			{
				max=grades.get(i);
			}
		}
		System.out.println("Maximum = " + max);
		
		double stanDev=0;
		for(int i=0; i<grades.size(); i++)
		{
			stanDev+=Math.pow(grades.get(i)-average, 2);
		}
		stanDev=stanDev/grades.size();
		stanDev=Math.sqrt(stanDev);
		System.out.println("Standard Deviation = " + stanDev);
		
		
		in.close();
	}
}
