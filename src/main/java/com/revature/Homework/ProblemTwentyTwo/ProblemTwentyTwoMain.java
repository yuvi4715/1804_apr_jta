package com.revature.Homework.ProblemTwentyTwo;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.TreeSet;

public class ProblemTwentyTwoMain {
	public static void main(String[] args) {
		ArrayList<Integer> aList = new ArrayList<Integer>();
		LinkedList<Integer> lList = new LinkedList<Integer>();
		HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
		TreeSet<Integer> treeset = new TreeSet<Integer>();
		HashSet<Integer> hSet = new HashSet<Integer>();
		for(int i=0;i<3;i++) {
			aList.add((int) (Math.random()*10));
			lList.add((int) (Math.random()*10));
			map.put((int) (Math.random()*10), (int) (Math.random()*10));
			treeset.add((int) (Math.random()*10));
			hSet.add((int) (Math.random()*10));
		}
		System.out.println("ArrayList: ");
		for(Integer i:aList) {
			System.out.println(i);
		}
		System.out.println("LinkedList: ");
		for(Integer i:lList) {
			System.out.println(i);
		}
		System.out.println("HashMap: ");
		for(Integer i:map.keySet()) {
			System.out.println(i+" : "+map.get(i));
		}
		System.out.println("TreeSet: ");
		for(Integer i:treeset) {
			System.out.println(i);
		}
		System.out.println("HashSet: ");
		for(Integer i:hSet) {
			System.out.println(i);
		}
	}
}
