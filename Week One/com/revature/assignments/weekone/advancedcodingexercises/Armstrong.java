/**
 * 
 */
package com.revature.assignments.weekone.advancedcodingexercises;

/**
 * @author Ed M
 * @date Apr 6, 2018
 * @time time 1:06:58 PM
 */

//Armstrong Number in Java: A positive number is called armstrong number 
//if it is equal to the sum of cubes of its digits for example 0, 1, 153, 370, 371, 407...
public class Armstrong {

	/**
	 * 
	 */
	public Armstrong() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static boolean isArmStrong(int x) {
		    int a = 0;
		    int c = 0;
		    int temp = x;  
		    while(x > 0){  
		    a=x%10;  //Each Didgit
		    x=x/10;  //
		    c=c+(a*a*a);  
		    }  
		    if(temp == c)  
		    	return true;
		    else  
		        return false;
		
	}
	public static void main(String[] args) {
		System.out.println(isArmStrong(15)); //True 
		//System.out.println(isArmStrong(152)); //False

	}

}
