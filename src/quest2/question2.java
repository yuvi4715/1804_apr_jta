package quest2;

import java.util.Scanner;

public class question2 {

	public static void main(String[] args) {
		int x,y,z;
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Enter the numbers");
		
		x = scan.nextInt();
		y = scan.nextInt();
		z = scan.nextInt();
		
		if((x > y) && (x > z)) {
			System.out.println(x + " Greater");
		}
		else if((y > x) && (y > z)) {
			System.out.println(y + " Greater");
		}
		else {
			System.out.println(z + " Greater");
		}
	}

}
