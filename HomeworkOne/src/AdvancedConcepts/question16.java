//Create a StringBuilder object. Use at least three methods to manipulate the String.

package AdvancedConcepts;

public class question16 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StringBuilder str = new StringBuilder("testing");
		System.out.println(firstMethod(str));
		System.out.println(secondMethod(str));
		System.out.println(thirdMethod(str));
	}
	
	public static String firstMethod(StringBuilder input) {
		return ((input.append(" success")).toString());
	}
	
	public static String secondMethod(StringBuilder input) {
		return (((input.toString()).substring(2, 6)));
	}
	
	public static char thirdMethod(StringBuilder input) {
		return (((input.toString()).charAt(4)));
	}

}
