package CoreJava;
// Problem 2, can be done via entering the numbers when prompted.
import java.util.Scanner;


public class GreatestOfThree {
	Scanner keyboard = new Scanner(System.in);
	int a;
	int b;
	int c;
	
	public GreatestOfThree(){
		input();
		result();
		
	}
	
	public int determineMax(int a, int b, int c) {
		int max = 0;
		if (a > b && a > c) { // short circuit operators here
			max = a;	
		}
		if (b > a &&  b > c) {
			max = b;
		}
		if (c > a && c > b) {
			max = c;
		}
		
		return max;
	}
	
	
	
	public void result() {
		System.out.println("Based on input, the largest number is: " + determineMax(a,b,c)+".");
	}
	
	public static void main(String[] args) {
		GreatestOfThree t = new GreatestOfThree();

	}
	
	public void input() {
		System.out.println("Enter first number");
		a = keyboard.nextInt();
		System.out.println("Enter second number");
		b = keyboard.nextInt();
		System.out.println("Enter third number");
		c = keyboard.nextInt();
	}

}
