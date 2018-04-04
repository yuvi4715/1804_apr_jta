package advanced_concepts;

import java.util.StringTokenizer;

public class _AdvancedConcepts {

	public static void main(String[] args) {
		// 16. Create a StringBuilder object. Use at least three methods to manipulate
		// the String.
		// 17. Create a new String with delimited tokens, such as
		// “pickles:ketchup:mustard:onion” and use
		// StringTokenizer to parse out and print each token.
		// 18. Create two String objects with number values (i.e. “20). Write a method
		// that adds the two.
		// 19. Request garbage collection in your method.
		// 20. Create a Runtime object and note at least three methods. Imagine how you
		// would use them.
		Question16();
		Question17();
		Question18();
		Question19();
		Question20();
	}

	public static void Question16() {
		System.out.println("-- Question 16 --");
		System.out.println();
	}

	public static void Question17() {
		System.out.println("-- Question 17 --");
		String tracks = "Ghost In The Machine:Evolution:Silicon Messiah:"
				+ "Born As A Stranger:The Hunger:The Brave:Identity:"
				+ "Reach For The Horizon:The Launch:Stare At The Sun";
		StringTokenizer st = new StringTokenizer(tracks, ":");
		while (st.hasMoreTokens()) {
			System.out.print(st.nextToken() + ",");
		}
		System.out.println();
	}

	public static void Question18() {
		System.out.println("-- Question 18 --");
		String firstNumber = "2000";
		String secondNumber = "2018";
		System.out.println(firstNumber + " + " + secondNumber + " = " + addStrings(firstNumber, secondNumber));
		System.out.println();
	}

	public static int addStrings(String first, String second) {
		int result = -1;
		int one;
		int two;
		try {
			one = Integer.parseInt(first);
			two = Integer.parseInt(second);
			result = one + two;
		} catch (Exception e) {

		}
		return result;
	}

	public static void Question19() {
		System.out.println("-- Question 19 --");
		System.out.println();
	}

	public static void Question20() {
		System.out.println("-- Question 20 --");
		System.out.println();
	}
}
