/*
 *  Author: Michael Sikorski
 *  Date: 4/6/18
 */

package advanced_coding_exercises;

import java.util.Scanner;
import java.util.Stack;

public class Question44 {
	
	public Question44() {
		
	}
	
	public String reverseString(String s) {
		Scanner in = new Scanner(s);
		StringBuilder original = new StringBuilder(s);
		StringBuilder reversed = new StringBuilder("");
		for (int i=s.length()-1; i>=0; i--) {
			reversed.append(original.charAt(i));
		}
		return reversed.toString();
	}

}
