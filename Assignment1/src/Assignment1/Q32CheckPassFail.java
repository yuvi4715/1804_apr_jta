package Assignment1;

import java.util.*;

public class Q32CheckPassFail
{
	public static void main(String args[])
	{
		Scanner in = new Scanner(System.in);
		
		System.out.print("Enter the mark: ");
		int mark=Integer.parseInt(in.nextLine());
		
		in.close();
		
		if(mark>=50)
		{
			System.out.println("PASS");
		}
		else
		{
			System.out.println("FAIL");
		}
	}
}
