
public class Problem2 
{
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		int a = 2, b = 3, c = 1;
		
		if((a>b) && (a>c))
			System.out.println(a + " is the largest number between " + a + ", " + b + ", and " + c + ".");
		else if((b>a) && (b>c))
			System.out.println(b + " is the largest number between " + a + ", " + b + ", and " + c + ".");
		else if((c>a) && (c>b))
			System.out.println(c + " is the largest number between " + a + ", " + b + ", and " + c + ".");
		else
			System.out.println("Unable to find a largest number.");
	}
}

