package com.revature.Homework.ProblemThirteen;

import java.io.PrintStream;

public class ProblemThirdteenMain {
	
public static void main(String[] args) {
	test01(System.out);
}
public static void test01(PrintStream out){
	ProblemThirdteenMain main = new ProblemThirdteenMain();
	try {
		main.throwException();
	}catch (Exception e) {
		out.println(e.getMessage());
	}
}
public void throwException() throws ProblemThirdteenException {	
	throw new ProblemThirdteenException();
}

}
