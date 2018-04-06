
public class Problem4 {

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		int a = 4, b = 8;
		
		System.out.println("4 + 8 = " + add(a, b));
		System.out.println("4 - 8 = " + subtract(a, b));
		System.out.println("4 * 8 = " + multiply(a, b));
		System.out.println("8 / 4 = " + divide(b, a));
	}

	public static int add(int a, int b)
	{
		return a + b;
	}
	
	public static int subtract(int a, int b)
	{
		return a - b;
	}
	
	public static int multiply(int a, int b)
	{
		return a * b;
	}
	
	public static int divide(int a, int b)
	{
		return a / b;
	}
}
