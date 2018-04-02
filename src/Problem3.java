
public class Problem3 
{
	public static void main(String[] args) 
	{
		boolean a = true;
		boolean b = false;
		
		System.out.println("!a is " + !a);
		System.out.println("a | b is " + (a|b));
		System.out.println("(!a & b) | (a & !b) is " + ((!a & b) | (a & !b)));
	}
}
