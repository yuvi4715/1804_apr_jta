package com.revature.questions10_15;

public class Question15 {

	public static void main(String[] args) {

		try {

			System.out.println("No Error Yet.");
			Question11.fakeError();
			System.out.println("1st in Try");

		} catch (Question10 temp) {
			System.out.println("2nd in Catch");
			System.exit(0); //exit forces finally to not run. Very little grace compared to Question 14.
		} catch (Exception temp) {
			System.out.println("3rd in Catch");
		} finally {
			System.out.println("======================");
			System.out.println("Question 12 with a graceful ending");
			System.out.println("======================");
		}

		// the ones that shouldn't print, don't.
	}

}


