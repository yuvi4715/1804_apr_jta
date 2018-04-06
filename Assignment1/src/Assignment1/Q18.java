package Assignment1;

public class Q18 
{
	public static void main(String args[])
	{
		String num1 = "5";
		String num2 = "11";
		
		System.out.println(adder(num1, num2));
		
		return;
	}
	
	public static int adder(String n1, String n2)
	{
		return(Integer.parseInt(n1) + Integer.parseInt(n2));
	}
}
