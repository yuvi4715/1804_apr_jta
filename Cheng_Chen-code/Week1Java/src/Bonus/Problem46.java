package Bonus;

public class Problem46 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int a = 20;
		int b = 30;
		System.out.println("a is " + a + "\nb is " + b);
		
		a = helper(b, b = a);
		System.out.println("a is " + a + "\nb is " + b);
	}
	
	public static int helper(int a, int b)
	{
		return a;
	}
}
