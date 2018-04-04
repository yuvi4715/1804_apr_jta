/**
 * 
 */
package com.revature.assignments.weekone.exceptions;

/**
 * @author Ed M
 * @Creation time 8:41:19 AM
 */
public class DuckingExpression {

	/**
	 * 
	 */
	public DuckingExpression() {
		// TODO Auto-generated constructor stub
	}
	
	public static void duckingExpression() throws CustomException{
		System.out.println("Not Handleing A Expression Here and thus the JRE moves down the call stack");
	}

}
