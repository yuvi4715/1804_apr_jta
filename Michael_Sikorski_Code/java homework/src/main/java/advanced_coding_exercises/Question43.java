/*
 *  Author: Michael Sikorski
 *  Date: 4/6/18
 */

package advanced_coding_exercises;

public class Question43 {
	
//	Armstrong numbers: 0-9, 153, 370, 371, 407
	
	public boolean isArmstrong(int number) {
		double calculated = 0;
		String s = String.valueOf(number);
		for (int i=0; i<s.length(); i++) {
			calculated += Math.pow(Integer.parseInt(s.substring(i, i+1)),s.length());
		}
		return ((int) calculated == number);
	}

}
