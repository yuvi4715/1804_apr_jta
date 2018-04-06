package advancedConcepts;
//problem 17, string tokenizer to delimit a given string
import java.util.StringTokenizer;

public class StringDelimited {
	
	static StringTokenizer st = new StringTokenizer("Hello:I:am:not:here",":");
	
	
	public static void main(String[] args) {
		while (st.hasMoreTokens()) {
	         System.out.println(st.nextToken());
	     }
	}
}