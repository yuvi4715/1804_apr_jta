package com.revature.projrctzero;
import java.util.StringTokenizer;  

public class Question16To20MyStrings {

private String question;


public Question16To20MyStrings(String question) {
		this.question = question;
	}

public String toString () {
	return question;

}

//	Create a StringBuilder object. Use at least three methods to manipulate the String.
//	Create a new String with delimited tokens, such as “pickles:ketchup:mustard:onion” and use StringTokenizer to parse out and print each token.
//	Create two String objects with number values (i.e. “20). Write a method that adds the two.
//	Request garbage collection in your method.
//	Create a Runtime object and note at least three methods. Imagine how you would use them.	

	// Question16: String builder example
	//string buffer is mutable, it checks for thread safe(synchonized), uses servents called threads which may collide in carrying out a function
	
	
	public static void main(String args[]) throws CloneNotSupportedException, InterruptedException {
	
	StringBuilder sb=new StringBuilder("Hello"); // Create a new string
	sb.append("World"); // Append string to sb
	System.out.println(sb);
	sb.replace(0,5,"Hi"); // Replace first five characters with Hi
	System.out.println(sb);
	sb.reverse();  
	System.out.println(sb);//prints reversed string
	
	
	// Question 17: Create a new String with delimited tokens, such as “pickles:ketchup:mustard:onion” and
	//use StringTokenizer to parse out and print each token.
	
	StringTokenizer st = new StringTokenizer("pickles:ketchup:mustard:onion",":");  
	while (st.hasMoreTokens()) {  
	System.out.println(st.nextToken()); 
	}
	
	
	// Question18: Create two String objects with number values and add them
	
	String num1 = "20", num2 = "30";
	String a = (num1+=num2);
	System.out.println(a);
	
	//System.out.println("Addition of two numbers: " + (Integer.parseInt(num1) +Integer.parseInt(num2) ));
	
	//Question19: Request garbage collection in your method.
	
	//prevents allocation of memory space for objects that are not in use
	//system process cleans up memory when it is no longer refenced.
	//objects are created insiide heap memory
	//System.gc() or make = null?
	
		
	Question16To20MyStrings q1 = new Question16To20MyStrings("spring");
	Question16To20MyStrings q2 = new Question16To20MyStrings("springbuffer");
	Question16To20MyStrings q3 = new Question16To20MyStrings("springbuilder");
	q2 = new Question16To20MyStrings("MySpring");
	
	System.out.println(q1);
	System.out.println(q2);
	System.out.println(q3);
	
	//System.gc();	// this should actually be at the end of the code. No physical output is generated on the console.
					// i wrote lines 64 - 71 to show that GC will take care of the objects no longer in use such as q2.
	
//Question20:	Create a Runtime object and note at least three methods. Imagine how you would use them.
	
	
	q1.clone();		//Creates and returns a copy of this object. 
	q1.notify();	//Wakes up a single thread that is waiting on this object's monitor.
	q3.wait();		//Causes the current thread to wait until another thread invokes the notify() method or the notifyAll() method for this object.
	
	
	System.gc();
	}  
	
	
}


	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

