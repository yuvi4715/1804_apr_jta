package AdvancedCodingExercises;

import BonusExercises.question51;

public class question36 {

public question36(int[] input) {
		int replaced = 2;
		int replacing = 5;
		for (int i = 0; i < input.length; i++) {
			for (int j = i + 1; j < input.length; j++) {
				if (input[i] == input[replaced]) {
					input[i] = replacing;
					
				}
			}
		}
	}

	public static void main(String []args) {
      // Following statement would create an object myPuppy
		int[] input = {1, 20, 0, 0, -999, 20};
		question36 revNum = new question36(input);
	}

}
