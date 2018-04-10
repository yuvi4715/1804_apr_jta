package question16;

public class q16 {

	public static void main(String[] args) {
		StringBuilder sb = new StringBuilder("Hi");
		System.out.println("Current String sb: "+sb.toString());
		System.out.println("Appending ' Yuvi' to the string");
		sb.append(" Yuvi");
		System.out.println("Current String sb: "+sb.toString());
		System.out.println("replacing the word Hi with Hello");
		sb.replace(0, 2, "Hello");
		System.out.println("Current String sb: "+sb.toString());
	}

}
