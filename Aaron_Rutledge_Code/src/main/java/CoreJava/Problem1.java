package CoreJava;

public class Problem1 {
	
	//write a program to add, subtract, multiply, and divide two non-zero hard-coded numbers

	public int x;
	public int y;
	
	Problem1() {
		//constructor hardcodes the numbers
		x = 15;
		y = 3;
		
	}
	
	public int addFunction () {
		
		return (x + y);
		
	}
	
	public int subtractFunction () {
		
		return (x - y);
		
	}
	
	public int multiplyFunction () {
		
		return (x * y);
	}
	
	public int divideFunction () {
		
		return (x / y);
	}


}
