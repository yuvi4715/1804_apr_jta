// Write a Java application that computes the factorial of a number.

package BonusExercises;

public class question46 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int x = -2; 
		if (x == 0) {
			x = 1;
		} else if (x < 0) {
			x = 0;
		}
		for (int i = x-1; i >0; i--) {
			x = x * i;
		}
		System.out.println(x);
	}

}
