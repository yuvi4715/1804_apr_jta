package com.revature.Homework.ProblemFiftySix;

public class Main {
	public static void main(String[] args) {
		String[] a= {"anna","car"};
		boolean[] isPalindrome = new boolean[a.length];
		for(int i=0;i<a.length;i++) {
			String s = a[i];
			isPalindrome[i] = true;
			for(int j=0;j<a.length/2;j++) {
				if(s.charAt(j)!=s.charAt(s.length()-1-i)){
					isPalindrome[i] = false;
					break;
				}
			}
		}
		
		for(int i=0;i<a.length;i++) {
			String s = a[i];
			System.out.println(s+(isPalindrome[i]?" is":" isn't")+" palindrome");
		}		
	}
}
