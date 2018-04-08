package com.revature.fileio;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.StringTokenizer;

public class FileIO {

	public static void main(String[] args) throws IOException {
		fileRead();
	
		employee e = new employee();
		
		
		}
	
	 public static void fileRead() throws IOException {
		 
		 FileReader fr = new FileReader("C:\\Users\\balak\\Documents\\revature_projects\\Assignment1\\src\\com\\revature\\fileio\\Input.txt");
			BufferedReader br = new BufferedReader (fr);
			
			String s = br.readLine();
			
			StringTokenizer st = new StringTokenizer(s, ":");
			while(st.hasMoreTokens()) {
			String id = st.nextToken();
			String Fname = st.nextToken();
			String Lname = st.nextToken();
			String Role = st.nextToken();
			
			System.out.println(id);
			System.out.println(Fname);
			System.out.println(Lname);
			System.out.println(Role);
			
			
			
			}
			
			HashMap<Integer,String> emp = new HashMap<Integer,String>();
	 }
			

}


