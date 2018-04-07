package syntax;
/**
 * Dominick Sermeno
 * Batch 1804
 * Q's: 4
 */
public class CalculatorInOneClass 
{
	public static void main(String[] args) 
	{
		CalculatorInOneClass cal = new CalculatorInOneClass();
		cal.add(7, 3);
		cal.subtract(900, 899);
		cal.multiply(9, 7);
		cal.divide(56, 8);
		
	}
	
	
	
	public void add(int first,int second)
	{
		int answer = -1;
		answer = first + second;
		System.out.println("Add: " + first + " + " +second +" = " + answer);
	}

	public void subtract(int first,int second)
	{
		int answer = -1;
		answer = first - second;
		System.out.println("Subtract: " + first + " - " +second +" = " + answer);
	}
	
	public void multiply(int first,int second)
	{
		int answer = -1;
		answer = first * second;
		System.out.println("Multiply: " + first + " * " +second +" = " + answer);
	}
	
	public void divide(int first,int second)
	{
		double answer = -1;
		answer = first / second;
		System.out.println("Divide: " + first + " / " +second +" = " + answer);
	}

}
