/**
 * 
 */
package com.revature.assignments.weekone.advancedcodingexercises;

/**
 * @author Ed M
 * @date Apr 6, 2018
 * @time time 12:28:39 PM
 */
public class FizzBuzz {

	/**
	 * 
	 */
	public FizzBuzz() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for(int i = 1;i <=50;i++) {
			if (i%3==0 && i%5==0){
				System.out.println("FizzBuzz");	
			}else if (i%3 == 0) {
				System.out.println("Fizz");
			}else if(i%5 == 0) {
				System.out.println("Buzz");
			}
		System.out.println(i);
		}
	}

}
