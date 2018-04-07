// Write a program to find common elements between two arrays.
// 1. use 2 for loop's iterate through the two input arrays
// 2. output if they are equal

package BonusExercises;

import java.util.Arrays;

public class question57 {
	public question57(int[] input1, int[] input2) {
		
		for (int i = 0; i < input1.length; i++) {
			for (int j = 0; j < input2.length; j++) {
				if (input1[i] == input2[j]) {
					System.out.print(input1[i] + " ");

				}
			}
		}
	}

	public static void main(String []args) {
      // Following statement would create an object myPuppy
		int[] input1 = {1, 2, 0, 5, -999, 20};
		int[] input2 = {10, -999, 5, 5, 20, 9};
		question57 revNum = new question57(input1, input2);
	}

}
