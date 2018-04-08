package easyCoding33;

//Write a program called CheckOddEven which prints "Odd Number" 
//if the int variable “number” is odd, 
//or “Even Number” otherwise. 
//Hint: you may use modulus operator.


public class EasyCoding33 
{
		public static void main(String[] args) 
		{
			int number = 13;
			checkOddEven(number);
			number = 1000;
			checkOddEven(number);
		}

		public static void checkOddEven(int number) 
		{
			if (number % 2 == 1)
				System.out.println("Odd Number");
			else
				System.out.println("Even Number");
		}
}
	
	
