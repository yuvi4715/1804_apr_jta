/**
 * 
 */
package com.revature.assignments.weekone.collections;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.TreeSet;
import static java.lang.System.out;;
/**
 * @author Ed M
 * @date Apr 4, 2018
 * @time time 11:03:43 AM
 */
public class CollectionCreation {

	
	private ArrayList<String> alist = new ArrayList<String>();
	private LinkedList<String> llist = new LinkedList<String>();
	private HashMap<Integer,String> hmap = new HashMap<Integer,String>();
	private TreeSet<String> tset = new TreeSet<String>();
	private HashSet<String> hset = new HashSet<String>();
	
	public CollectionCreation() {
		for(int i = 1; i<=3;i++) {
			String sobj = ("String Object #" + i);
			alist.add("ArrayList: " + sobj);
			llist.add("LinkList: " + sobj);
			hmap.put(000,("Hashmap: " + sobj));
			tset.add("TreeSet:" + sobj);
			hset.add("HashSet:" + sobj);
		}
		
	}

	public ArrayList<String> getAlist() {
		return alist;
	}

	public LinkedList<String> getLlist() {
		return llist;
	}

	public HashMap<Integer, String> getHmap() {
		return hmap;
	}

	public TreeSet<String> getTset() {
		return tset;
	}

	public HashSet<String> getHset() {
		return hset;
	}


}
