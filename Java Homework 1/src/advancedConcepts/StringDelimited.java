package advancedConcepts;
//problem 17, string tokenizer to delimit a given string
import java.util.StringTokenizer;

public class StringDelimited {
	
	static StringTokenizer st = new StringTokenizer("Hello:I:am:not:here",":");
	
	
	public static void main(String[] args) {
		while (st.hasMoreTokens()) { // while it has more tokens, the next token is returned
	         System.out.println(st.nextToken());
	     }
	}
}