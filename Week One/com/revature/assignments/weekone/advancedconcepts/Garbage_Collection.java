/**
 * 
 */
package com.revature.assignments.weekone.advancedconcepts;

/**
 * @author Ed M
 * @date Apr 4, 2018
 * @time time 10:08:55 AM
 */
public class Garbage_Collection {

	/**
	 * 
	 */
	/// 
	public Garbage_Collection() {
		// TODO Auto-generated constructor stub
	}
	
	////Q19
	public static void garbageCollection() {
		System.gc();
		Runtime temp = Runtime.getRuntime();
		temp.gc();
	}
}
