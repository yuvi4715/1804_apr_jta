/**
 * 
 */
package com.revature.assignments.weekone.exceptions;

/**
 * @author Ed M
 * @Creation time 8:55:13 AM
 */
public class FinallyBlock {

	/**
	 * 
	 */
	public FinallyBlock() {
		// TODO Auto-generated constructor stub
	}

	public static void finallyBlock(boolean temp) throws CustomException {
		try {
			if (temp) {
				throw new CustomException();
			}
		} catch (CustomException ce) {
			System.out.println(ce.getMessage());
		} finally {
			System.out.println("Graceful Goodbye Message");
		}
	}

}
