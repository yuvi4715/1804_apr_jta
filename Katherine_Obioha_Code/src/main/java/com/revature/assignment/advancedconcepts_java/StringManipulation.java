package advancedconcepts_java;

import java.util.StringTokenizer;
/**
 * 
 * @author katherine Obioha
 * 
 * Create a string builder and use at least three methods to manipulate the string. Use String Tokenizer
 * to parse strings. Add two string together.
 * Create a runtime objects and lastly request garbage collection in your method
 *
 */
public class StringManipulation {
	
	
 public static void main(String[]args) throws Throwable
 {	
	 manipulate();
	 tokenizer();
	 addString();
	 
	 StringManipulation manipulating = new StringManipulation();
	 manipulating.clone();
	 manipulating.finalize();
	 manipulating.hashCode();
	 
	 System.gc();
	 
 }
 
 static void addString() {
	// TODO Auto-generated method stub
	String one = "Katherine";
	String two = "Obioha";
	String three = one.concat(two);
	
}

static void manipulate()
 {
	 String n = "Manipulate me";
		StringBuilder s = new StringBuilder("Original");
		
		s.append("+");
		
		for(int i=0; i<n.length(); i++)
		{	
			s.append(n.charAt(i));	
		}
		 
		 System.out.println(s.toString());
		 s.reverse();
		 System.out.println(s);
		 s.reverse();
		 s.replace(8, s.length(), "Add");
		 System.out.println(s);
 }
 
 static void tokenizer()
 {
			String str = "Katherine: You: Me";
			StringTokenizer tokenizer = new StringTokenizer(str, ":");
			while (tokenizer.hasMoreTokens())
			{
				System.out.println(tokenizer.nextToken());
			}
			
		
 }
 
 
}
