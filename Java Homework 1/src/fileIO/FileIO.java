package fileIO;
//Problem 24 -  A file called "person.txt" is created created with the string
//problem 25 -  read 24
//problem 26 - file is read and parsed.  Even printed out for confirmation

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.StringTokenizer;

public class FileIO {
	
	FileReader fr = null;
	FileWriter fw = null;
	StringBuilder sb = new StringBuilder();
	BufferedReader r;
	StringTokenizer st;

	
	public FileIO() {
		try {
			readFile();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	void readFile() throws IOException {
		r = new BufferedReader(new FileReader("C:\\Users\\Michael  Harty\\Documents\\workspace-sts-3.9.3.RELEASE\\Java Homework 1\\src\\fileIO\\person.txt"));
		String line = r.readLine();
		
		while (line != null) {
			sb.append(line);
			sb.append(" \n");
			line = r.readLine();
		}
		 r.close();
			
	}
	
	
	public static void main(String[] args) {
		FileIO t = new FileIO();
	}
}
