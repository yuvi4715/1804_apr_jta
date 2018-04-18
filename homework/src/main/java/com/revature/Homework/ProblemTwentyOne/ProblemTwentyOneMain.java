package com.revature.Homework.ProblemTwentyOne;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.TreeSet;

public class ProblemTwentyOneMain {
	public static void main(String[] args) {
		ArrayList<Integer> aList = new ArrayList<Integer>();
		LinkedList<Integer> lList = new LinkedList<Integer>();
		HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
		TreeSet<Integer> treeset = new TreeSet<Integer>();
		HashSet<Integer> hSet = new HashSet<Integer>();
		for(int i=0;i<3;i++) {
			aList.add(i);
			lList.add(i);
			map.put(i, i);
			treeset.add(i);
			hSet.add(i);
		}
	}
}
