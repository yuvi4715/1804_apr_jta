/**
 * 
 */
package com.revature.assignments.weekone.exceptions;

/**
 * @author Ed M
 * @Creation time 9:45:10 PM
 */
public class ManualThrow {

	/**
	 * 
	 */
	public ManualThrow() {
		// TODO Auto-generated constructor stub
	}

	public String test(boolean temp) throws CustomException {
		if (temp) {
			throw new CustomException();
		} else
			return null;
	}
	

}
