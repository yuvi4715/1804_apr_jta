package com.revature.Homework.ProblemTwentySix;



import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class ProblemTwentySixMain {
	
	public static void main(String[] args) throws IOException {
		BufferedReader inputStream=null;
		List<Employee> empList = new ArrayList<Employee>();
		try {
			File file = new File("src/main/java/com/revature/Homework/ProblemTwentySix/Example.dat");
			inputStream = new BufferedReader(new FileReader(file));
			String l;
			while((l=inputStream.readLine())!=null) {
				StringTokenizer t = new StringTokenizer(l, ":");
				String first = t.nextToken().replaceAll("Employee ", "");
				long id = Long.parseLong(first);
				String fName = t.nextToken();
				String lName = t.nextToken();
				String role = t.nextToken();
				empList.add(new Employee(fName, lName, role, id));
			}
		} finally {
			if(inputStream!=null)
				inputStream.close();
		}
		for(Employee e:empList)
			System.out.println(e);
	}
	
}

