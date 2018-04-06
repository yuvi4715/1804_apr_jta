package EasyCodingExercises;
import java.util.Scanner;
public class Problem36 {

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		if(args.length<3) 
		{
			System.out.println("Requires two integers followed by an arithmetic operator.");
			System.exit(0);
		}
		
		int a = Integer.parseInt(args[0]);
		int b = Integer.parseInt(args[1]);
		
		switch(args[2]) 
		{
			case "+":
				System.out.println(a+b);
				break;
			case "/":
				System.out.println(a/b);
				break;
			case "*":
				System.out.println(a*b);
				break;
			case "-":
				System.out.println(a-b);
				break;
		}

	}

}
