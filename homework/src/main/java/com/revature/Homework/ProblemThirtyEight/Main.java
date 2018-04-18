package com.revature.Homework.ProblemThirtyEight;


import java.io.PrintStream;

public class Main {
	 public static void main(String[] args) {		
		test01(System.out);
	 }
	 public static void test01(PrintStream out) {
		String hello = "Jerry";
		out.println(replaceChar(hello, 'T', 0));
		out.println(replaceChar(hello, 'T', 3));
	 }
	 public static String replaceChar(String s,char c,int location) {
		 if(location>(s.length()-1))
			 return null;
		 String result = s.substring(0,location);
		 result+=c;
		 result+=s.substring(location+1);
		 return result;
	 }
}
