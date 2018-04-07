package easy_coding_exercises;

public class PrintNumberInWord {
	
	public static void main(String[] args) {
		System.out.println(printNumberInWordA(5));
		System.out.println(printNumberInWordB(10));
	}
	
	public static String printNumberInWordA(int number) {
		if (number < 10) {
			if (number > 8) {
				return "NINE";
			} if (number > 7) {
				return "EIGHT";
			} if (number > 6) {
				return "SEVEN";
			} if (number > 5) {
				return "SIX";
			} if (number > 4) {
				return "FIVE";
			} if (number > 3) {
				return "FOUR";
			} if (number > 2) {
				return "THREE";
			} if (number > 1) {
				return "TWO";
			} if (number > 0) {
				return "ONE";
			}
		}
		return "OTHER";
	}
	
	public static String printNumberInWordB(int number) {
		switch (number) {
		case 1:
			return "ONE";
		case 2:
			return "TWO";
		case 3:
			return "THREE";
		case 4:
			return "FOUR";
		case 5:
			return "FIVE";
		case 6:
			return "SIX";
		case 7:
			return "SEVEN";
		case 8:
			return "EIGHT";
		case 9:
			return "NINE";
		default:
			return "OTHER";
		}
	}

}
