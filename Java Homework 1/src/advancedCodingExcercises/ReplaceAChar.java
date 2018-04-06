package advancedCodingExcercises;
// 35 created a method that takes a string and replaces a character within it, printing the updated string.
public class ReplaceAChar {
	
	StringBuilder str = new StringBuilder("Hello I am a string"); // using stringbuilder

	public ReplaceAChar() {
		changeChar();
		System.out.println("Will replace character at index 4 with letter y.");
		print();
	}
	
	void changeChar() {
		System.out.println("The sentence given is: " + str);
		str.setCharAt(4, 'y');
		
	}
	
	void print() {
		System.out.println(str);
	}
	
	public static void main(String[] args) {
		ReplaceAChar t = new ReplaceAChar();
	}
	
}
