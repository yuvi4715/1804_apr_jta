package advancedCoding41;

//Write a Java program that prints the numbers from 1 to 50. 
//But for multiples of three print "Fizz" instead of the number and for the multiples of five print "Buzz". 
//For numbers which are multiples of both three and five print "FizzBuzz"

public class AdvancedCoding41 
{

		public static void main(String[] args) 
		{
			for(int a = 0; a < 51; a++) 
			{
				if (a % 3 == 0 && a % 5 == 0)
					System.out.println("FizzBuzz");
				
				else if (a % 3 == 0)
					System.out.println("Fizz");
				
				else if (a % 5 == 0)
					System.out.println("Buzz");
				
				else
					System.out.println(a);
			}
		}
}
