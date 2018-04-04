package com.revature.Homework.ProblemThirtyEight;


import java.util.Scanner;

public class Main {
	 public static void main(String[] args) {		
		String hello = "Jerry";
		System.out.println(replaceChar(hello, 'T', 0));
		System.out.println(replaceChar(hello, 'T', 3));
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
