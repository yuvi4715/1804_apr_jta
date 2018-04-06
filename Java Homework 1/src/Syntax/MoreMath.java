package Syntax;
// problem 4
public class MoreMath {
	int a = 8;
	int b = 2;
	
	public MoreMath() {
		add(a,b);
		subtract(a,b);
		multiply(a,b);
		divide(a,b);
		
	}
	
	public void add(int a, int b) {
		System.out.println(a + " + "+  b + " = " + (a+b));
	}
	
	public void subtract(int a, int b) {
		System.out.println(a + " - "+  b + " = " + (a-b));
	}
	
	public void multiply(int a, int b) {
		System.out.println(a + " * "+  b + " = " + (a*b));
	}
	
	public void divide(int a, int b) {
		System.out.println(a + " / "+  b + " = " + (a/b));
	}
	
	public static void main(String[] args) {
		MoreMath t = new MoreMath();
		
	}

}
