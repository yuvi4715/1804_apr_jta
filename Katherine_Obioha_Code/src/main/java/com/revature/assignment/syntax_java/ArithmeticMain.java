package syntax_java;

/**
 * 
 * @author katherine Obioha
 * 
 *         This class answers Question 5.1
 *
 */
public class ArithmeticMain {

	static int y = 3;
	static int u = 2;

	public static void main(String[] args) {

		ArithmeticMethods operations = new ArithmeticMethods();
		operations.add(y, u);
		operations.subtract(u, y);
		operations.multiply(u, y);
		operations.divide(y, u);
	}
}
