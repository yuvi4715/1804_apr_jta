import java.util.Scanner;

public class Problem43 {

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		System.out.println("Enter number: ");
		int number;
		number=in.nextInt();
		in.close();
		
		int cube = 0, a, temp;
		temp = number;
		
		while(number > 0)
		{
			a = number%10;
			number = number/10;
			cube = cube + (a*a*a);
		}
	
		if(temp == cube)
			System.out.println("Is an Armstrong Number.");
		else 
			System.out.println("Not an Armstrong Number.");
	}
}
