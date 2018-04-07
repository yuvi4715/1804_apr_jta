package com.revature.exception;

public class TestException {
	
	public static void main(String[] args) throws MyException {
		
		try {
			new TestException().usingArrays();
		} catch (MyException e) {
			//e.printStackTrace();
			System.out.println("wrong"); //better for user interface
		}
	}
	//if not caught by main program, exception goes to JVM, extra work
	void usingArrays() throws MyException{
	/**	int a[]=new int[5];
		a[10]=50;
		does not work because throw is not used*/
		
		String s2=null;
		if (s2==null) {
			throw new MyException();
			
		}
	}

}
