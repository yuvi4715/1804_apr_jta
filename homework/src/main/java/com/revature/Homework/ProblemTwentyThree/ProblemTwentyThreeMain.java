package com.revature.Homework.ProblemTwentyThree;


import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.TreeSet;

public class ProblemTwentyThreeMain {
	public static final short MAX_RANDOM_VALUE = 100;
	public static final short ELEMENTS_IN_ARRAY = 4;
	
	public static void main(String[] args) {
		ArrayList<Integer> aList = new ArrayList<Integer>();
		LinkedList<Integer> lList = new LinkedList<Integer>();
		HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
		TreeSet<Integer> treeset = new TreeSet<Integer>();
		HashSet<Integer> hSet = new HashSet<Integer>();
		for(int i=0;i<ELEMENTS_IN_ARRAY;i++) {
			aList.add((int) (Math.random()*MAX_RANDOM_VALUE));
			lList.add((int) (Math.random()*MAX_RANDOM_VALUE));
			map.put((int) (Math.random()*MAX_RANDOM_VALUE), (int) (Math.random()*MAX_RANDOM_VALUE));
			treeset.add((int) (Math.random()*MAX_RANDOM_VALUE));
			hSet.add((int) (Math.random()*MAX_RANDOM_VALUE));
		}
		System.out.println("ArrayList: ");
		for(Integer i:aList) {
			System.out.println(i);
		}
		System.out.println("** Sorted ***");
		List<Integer> tempList=(List<Integer>) aList.clone();
		Collections.sort(tempList);
		for(Integer i:tempList) {
			System.out.println(i);
		}
		System.out.println("LinkedList: ");
		for(Integer i:lList) {
			System.out.println(i);
		}
		System.out.println("** Sorted ***");
		tempList=(List<Integer>) lList.clone();
		Collections.sort(tempList);
		for(Integer i:tempList) {
			System.out.println(i);
		}
		System.out.println("HashMap: ");
		for(Integer i:map.keySet()) {
			System.out.println(i+" : "+map.get(i));
		}
		List<Integer> hmKeyList = new ArrayList<Integer>(map.keySet());
		List<Integer> hmValList = new ArrayList<Integer>(map.values());
		Collections.sort(hmKeyList);
		Collections.sort(hmValList);
		System.out.println("** Sorted Keys ***");
		for(Integer i: hmKeyList) {
			System.out.println(i);
		}
		System.out.println("** Sorted values***");
		for(Integer i: hmValList) {
			System.out.println(i);
		}
		System.out.println("TreeSet: ");
		for(Integer i:treeset) {
			System.out.println(i);
		}
		List<Integer> treeSetList = new ArrayList<Integer>(treeset);
		Collections.sort(treeSetList);
		System.out.println("** Sorted ***");
		for(Integer i:treeSetList) {
			System.out.println(i);
		}
		System.out.println("HashSet: ");
		for(Integer i:hSet) {
			System.out.println(i);
		}
		List<Integer> hsList = new ArrayList<Integer>(hSet);
		Collections.sort(hsList);
		System.out.println("** Sorted ***");
		for(Integer i:hsList) {
			System.out.println(i);
		}
		
	}
}
