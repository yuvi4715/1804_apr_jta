/**
 * 
 */
package com.revature.assignments.weekone.advancedconcepts;

/**
 * @author Ed M
 * @date Apr 4, 2018
 * @time time 10:41:03 AM
 */
public class Runtime_ {

	/**
	 * 
	 */
	public Runtime_() {
		// TODO Auto-generated constructor stub
	}
	/// Q20
	// Runtime Use 3 times
	public static void runtime() {
		Runtime temp = Runtime.getRuntime();
		int numpro = temp.availableProcessors();
		long avaMem = temp.freeMemory();
		long totMem = temp.totalMemory();
		System.out.println("Number of available Processors: " + numpro);
		System.out.println("Free Memory: "+ avaMem + " \\ "+ totMem + " :Total Memory");
		
	}

}
