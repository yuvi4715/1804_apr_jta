package problems1to9;
//problem 2
public class GreatestShort {
	public static void main(String[] args) {
		int x = 5;
		int y = 10;
		int z = 23;
		
		if(x > y && x > z) {
			System.out.println(x);
		}
		else if(y > x && y > z) {
			System.out.println(y);
		}
		else {
			System.out.println(z);
		}
	}
}
