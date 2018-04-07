package com.revature.questions10_15;

public class Question12 {
	
	public static void main(String[] args) {

		try {
			
			System.out.println("No Error Yet.");
			Question11.fakeError();
			System.out.println("1st in Try");
			
		}catch (Question10 temp){
			System.out.println("2nd in Catch");
		}catch (Exception temp){
			System.out.println("3rd in Catch");
		}finally {
			System.out.println("4th in Finally");
		}
		
		//the ones that shouldn't print, don't.
	}
	
}