package com.revature.exceptions;

public class TestException {

	public static void main(String[] args) {
		try {
			new TestException().usingArrays();
		} catch (MyException e) {
			//e.printStackTrace();
			System.out.println("something is wrong, please check back later");
		}
	}
	
	void usingArrays() throws MyException{
		String s2 = null;
		
		if (s2 == null) {
			throw new MyException();
		}
	}

}
