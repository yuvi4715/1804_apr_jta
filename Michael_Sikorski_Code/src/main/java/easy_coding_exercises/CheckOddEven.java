package easy_coding_exercises;

public class CheckOddEven {
	
	public static void main(String[] args) {
		System.out.println(OddOrEven(2));
		System.out.println(OddOrEven(3));
	}

	public static String OddOrEven(int i) {
		if (i % 2 == 0) {
			return "Even Number";
		} else {
			return "Odd Number";
		}
	}
}
