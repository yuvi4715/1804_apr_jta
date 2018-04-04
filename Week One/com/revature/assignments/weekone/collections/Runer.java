/**
 * 
 */
package com.revature.assignments.weekone.collections;

/**
 * @author Ed M
 * @date Apr 4, 2018
 * @time time 12:52:52 PM
 */
public class Runer {

	/**
	 * 
	 */
	public Runer() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CollectionIteration test = new CollectionIteration();
		test.iterateArrayList();
		test.iterateLinkedList();
		test.iterateHashMap();
		test.iterateTreeSet();
		test.iterateHashSet();
		System.out.println("------------Sorted Collections------------");
		CollectionSort sorttest = new CollectionSort(test);
		sorttest.sortArrayList();
		sorttest.sortLinkedList();
		sorttest.sortHashMap();
	}

}
