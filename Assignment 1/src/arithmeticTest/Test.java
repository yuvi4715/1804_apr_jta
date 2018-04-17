package arithmeticTest;

//problem 5
public class Test {
	public static void main(String[] args) {
		int x = 5;
		int y = 20;
		
		Arithmetic test = new Arithmetic(x,y);
		
		test.add();
		test.subtract();
		test.multiply();
		test.divide();
	}
}
