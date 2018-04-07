package easyCodingExercises;
/**
 * Dominick Sermeno
 * Batch 1804
 * Q's: 36
 */
public class Arithmetic 
{

	public static void main(String[] args) 
	{
		int number1 = Integer.parseInt(args[0]);
		int number2 = Integer.parseInt(args[1]);
		String operator = args[2];
		int result;
		
		if (operator.equals("+")) 
		{
			result = number1 + number2;		
			System.out.println(result);
			//args: 7 8 +  result: 15
		} 
		else if (operator.equals("-")) 
		{
			result = number1 - number2;		
			System.out.println(result);
			//args: 7 8 -   result: -1
		} 
		else if (operator.equals("'*'"))
		{ 			
			result = number1 * number2;		
			System.out.println(result);
			//args: 7 8 '*'   result: 56
		} 
		else if (operator.equals("/")) 
		{
			result = number1 / number2;		
			System.out.println(result);
			//args: 7 8 /     result: 0
		}
	}
}
