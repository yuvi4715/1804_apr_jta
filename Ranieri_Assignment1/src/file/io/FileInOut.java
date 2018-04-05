package file.io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

public class FileInOut {

	public static void main(String[] args) throws IOException {

		
		HashMap<String, Employee> companyHM = new HashMap<>();
		String myLine = null;		
		File file = new File("C:\\Users\\Adam Ranieri\\Desktop\\employees.txt");
		Scanner input = new Scanner(file);
		
		
		
		List<String> list = new ArrayList<String>();
		while (input.hasNextLine()) {
		    list.add(input.nextLine());
		}
		
		
	
		
		for (int i = 0; i < list.size(); i++)	{
		myLine = list.get(i);
		StringTokenizer t = new StringTokenizer(myLine, ":");		
		String id = (t.nextToken());
		String firstName = (t.nextToken());
		String lastName = (t.nextToken());
		String role = (t.nextToken());	
		companyHM.put(id,new Employee(id,firstName,lastName,role) );
		}
			
//		System.out.println(id);
//		System.out.println(companyHM.get("124"));	

	}
	

}
