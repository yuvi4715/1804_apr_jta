package exceptions;

public class _Exceptions {

	public static void main(String[] args) {
		Question10();
		Question11();
		Question12();
		try {
			Question13();
		} catch (Exception e) {
			System.out.println("An exception has been ducked\n");
		}
		Question14();
		Question15();
	}

	public static void Question10() {
		System.out.println("-- Question 10 --");
		System.out.println("A custom exception has been created");
		System.out.println();
	}

	public static void Question11() {
		System.out.println("-- Question 11 --");
		try {
			new ManualThrow();
		} catch (CustomException e) {
			System.out.println(e.getMessage());
		}
		System.out.println();
	}

	public static void Question12() {
		System.out.println("-- Question 12 --");
		try {
			System.out.println("In the try block");
			new ManualThrow();
			System.out.println("Reached end of try block");
		} catch (CustomException e) {
			System.out.println("In the catch block");
			System.out.println("A custom exception has been manually thrown");
			System.out.println("Reached end of catch block");
		}
		System.out.println();
	}

	public static void Question13() throws Exception {
		System.out.println("-- Question 13 --");
		int i = 5/0;
		System.out.println();
	}

	public static void Question14() {
		System.out.println("-- Question 14 --");
		try {
			int i = 5 / 0;
		} catch (Exception e) {

		} finally {
			System.out.println("(Graceful) Goodbye.");
		}
		System.out.println();
	}

	public static void Question15() {
		System.out.println("-- Question 15 --");
		try {
			System.exit(0);
		} finally {
			System.out.println("Will not print");
		}

	}

}
