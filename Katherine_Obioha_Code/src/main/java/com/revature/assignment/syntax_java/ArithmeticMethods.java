package syntax_java;

/**
 * @katherine Obioha
 * 
 * This class answers question 5.2
 */
public class ArithmeticMethods {

	ArithmeticMethods()
	{
		
	}
	
	protected void multiply(int y, int x)
	{
		System.out.println(y*x);
		
	}
	protected void add(int y, int x)
	{
		System.out.println(y+x);
		
	}
	protected void subtract(int y, int x)
	{
		System.out.println(y-x);
		
	}
	protected void divide(int y, int x)
	{
		System.out.printf("%.1f\n", (float)(y/x));
		
	}
}
