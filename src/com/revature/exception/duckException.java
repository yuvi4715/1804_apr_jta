package com.revature.exception;

public class duckException {

	
	public void arrayException() {
		
		int [] i = {1,2,3,4,5,6};
		System.out.println(i[10]);
		
		
	}
	
	public void ArithmeticExce() {
		try{
			int a = 2/0;
		}catch(ArithmeticException ae) {
			System.out.println(ae.getMessage());
		}
		
	}
	
	public static void main(String[] args) throws ArrayIndexOutOfBoundsException {

		new duckException().ArithmeticExce();
		new duckException().arrayException();

	}


}
