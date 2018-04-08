package com.advancedcode.work;

public class FizzBuzz {

	public static void main(String[] args) {
		
		boolean flag1 = false, flag2 = false;
		
		for(int i =1; i <51;i++) {
			
			if((i%3) == 0)
				flag1 = true;
			
			if ((i%5) == 0)
				flag2 = true;
			
			if(flag1 && flag2) {
				System.out.println("FizzBuzz");
			}
			else if(flag1)
				System.out.println("Fizz");
			else if(flag2)
				System.out.println("Buzz");
			else System.out.println(i);
			
			flag1 =false;
			flag2 = false;
		}
	}

}
