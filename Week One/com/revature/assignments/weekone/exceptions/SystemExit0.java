package com.revature.assignments.weekone.exceptions;

public class SystemExit0 {

	public SystemExit0() {
		// TODO Auto-generated constructor stub
	}

	public static void systemExit0(boolean temp) throws CustomException {
		try {
			if (temp) {

				throw new CustomException();
			}
		} catch (CustomException ce) {
			System.out.println(ce.getMessage());
			//System.exit(0);
		} finally {
			System.exit(0);
			System.out.println("Graceful Goodbye Message");
			
		}
	}

	public static void main(String[] args) throws CustomException {
		System.out.println("Start exit 0 Test");
		systemExit0(false);
	}

}
