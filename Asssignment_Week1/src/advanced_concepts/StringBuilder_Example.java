package advanced_concepts;
//Kevin Rivera - Revature
//Assignment Week 1: Advanced Concepts - Problem 16.
//This class contains an example of StringBuilder and 3 of its methods in use.

public class StringBuilder_Example {
	public static void main(String[] args) {
		StringBuilder sb = new StringBuilder("This is a string.");
		//Using .append()
		sb.append("Hello String.");
		//Using .length()
		System.out.println("Current length of string: " + sb.length());
		//Using .indexOf()
		System.out.println("the substring 'str' starts at: " + sb.indexOf("str"));
	}
}
