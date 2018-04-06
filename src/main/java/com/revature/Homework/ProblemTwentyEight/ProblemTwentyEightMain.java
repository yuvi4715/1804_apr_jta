package com.revature.Homework.ProblemTwentyEight;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.StringTokenizer;

public class ProblemTwentyEightMain {
	
	public static void main(String[] args) throws IOException {
		test01(System.out);
	}
	
	public static void test01(PrintStream out ) throws NumberFormatException, IOException {
		BufferedReader inputStream=null;
		HashMap<Long,String> empMap = new HashMap<Long,String>();
		try {
			File file = new File("src/main/java/com/revature/Homework/ProblemTwentyEight/Example.dat");
			inputStream = new BufferedReader(new FileReader(file));
			String l;
			while((l=inputStream.readLine())!=null) {
				StringTokenizer t = new StringTokenizer(l, ":");
				String first = t.nextToken().replaceAll("Employee ", "");
				long id = Long.parseLong(first);
				String fName = t.nextToken();
				empMap.put(id, fName);
			}
		} finally {
			if(inputStream!=null)
				inputStream.close();
		}
		for(Long e:empMap.keySet()) {			
			out.println(e+" : "+empMap.get(e));
		}
	}
	
}
