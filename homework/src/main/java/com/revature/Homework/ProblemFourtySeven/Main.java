package com.revature.Homework.ProblemFourtySeven;

import java.io.PrintStream;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class Main {
	public static void main(String[] args) {
		test01(System.out);
	}
	public static void test01(PrintStream out) {
		List list = new LinkedList();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		list.add(5);
		list.add(6);
		list.add(7);
		
		int length = 0,middleLocation=0;
		String middle="";
		ListIterator fastPointer=(ListIterator) list.iterator();
		ListIterator slowPointer=(ListIterator) list.iterator();
		while(fastPointer.hasNext()) {
			middle=slowPointer.next().toString();
			fastPointer.next();
			if(fastPointer.hasNext())
				fastPointer.next();
		}
		out.println(middle);
	}
}