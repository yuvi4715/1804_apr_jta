package com.revature.questions10_15;

public class Question13 {

	public static void main(String[] args) {

		try {
			ducking();
		} catch (Question10 hopeitducks) {
			System.out.println("Did it catch");
			System.out.println(hopeitducks.getMessage());
		}

	}

	public static void ducking() throws Question10 {
		Question11.fakeError();
	}

}
