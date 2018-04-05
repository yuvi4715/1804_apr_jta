package com.revature.syntax;

public class Question5 {
	
	public static void main(String[] args) {
		
		Operation Add;
		Add = new Operation();
		
		Operation Sub;
		Sub = new Operation();
		
		Operation Mul;
		Mul = new Operation();
		
		Operation Div;
		Div = new Operation();
		
		int add = Add.add(5, 5);
		System.out.println("5 + 5 = " + add);
		int sub = Sub.sub(5, 5);
		System.out.println("5 - 5 = " + sub);
		int mul = Mul.mul(5, 5);
		System.out.println("5 * 5 = " + mul);
		int div = Div.div(5, 5);
		System.out.println("5 / 5 = " + div);
		
	}
	
	
}

class Operation {
	
	int add( int a, int b) {
		int returnAdd;
		returnAdd = a + b ;
		return returnAdd;
		
	}
	
	int sub( int a, int b) {
		int returnSub;
		returnSub = a - b ;
		return returnSub;
		
	}
	
	int mul( int a, int b) {
		int returnMul;
		returnMul = a * b ;
		return returnMul;
		
	}
	
	int div( int a, int b) {
		int returnDiv;
		returnDiv = a / b ;
		return returnDiv;
		
	}
}
