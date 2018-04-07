// Write a method that swaps two integer variables without using a third variable.
package BonusExercises;

public class question44 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int x = 10;
		int y = 24;
		y = x + y;
		x = y - x;
		y = y - x;
		System.out.println(x + ", " + y);
	}

}
