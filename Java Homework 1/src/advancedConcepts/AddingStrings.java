package advancedConcepts;
// problem 18 -  two string objects of numbers are added together.
// problem 19, requested garbage collection within addStrings method
public class AddingStrings {
	String s1 = "20";
	String s2 = "30";
	
	public AddingStrings() {
		addStrings();
	}
	
	void addStrings() {
		int one = Integer.parseInt(s1);
		int two = Integer.parseInt(s2);
		System.out.println(s1 + " + " + s2 + " = "   + (one+two));
		System.gc(); // garbage collector requested
		
	}
	
	public static void main(String[] args) {
		AddingStrings t = new AddingStrings();
		
	}
}
