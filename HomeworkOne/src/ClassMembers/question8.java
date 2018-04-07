package ClassMembers;

import java.util.Scanner;

public class question8 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		question7 question7Object = new question7(null);
		
		System.out.println("Enter your name here: ");
		String name = input.nextLine();
		
		question7Object.simpleMessage(name); 
	}

}
