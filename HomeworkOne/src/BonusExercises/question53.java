// Write a program to find duplicate characters in a String. 
// 1. split string into an array. 
// 2. outer for loop trace through array
// 3. inner for loop trace through the rest of the arrays
// 4. print, if the outer array value is equal to the inner array value
package BonusExercises;

public class question53 {


	public question53(String input) {
		String[] parts = input.split("");

		for (int i = 0; i < parts.length; i++) {
			for (int j = i + 1; j < parts.length; j++) {
				if (parts[i].equals(parts[j])) {
					System.out.print(parts[i] + " ");

				}
			}
		}
	}

	public static void main(String []args) {
      // Following statement would create an object myPuppy
		question53 revNum = new question53("Bobby Tarantino");
	}

}
