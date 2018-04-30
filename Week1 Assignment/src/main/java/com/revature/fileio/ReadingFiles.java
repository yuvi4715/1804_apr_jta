package com.revature.fileio;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.StringTokenizer;

public class ReadingFiles {

	public static void main(String[] args) throws IOException {

		String fileName = "C:\\revature\\1804_apr_java\\src\\main\\java\\com\\revature\\fileio\\Bob";
		String employeeData;
		Scanner textFile;
		String employeeID;
		String fName;
		String lName;
		String role;
		HashMap<String, Employee> CuongInc = new HashMap<String, Employee>();

		textFile = new Scanner(new File(fileName));
		do {
			employeeData = textFile.nextLine();
			StringTokenizer delimitedTokens = new StringTokenizer(employeeData, ":");
			while (delimitedTokens.hasMoreTokens()) {
				employeeID = delimitedTokens.nextToken();
				fName = delimitedTokens.nextToken();
				lName = delimitedTokens.nextToken();
				role = delimitedTokens.nextToken();
				CuongInc.put(employeeID, new Employee(fName,lName,role));
			}
			

		} while (textFile.hasNext());
		ReadingFiles.iterateMap(CuongInc);
		textFile.close();
	}
	
	public static void iterateMap(Map locations) {
		Iterator read = locations.entrySet().iterator();
		while (read.hasNext()) {
			Map.Entry pair = (Map.Entry) read.next();
			System.out.println(pair.getKey() + " = " + pair.getValue());
		}
	}
}


