package com.syntax.work;

public class assignment_4 {

	assignment_4(){
		
		int a = 4;
		int b = 3;
		
		this.getSum(a,b);
		this.getSub(a,b);
		this.getMult(a,b);
		this.getDiv(a,b);
	}
	private void getSub(int a, int b) {
		System.out.println(a + " - " + b + " = " + (a-b));
		
	}
	private void getDiv(int a, int b) {
		System.out.println(a + " / " + b + " = " + (a/b));
		
	}
	private void getMult(int a, int b) {
		System.out.println(a + " * " + b + " = " + (a*b));
		
	}
	private void getSum(int a, int b) {
		System.out.println(a + " + " + b + " = " + (a+b));
		
	}
	public static void main(String[] args) {
		new assignment_4();
	}
}
