package easyCoding34;

import java.io.PrintStream;
import java.util.Scanner;

//Write a program called PrintNumberInWord which prints "ONE", "TWO",... , 
//"NINE", "OTHER" if the int variable "number" is 1, 2,... , 9, or other, respectively. 
//Use (a) a "nested-if" statement; (b) a "switch-case" statement.

public class EasyCoding34 
{

		 public static void main(String[] args) 
		 {
			 PrintToConsole(System.out);
		 }
		 
		 
		 @SuppressWarnings("resource")
		public static void PrintToConsole(PrintStream out) 
		 {
			Scanner in = new Scanner(System.in);	
			int number = 0;
			out.println("Enter Number");
			if(in.hasNextInt())
				number = in.nextInt();
			if(number==1) 
			{
				out.println("ONE");
			} else if(number==2) 
			{
				out.println("TWO");
			} else if(number==3) 
			{
				out.println("THREE");
			} else if(number==4) 
			{
				out.println("FOUR");
			} else if(number==5) 
			{
				out.println("FIVE");
			} else if(number==6) 
			{
				out.println("SIX");
			} else if(number==7) 
			{
				out.println("SEVEN");
			} else if(number==8) {
				out.println("EIGHT");
			} else if(number==9) {
				out.println("NINE");
			} else{
				out.println("OTHER");
			}
			
			
			switch(number) 
			{
			case 1:
				out.println("ONE");
				break;
			case 2:
				out.println("TWO");
				break;
			case 3:
				out.println("THREE");
				break;
			case 4:
				out.println("FOUR");
				break;
			case 5:
				out.println("FIVE");
				break;
			case 6:
				out.println("SIX");
				break;
			case 7:
				out.println("SEVEN");
				break;
			case 8:
				out.println("EIGHT");
				break;
			case 9:
				out.println("NINE");
				break;
			default:
				out.println("OTHER");
				break;
			}
		}
}

