package com.revature.hello;

public class MultipleArguments {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		display(10,11,12,15,9);
		print(20,3,4,1,3,4);
		
	}
	
	static void print(int x, int...y)
	{
		for(int i: y)
		{
			System.out.println(i);
		}
	}
	
	static void display(int...x)
	{
		for(int i: x)
		{
			System.out.println(i);
		}
	}

}
