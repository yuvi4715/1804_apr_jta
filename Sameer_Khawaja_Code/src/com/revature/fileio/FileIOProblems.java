package com.revature.fileio;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

//problems 24-28

public class FileIOProblems {

	// global
	FileReader fr = null;

	public static void main(String[] args) {
		String fileName = "C:\\Users\\skhaw\\OneDrive\\Revature\\Java\\workspace\\Assignment_week_1\\resources\\Employee info.txt";
		String line;// line of text from file

		Map<String, List<String>> database = new HashMap<>();

		// open txt file
		try {
			FileReader fr = new FileReader(fileName);
			BufferedReader bufferedReader = new BufferedReader(fr);
			while ((line = bufferedReader.readLine()) != null) {// store each line as a string
				List<String> array = new ArrayList<>();
				System.out.println(line);
				// parse through string using tokenizer
				StringTokenizer tokenizer = new StringTokenizer(line, ":");
				while (tokenizer.hasMoreTokens()) {
					// save each delimited part of string in a array
					array.add(tokenizer.nextToken());
				}
				System.out.println(array);
				// hashmap with employee id as the key and the array as the value
				database.put(array.get(0), array);
				System.out.println(database);
			}
			bufferedReader.close(); // Always close files.
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
