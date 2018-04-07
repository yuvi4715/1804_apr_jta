/*
 *  Author: Michael Sikorski
 *  Date: 4/6/18
 */

package advanced_coding_exercises;

public class Question38 {

	public Question38() {
		
	}
	
	public String replaceCharacter(String original, char replace, char replaceWith) {
		String[] replaced = original.split("");
		for (int i=0; i<original.length(); i++) {
			if (original.substring(i, i+1).equals(""+replace)) {
				replaced[i] = ""+replaceWith;
				
			}
		}
		String returnString = "";
		for (int i=0; i<original.length(); i++) {
			returnString += replaced[i];
		}
		
		return returnString;
	}
}
