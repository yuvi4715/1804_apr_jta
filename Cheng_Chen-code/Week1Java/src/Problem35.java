
import java.util.Scanner;

public class Problem35 
{

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);	
		int i = 0;
		double d = 0.0;
		String s = null;
		
		System.out.println("Enter Integer: ");
		if(in.hasNextInt())
			i = in.nextInt();
		
		System.out.println("Enter Double: ");
		if(in.hasNextDouble())
			d = in.nextDouble();
		in.nextLine();
		
		System.out.println("Enter String: ");
		if(in.hasNextLine())
			s=in.nextLine();
		
		in.close();
		
		System.out.println("Integer: "+i);
		System.out.println("Double: "+d);
		System.out.println("String: " + s);
	}

}

