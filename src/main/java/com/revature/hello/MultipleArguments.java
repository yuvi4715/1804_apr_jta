package com.revature.hello;

public class MultipleArguments {

	public static void main(String[] args) {  //I can create this by typing main (control+space)
		MultipleArguments m1 = new MultipleArguments();
		m1.display(10, 11, 12, 13, 14, 15);
		m1.display(21, 22, 23); //With varargs you're not set in how many parameters like arrays. 
		
		print(20,21,22,23,24); //this is calling the static method. Does not need to be created.
	}
	
	static void print(int x, int...y) {   //Static method
		for (int i:y) {
			System.out.println(i);
		}
	}
	
	void display(int...x) {   //This is varargs. It means it can take multiple arguments. This HAS to 
		for (int i: x) {	  // be the last parameter or the only one.  
			System.out.println(i);
		}
		
	}
	
	//Single line comment
	
	/*
	 * multi-line comment
	 */
	
	/**
	 * JAVA DOC
	 */
	
}



