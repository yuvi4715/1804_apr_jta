/*
 *  Author: Michael Sikorski
 *  Date: 4/6/18
 */

package advanced_coding_exercises;

public class Question41 {
	
	public void FizzBuzz() {
		for (int i=1; i<=50; i++) {
			if (i%3==0) {
				System.out.print("Fizz");
			}
			if (i%5==0) {
				System.out.print("Buzz");
			}
			if (i%3!=0 && i%5!=0) {
				System.out.println(i);
			} else {
				System.out.println();
			}
		}
	}

}
