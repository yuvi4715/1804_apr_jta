package com.revature.projrctzero;

public class Question38CharReplacement {

	//Write a method to replace a given character in a String with another character.


	public static void main(String a[]){

	String str = "This is an example string";
	System.out.println("Replace char 's' with 'o':"
	+str.replace('s', 'o'));

	System.out.println("Replace first occurance of string\"is\" with \"ui\":"
	+str.replaceFirst("is", "ui"));

	System.out.println("Replacing \"is\" every where with \"no\":"
	+str.replaceAll("is", "no"));
	}
	}
	