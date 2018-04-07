// Find a duplicate number from an array of 1 to N numbers.
// 1. outer for loop trace through array
// 2. inner for loop trace through the rest of the arrays
// 3. print, if the outer array value is equal to the inner array value

package BonusExercises;

import java.util.Arrays;

public class question51 {
	public question51(int[] input) {
		
		for (int i = 0; i < input.length; i++) {
			for (int j = i + 1; j < input.length; j++) {
				if (input[i] == input[j]) {
					System.out.print(input[i] + " ");

				}
			}
		}
	}

	public static void main(String []args) {
      // Following statement would create an object myPuppy
		int[] input = {1, 20, 0, 0, -999, 20};
		question51 revNum = new question51(input);
	}

}
