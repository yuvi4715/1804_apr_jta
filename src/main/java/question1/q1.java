package question1;

public class q1 {
	static int first = 8;
	static int second = 2;
	
	public static int add(int first, int second) {
		System.out.println("adding " + first +" to " + second);
		return first+second;
	}
	
	public static int subtract(int first, int second) {
		System.out.println("subtracting " + first +" by " + second);
		return first-second;
	}
	
	public static int multiply(int first, int second) {
		System.out.println("multiplying " + first +" by " + second);
		return first*second;
	}
	
	public static int divide(int first, int second) {
		System.out.println("dividing " + first +" by " + second);
		return first/second;
	}
	
	public static void main(String[] args) {
		System.out.println(add(first,second));
		System.out.println(subtract(first,second));
		System.out.println(multiply(first,second));
		System.out.println(divide(first,second));
	}
}
