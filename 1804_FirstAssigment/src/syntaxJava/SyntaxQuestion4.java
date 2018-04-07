package syntaxJava;

//Write a program to add, subtract, multiply and divide two numbers 
//using methods with parameters using only one class.


public class SyntaxQuestion4 {

	int a = 7;
	int b = 7;
	int add;
	int mult;
	int subs;
	int div;
	
	
	SyntaxQuestion4()  {
		
		BasicOperations();
	}
	
	public void BasicOperations() {
		
	add = a + b;
	System.out.println(a + " + " + b + " = " + add);
		
		//a + sign is needed every time there is an integer next to a string in println
		
	subs = a - b;
	System.out.println(a + " - " + b + " = " + subs);

	mult = a * b;
	System.out.println(a + " * " + b + " = " + mult);

	div = a / b;
	System.out.println(a + " / " + b + " = " + div);

	
	}
	
	
	public static void main(String[] args) {	
		
		new SyntaxQuestion4();
	
	}
	
}
