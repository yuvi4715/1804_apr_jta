package com.revature.exception;

public class MyException extends Exception {
	
	
	private static final long serialVersionUID = -4435904792252875153L;

	
	
	public String getMessage() {
		return "Array index exception";
		
	}
	
	public static void main(String[] args) {
		
		try {
			//System.out.println(getMessage());
			
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		

	}

}
