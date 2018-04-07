/*
 *  Author: Michael Sikorski
 *  Date: 4/6/18
 */

package advanced_coding_exercises;

import java.math.BigInteger;

public class Question40 {
	
	public BigInteger[] sequence;
	public BigInteger[] recursiveSolutions;
	
	public Question40(int size) {
		sequence = new BigInteger[size];
		recursiveSolutions = new BigInteger[size];
	}

	public String fibonacciIterative(int size) {
		sequence[0] = new BigInteger("1");
		sequence[1] = new BigInteger("1");
		String fibonnaci = "1 1 ";
		for (int i=2; i<100; i++) {
			sequence[i] = sequence[i-2].add(sequence[i-1]);
			fibonnaci += String.valueOf(sequence[i]) + " ";
		}
		return fibonnaci;
	}
	
	public String fibRecHelper(int size) {
		String sequence = "";
		for (int i=0; i<size; i++) {
			sequence += fibonnaciRecursive(i) + " ";
		}
		return sequence;
	}
	
	public BigInteger fibonnaciRecursive(int size) {
		if (size == 0 || size == 1) {
			recursiveSolutions[size] = new BigInteger("1");
			return new BigInteger("1");
		}
		else {
			BigInteger b = recursiveSolutions[size-2].add(recursiveSolutions[size-1]);
			recursiveSolutions[size] = b;
			return b;
		} 
	}
}
