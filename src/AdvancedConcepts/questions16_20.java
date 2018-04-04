package AdvancedConcepts;

import java.util.StringTokenizer;

public class questions16_20 {
	
	public static void main(String[] args) {
		
		
		//16
		//question16();
		
		//17
		//question17();
		
		//18-19
		//question18();
		
		//20
		//question20();
		
		
		
		
		
		
		
	}
	
	public static void question16() {
StringBuilder s = new StringBuilder("hello");
		
		System.out.println(s);
		
		// dont know why you would do this
		s.append(true);		
		System.out.println(s);
		
		s.deleteCharAt(5);
		System.out.println(s);
		
		s.reverse();
		System.out.println(s);
		
		
	}
	
	public static void question17() {
		String s = "Float!Like!A!Butterfly";
		StringTokenizer t = new StringTokenizer(s, "!");
		while(t.hasMoreTokens()) {
			System.out.println(t.nextToken());
		}
	}
	
	

	public static void question18() {
		String numb1 = "10";
		String numb2 = "20";
		
		int number1 = Integer.parseInt(numb1);
		int number2 = Integer.parseInt(numb2);
		
		System.out.println((number1+number2));
		System.gc();
		
	}
	
	public static void question20() {
		 Runtime run = Runtime.getRuntime();
		 // If you are running on a servers or msuper computer with many process you can estimate how much
		 // processing power you are working with and what calculations 
		 System.out.println(run.availableProcessors());
		 
		 // Depending on how much memory is available seee if your program can actually run
		 System.out.println(run.maxMemory());
		 
		 // execute commands from java is great way to get access to powerful system commands or open programs
		 //System.out.println(run.exec("time"));
		
	}

}
