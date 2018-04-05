package easy_coding_exercises;

public class CheckPassFail {
	
	public static void main(String[] args) {
		System.out.println(result(20));
		System.out.println(result(70));
	}
	
	public static String result(int mark) {
		if (mark < 50) {
			return "FAIL";
		} else {
			return "PASS";
		}
	}

}
