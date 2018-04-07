/*
 *  Author: Michael Sikorski
 *  Date: 4/6/18
 */

package advanced_coding_exercises;

public class Question45 {

	public boolean isPrime(int i) {
		for (int j=1; j<=i; j++) {
			if (i % j == 0 && i != j && j != 1) {
				return false;
			}
		}
		return true;
	}
	
}
