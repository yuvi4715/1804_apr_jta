package com.revature.Homework.ProblemTwentyTwo;


import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.TreeSet;

public class ProblemTwentyTwoMain {
	public static void main(String[] args) {
		test01(System.out);
	}
	public static void test01(PrintStream out)
	{
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
			out.println(i);
		}
		out.println("LinkedList: ");
		for(Integer i:lList) {
			out.println(i);
		}
		out.println("HashMap: ");
		for(Integer i:map.keySet()) {
			out.println(i+" : "+map.get(i));
		}
		out.println("TreeSet: ");
		for(Integer i:treeset) {
			out.println(i);
		}
		out.println("HashSet: ");
		for(Integer i:hSet) {
			out.println(i);
		}
	}
}
