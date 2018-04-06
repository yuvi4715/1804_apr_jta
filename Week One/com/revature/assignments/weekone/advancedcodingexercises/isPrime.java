/**
 * 
 */
package com.revature.assignments.weekone.advancedcodingexercises;

import java.util.stream.IntStream;

/**
 * @author Ed M
 * @date Apr 6, 2018
 * @time time 1:29:07 PM
 */
///Q45
public class isPrime {

	/**
	 * 
	 */
	public isPrime() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static boolean isPrime(int x) {
		if(x == 2 )return true;
		 if (x % 2 == 0) return false;
		    //if not, then just check the odds
		    for(int i = 3 ; i * i <= x ; i +=2) {
		        if(x % i==0)
		            return false;
		    }
		    return true;
		
		
		
		//return IntStream.rangeClosed(2, (int) (Math.sqrt(x))).filter(n -> (n & 0X1) != 0).allMatch(n -> x % n != 0);
			}
	
	public static void main(String[] args) {
		//System.out.println(isPrime(1));
		System.out.println(isPrime(2));
		System.out.println(isPrime(3));
		System.out.println(isPrime(4));
		System.out.println(isPrime(5));
		System.out.println(isPrime(6));
		System.out.println(isPrime(59));
		System.out.println(isPrime(58));
		

	}

}
