package com.revature.syntax;


public class Question4 {
	
	int add(int a,int b) {
		return a+b;
	}
	int sub(int a, int b) {
		return a-b;
	}
	int mul(int a, int b) {
		return a*b;
	}
	int div(int a, int b) {
		return a/b;
	}
	
public static void main(String[] args) {
		
		Question4 obj = new Question4();
		
		int add = obj.add(5, 5);
		int sub = obj.sub(20, 10);
		int mul = obj.mul(2, 5);
		int div = obj.div(100, 10);
		
		System.out.println("Addition of 5 + 5 = " + add);
		System.out.println("Addition of 20 + 10 = " + sub);
		System.out.println("Addition of 2 * 5 = " + mul);
		System.out.println("Addition of 100 / 10 = " + div);
	}

}
