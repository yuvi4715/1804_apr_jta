package advancedCondin43;

//Write a Java program to check if a number is Armstrong or not.


public class AdvancedCoding43 {

	public static void main(String[] args) 
	{
		int result = 0;
		int number = 407;
		int tempNum = number;
		int digits = String.valueOf(number).length();
		int counter = digits;
		System.out.println("The number " + number + " has "+ digits + " digits.");
		
		int[] array = new int[digits];
		while (number > 0) 
		{
			counter--;
			array[counter] = number % 10;
			number = (int) Math.floor(number / 10);
		}
		System.out.println();
		for (int i = 0; i < digits; i++) 
		{
			result += Math.pow(array[i], digits);
		}
		
		if (result == tempNum)
			System.out.println("It is an Armstrong number, the number is equal to the"
					+ " sum of cubes of its digits.");
		else
			System.out.println("It is not an Armstrong number");
	}
	
}
