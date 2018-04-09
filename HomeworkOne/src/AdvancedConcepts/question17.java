//Create a new String with delimited tokens, such as “pickles:ketchup:mustard:onion” and use StringTokenizer to parse out and print each token.

package AdvancedConcepts;

public class question17 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String delimiter = ":";
		String str = "pickles:ketchup:mustard:onion";
		String[] splitted = str.split(delimiter);

		for (String s : splitted) {
		    System.out.println(s);
		}

	}

}
