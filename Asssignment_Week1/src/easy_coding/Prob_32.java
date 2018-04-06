package easy_coding;
//Kevin Rivera - Revature
//Assignment Week 1: Easy Coding Exercises - Problem 32.
//This class prints if a variable is greater than or equal to 50.

public class Prob_32 {
	public static void main(String[] args) {
		int mark = 49;
		checkPassFail(mark);
		mark = 50;
		checkPassFail(mark);
		mark = 51;
		checkPassFail(mark);
	}
	
	public static void checkPassFail(int mark) {
		if (mark >= 50)
			System.out.println("PASS");
		else
			System.out.println("FAIL");
	}
}
