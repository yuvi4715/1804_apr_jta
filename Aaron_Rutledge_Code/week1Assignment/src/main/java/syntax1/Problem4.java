package syntax1;

public class Problem4 {

	public int x;
	public int y;
	
	public Problem4() {
		//default constructor initializes members to 0
		x = 0;
		y = 0;
		
	}
	
	
	public Problem4(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
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
		
		if (y == 0) {
			return 0;
		}
		else {
			return (x / y);
		}
		
	}


}
