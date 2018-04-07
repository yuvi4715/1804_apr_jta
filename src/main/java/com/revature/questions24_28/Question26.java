package com.revature.questions24_28;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Question26 {
	
	public static void main(String[] args) throws IOException {

		String documentName = "C:\\Users\\Rathalos\\Documents\\Java\\Workplace\\assignment1\\src\\main\\resources\\Question25.txt";
		StringTokenizer textToken = readFile(documentName);
		while (textToken.hasMoreTokens()) {
			System.out.println(textToken.nextToken());
		}
		
	}
	
// getting single employee instead of multiple	
//	static StringTokenizer readFile(String docName) throws IOException {
//		
//		FileReader file25 = new FileReader(docName);
//		BufferedReader read25 = new BufferedReader(file25);
//		try {
//	        StringBuilder maketext25 = new StringBuilder(read25.readLine());
//			String text25 = new String(maketext25.toString());
//			
//			StringTokenizer token25 = new StringTokenizer(text25, ":");
//
//	        return token25;
//	        
//	    } finally {
//	    	file25.close();
//	        read25.close();
//	    } 
//	
//	}
	
	static StringTokenizer readFile(String docName) throws IOException {
	
	FileReader file25 = new FileReader(docName);
	BufferedReader read25 = new BufferedReader(file25);
	String docline;
	StringBuilder maketext25 = new StringBuilder();

	while( (docline = read25.readLine()) != null) {
		maketext25.append(docline + ":");
	}
	String text25 = new String(maketext25.toString());
	
	StringTokenizer token25 = new StringTokenizer(text25, ":");

	file25.close();
    read25.close();
    return token25;

	}	
	
}
