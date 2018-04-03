package coreJava;

public class Problem2 {
	
	public int greatestOfThree(int x, int y, int z) {
		if  ((x >= y) && (x >= z)){
			
			return x;
		}
		else if ((y >= x) && (y >= z)) {
			
			return y;
		}
		else if ((z >= x) && (z >= y)) {
			
			return z;
		}
		
		return 0;
		
	}

}
