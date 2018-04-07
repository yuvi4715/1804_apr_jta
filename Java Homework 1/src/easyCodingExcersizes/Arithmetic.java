package easyCodingExcersizes;
// problem 36  - to allow command line arguments to solve simple mathematical problems
import java.util.Scanner;
import java.util.StringTokenizer;
public class Arithmetic {
	int var1;
	int var2;
	String var3;
	public String[] split;
	StringTokenizer str;

	
	public Arithmetic() {
		 getInput();
		 
	}
	
	
	void getInput() {
		System.out.println("Enter 2 integers separated by space, and an operator.");
		Scanner k = new Scanner(System.in);
		System.out.println("Enter first number");
		var1 = k.nextInt();
		System.out.println("Enter second number");
		var2 = k.nextInt();
		System.out.println("Enter operator");
		var3 = k.next();
		getResult(var1, var2, var3);
		k.close();
		
		
	}
	
	void getResult(int var1, int var2, String var3) {
		switch (var3) { //using a switch for operators
		case "+":
			System.out.println(var1 + " + " + var2 + " = " + (var1+var2) );
			break;
		case "-":
			System.out.println(var1 + " - " + var2 + " = " + (var1-var2) );
			break;
		case "/":
			System.out.println(var1 + " / " + var2 + " = " + (var1/var2) );
			break;
		case "*":
			System.out.println(var1 + " + " + var2 + " = " + (var1*var2) );
			break;
		default:
			System.out.println("Something went wrong, wrong operator...");
		}
		
	}
	
	
	

	public static void main(String[] args) {
		Arithmetic t = new Arithmetic();
	}

}
