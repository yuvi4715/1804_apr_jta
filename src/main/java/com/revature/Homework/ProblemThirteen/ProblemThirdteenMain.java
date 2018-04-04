package com.revature.Homework.ProblemThirteen;


public class ProblemThirdteenMain {
	
public static void main(String[] args) {
	ProblemThirdteenMain main = new ProblemThirdteenMain();
	try {
		main.throwException();
	}catch (Exception e) {
		e.printStackTrace();
	}
}

public void throwException() throws ProblemThirdteenException {	
	throw new ProblemThirdteenException();
}

}
