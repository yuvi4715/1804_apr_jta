package com.revature.exception;

public class MyException extends Exception {
	
	
	private static final long serialVersionUID = -4435904792252875153L;

	public void ArrayFile() {
			try {
				int [] i = {1,2,3};
				System.out.println(i[3]);
			}
			catch (ArrayIndexOutOfBoundsException e) {
				System.out.println(e.getMessage());
				//e.printStackTrace();
				//e.getMessage();
				
			}
	}
	
	public String getMessage() {
		return "Array index exception";
		
	}
	
	public static void main(String[] args) {
		
		
		 MyException exp = new MyException();
		 exp.ArrayFile();
		

	}

}
