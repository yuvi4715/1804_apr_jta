package problems1to9;
//problem 4
public class ArithmeticMethod {
	private double x;
	private double y;
	
	public ArithmeticMethod(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public double add() {
		return x + y;
	}
	
	public double subtract() {
		return x - y;
	}
	
	public double multiply() {
		return x * y;
	}
	
	public double divide() {
		double z;
		try {
			z = x /y;
			return z;
		}
		catch(Exception e) {
			System.out.println(e);
			return 0;
		}
	}
}
