package com.syntax.work;

public class assignment_6 {
	
	public static void main(String[] args) {
		
		int whileCount=1;
		int doWhileCount = 0;
		int status = -1;
		int returned;
		String str = "123";
		int string;
		
		try {
			string = Integer.parseInt(str);
			System.out.println(string);
		}
		catch(NumberFormatException e) {
			e.printStackTrace();
		} 
		
			for(int i = 0; i < 10; i++)
			{
				if(i == 5) {
					System.out.println("If statement has run because i is 5");
				}
				else
					System.out.println("The for has run " + i + " times by now.");
			}
		
		while(whileCount != 5) {
				System.out.println(whileCount++ + " is the value of whileCount");
			}
		
		do {
			if(doWhileCount == 2) { 
				doWhileCount++;
				continue;}
				System.out.println(doWhileCount + " is the value of doWhileCount");
				doWhileCount++;
			}while(doWhileCount != 5);
		
		switch(status) {
			case 1:
				System.out.println("The value is 1.");
				break;
			case 2:
				System.out.println("The value is 2.");
				break;
			case 3:
				System.out.println("The value is 3.");
				break;
			default:
				System.out.println("The value is " + status);
			}
		status = 2;
		
		switch(status) {
			case 1:
				System.out.println("The value is 1.");
				break;
			case 2:
				System.out.println("The value is 2.");
				break;
			case 3:
				System.out.println("The value is 3.");
				break;
			default:
				System.out.println("The value is " + status);
			}
		
		returned = returnFun();
		System.out.println(returned + " is the number returned by the method 'returnFun'");
		} //main ends here
	
		public static int returnFun() {
			int x = 5;
			return x;
		}
}
