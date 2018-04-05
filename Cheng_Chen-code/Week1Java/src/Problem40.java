public class Problem40 
{
	 
	public static void main(String[] args) 
	{
		 System.out.println("Fibonacci Series using iterative:");
		 for(int i = 1; i <= 100; i++)
		 {
			 System.out.println(fibonacciIter(i) + " ");
		 }
		 
		 System.out.println("\nFibonacci Series using recursion: ");
		 for(int i = 1; i <= 100; i++)
		 {
			 System.out.println(fibonacciRecur(i) + " ");
		 }
		
	}
	 
	public static int fibonacciIter(int number)
	{
		if (number == 1 || number == 2) {
			return 1;
		}
		int fibo1 = 1, fibo2 = 1, fibonacci = 1;
		for(int i = 3; i <= number; i++)
		{
			fibonacci = fibo1 + fibo2;
			fibo1 = fibo2;
			fibo2 = fibonacci;
		}
		return fibonacci;
	}
	
	public static int fibonacciRecur(int number) 
	{
		if (number == 1 || number == 2) {
			return 1;
		}
 
		return fibonacciRecur(number - 1) + fibonacciRecur(number - 2); 
	}
}
		