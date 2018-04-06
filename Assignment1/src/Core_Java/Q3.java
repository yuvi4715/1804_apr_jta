//John Eifert
package Core_Java;

public class Q3 
{
	public static void main(String args[])
	{
		boolean a;
		boolean b;
		
		a=true;
		b=false;
		
		System.out.println("!a = " + !a);
		System.out.println("a|b = " + (a|b));
		System.out.println("(!a & b) | (a & !b) = " + ((!a & b) | (a & !b)));
	}
}
