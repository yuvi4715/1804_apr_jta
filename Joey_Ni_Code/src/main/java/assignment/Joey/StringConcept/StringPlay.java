package assignment.Joey.StringConcept;

import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import assignment.Joey.Exceptions.Exception1;
import assignment.Joey.fileio.Employee;

/**
1. Create a StringBuilder object. Use at least three methods to manipulate the String.
2. Create a new String with delimited tokens, such as “pickles:ketchup:mustard:onion” and use StringTokenizer to parse out and print each token.
3. Create two String objects with number values (i.e. “20). Write a method that adds the two.
4. Request garbage collection in your method.
5. Create a Runtime object and note at least three methods. Imagine how you would use them.
 * @author joeyi
 *
 */

public class StringPlay {
	//compatible with StringBuffer but not synchronized

	//System.out.println(builder);
	public static void main(String[] args) {
		/**Test 2 for EMployee
		Employee a= new Employee(5, "hello", "world", "VP");
		Employee b= new Employee(6, "helgfg", "worfld", "VgP");
		Employee.getEmployeeMap().put(5, a);
		Employee.getEmployeeMap().put(5, b);
		System.out.println(Employee.getEmployeeMap()); */
		
		StringBuilder str = new StringBuilder("abcdef");
		System.out.println("string = " + str);
		str.append("ghijk");
		System.out.println("string= " +str);
		str.delete(0, 2);
		System.out.println("string= " + str);
		str.insert(1, 888);
		System.out.println("string= " + str);
		String tokenizer = "AppleOrangesGrapesBananasCucumbersCarrotsBellpeppers";
		StringTokenizer token = new StringTokenizer("StringTokenizer is outdated");
		while(token.hasMoreTokens()) {
			System.out.println(token.nextToken(" "));
		}
		String delimiters="(?=[A-Z])";
		for(String t: tokenizer.split(delimiters)) {System.out.println(t);}
		//addStringNums("aekjshf56", "dfjgbfhgfhj44");
		//addStringNums("0sdjfbhvf", "jhfbg00fdhbg");
		addStringNumsOwn("sjdfh56", "sdfs0");
		addStringNumsOwn("heloo4sdhbfh6", "dfjjg6790");
		System.out.println(addNumbersEasy("dsfgdf12", "1fdg1gfh1"));
		Runtime a = Runtime.getRuntime(); //gets the one instance of runtime created by JVM, Runtime allows interaction with running environment
		System.out.println(a.availableProcessors());
		System.out.println(a.freeMemory()); //Interesting to see how free memory changes by gc
		System.gc(); //anonymous objects, nullified objects, and objects created by new keyword a.split(delimiters) can be finalized()
		System.out.println(a.freeMemory()); 
	}
//	3. Create two String objects with number values (i.e. “20). 
		//Write a method that adds the two.
	
	/*public static Integer addStringNums(String a, String b) {
		Integer newA = Integer.parseInt(a);
		Integer newB = Integer.parseInt(b);
		return newA+newB;
	}*/
	
	public static void addStringNumsOwn(String a, String b) {
      /**		String delimiters="(?=\\d)"; //check if for digits
		Pattern r = Pattern.compile(delimiters);
		Matcher m = r.matcher(a);
		Integer newA =null; //int default is 0, want null to check
		Integer newB = null;
		try {
			if(m.find()) {
				System.out.println(m.group(0));
				newA =Integer.parseInt(m.group(0)); 
				//m.group(0) returns a string up to tthe pattern, not just the pattern
			}
			m=r.matcher(b);
			if(m.find()) {
				System.out.println(m.group(0));
				newB =Integer.parseInt(m.group(0));
			}
		
		else {
			throw new Exception1("No numbers found");
		}
		} catch (Exception1 e) {
			e.getMessage();
		} 
		
		if (newA!=null && newB!=null)
		{	System.out.println(newA+newB);
			return newA+newB;
		} return null;
		or \\"[^0-9]+"; */
		
		
	}
	public static int addNumbersEasy(String a, String b) {
		String delimiters = "[\\D]+";
		return (parseInt(a, delimiters) + parseInt(b,delimiters));
	}
	
	public static int parseInt(String a, String delimiters) {
		int sum =0;
		try {
			if ((a.split(delimiters).length) ==1 ) throw new Exception1("No numbers found");
		
		}catch (Exception1 e)
			{ e.getMessage();
			}
		for(String temp: a.split(delimiters))
		{    //split sometimes return "" string
			if (!(temp.isEmpty())) sum += Integer.parseInt(temp);
			System.out.println("print in parseInt:" + temp);
		};
		
		return sum;
	}
}


