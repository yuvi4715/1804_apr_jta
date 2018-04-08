//John Eifert
package Advanced_Concepts;

public class Q20
{
	public static void main(String args[])
	{
		Runtime run = Runtime.getRuntime();
		
		//I can use this to try to keep the amount of memory that a program uses under control:
		run.gc();
		//I can use this to try to keep track of how much more memory a program can afford to use:
		System.out.println(run.freeMemory());
		//I can use this to try to keep track of the total amount of memory that a computer has while running a program:
		System.out.println(run.totalMemory());
	}
}
