package easyCodingExcersizes;
//35 get inputs of 3 types and print them out
import java.util.Scanner;

public class KeyboardScanner {
	

	static void getInput() {
		Scanner k = new Scanner(System.in);
		
		int num = k.nextInt();
		double number = k.nextDouble(); 
		String word = k.next();
		
		System.out.println("Int " + num);
		System.out.println("Double " +  number);
		System.out.println("String "+ word );
		k.close();
	}
	
	public static void main(String[] args) {
		getInput();
	}
}
