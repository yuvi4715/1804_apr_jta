package com.revature.Homework.ProblemFiftyFive;

import java.io.PrintStream;

public class Main {
	public static void main(String[] args) {
		test01(System.out);
	}
	public static void test01(PrintStream out) {
		int a=5;
		StringBuilder sb = new StringBuilder();
		byte aByte = (byte) (a);
		out.println(aByte+" "+String.format("%8s", Integer.toBinaryString(aByte & 0xFF)).replace(' ', '0'));
		aByte = (byte) (aByte << 7);
		out.println(aByte+" "+String.format("%8s", Integer.toBinaryString(aByte & 0xFF)).replace(' ', '0'));
		if(aByte==-128)
			out.println("Odd");
		else
			out.print("Even");
	}
}
