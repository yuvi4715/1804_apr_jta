package easyCodingExcersizes;
// problem 32 - write a simple program that writes PASS if score is 50 more, or fail if less than 50
import java.util.Scanner;
public class CheckPassFail {
	
	static void getResult() {
		Scanner k = new  Scanner(System.in);
		
		System.out.println("What was the score?");
		int score = k.nextInt();
		if (score >= 50) {
			System.out.println("PASS");
		} else {
			System.out.println("Fail");
		}
		k.close();
	}

	public static void main(String[] args) {
		getResult();
	}

}
