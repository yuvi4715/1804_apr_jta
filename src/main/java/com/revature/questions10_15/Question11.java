package com.revature.questions10_15;

public class Question11 {

	public static void main(String[] args) {
		try {
			fakeError();
		} catch (Question10 temp) {
			temp.printStackTrace();
		}
		
	}
	
	
	public static void fakeError() throws Question10 {
		throw new Question10();
	}
	

	

}
