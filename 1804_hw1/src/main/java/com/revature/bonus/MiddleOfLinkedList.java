package com.revature.bonus;

import java.util.Iterator;
import java.util.LinkedList;

// Solution to hw1 bonus problem #47

public class MiddleOfLinkedList {

	public static String findMiddle(LinkedList<String> list) {
		
		String currStr = "";
		int size = list.size();
		Iterator<String> iter = list.iterator();
		
		for (int i = 0; i < ((size/2)+1); i++) {
			currStr = iter.next();
		}
		
		return currStr;
	}
	
	public static void main(String[] args) {
		
		LinkedList<String> list = new LinkedList<>();
		list.add("test");
		list.add("test");
		list.add("test");
		list.add("test");
		list.add("MIDDLE");
		list.add("test");
		list.add("test");
		list.add("test");
		list.add("test");
		
		System.out.println("Middle of list: " + findMiddle(list));
	}
}
