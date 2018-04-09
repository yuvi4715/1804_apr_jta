//Create a Customer class with:
//	At least 2 constructors
//	At least 2 overloaded methods
//	At least 1 static variable
//	At least 2 static methods
//	At least 1 final variable


package ClassMembers;

public class question7 {
	static int staticVariableExample1 = 2;
	static int staticVariableExample2 = 3;
	final int finalVariableExample = 5;
	
	static {
		staticVariableExample1++;
	}
	
	static {
		System.out.println(staticVariableExample2);
	}
	
	public question7() {
		System.out.println("Overloading without arguments");
	}

	public question7(int x) {
		System.out.println("Overloading with argument");
	}
	
	public static void main (String[] args) {
		question7 output1 = new question7();
		question7 output2 = new question7(10);
		
	}

} 