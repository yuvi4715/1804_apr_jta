package AdvancedCodingExercises;
import java.util.Scanner;

public class Problem44 {
	public static void main(String[] args) 
	{
		Scanner in = new Scanner(System.in);
		System.out.println("Enter String: ");
		String s="", reverse = "";
		s=in.nextLine();
		in.close();
		
		for(int i = s.length() - 1; i >= 0; i--) 
			reverse += s.charAt(i);
		
		System.out.println(reverse);
	}	

}
