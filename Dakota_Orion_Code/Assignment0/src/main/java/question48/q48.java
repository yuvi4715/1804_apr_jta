package question48;

public class q48 {
	public static void main(String[] args) {
		int num=5;
		factorial(num);
	}

	static int factorial(int num) {
		return factorialHelper(num,1);
	}
	
	static int factorialHelper(int num,int total) {
		if(num==1) {
			return total;
		}
		return factorialHelper(num-1, total*num);
	}
}
