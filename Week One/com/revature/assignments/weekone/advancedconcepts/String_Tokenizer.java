/**
 * 
 */
package com.revature.assignments.weekone.advancedconcepts;

import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * @author Ed M
 * @Creation time 9:38:30 AM
 */
public class String_Tokenizer {

	/**
	 * 
	 */
	public String_Tokenizer() {
		// TODO Auto-generated constructor stub
	}
	//// Q17
	// String with delimited tokens
	public static ArrayList<String> stringTokenizer(){
		String strDOW = ("Mon, Tues, Wed, Thur, Fri, Sat, Sun");
		
		StringTokenizer token = new StringTokenizer(strDOW , ",");
		ArrayList<String> temp = new ArrayList<String>();
		while (token.hasMoreTokens()) {
			//String temp0 = token.nextToken();
			//System.out.println(temp0);
			temp.add(token.nextToken());
		}
		return temp;
		
	}

}
