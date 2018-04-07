package com.revature.fileio;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileReaderExample {
	
	FileReader fileReader = null; 
	FileWriter fileWriter = null; 
	public static void main(String[] args) {
		new FileReaderExample().readChar();
		new FileReaderExample().writeChar();
	}
	
	void readChar() {
		try {
			fileReader =new FileReader("C:\\Users\\joeyi\\spring-workspace\\1804_apr_java_spring\\src\\main\\resources\\FileREAD");
			int c;
			while((c=fileReader.read())!=-1)
			{		System.out.println(c);
			}
		
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally{ 
			try {
			fileReader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}}
	}

	void writeChar() {
		try {
		fileWriter = new FileWriter("C:\\Users\\joeyi\\spring-workspace\\1804_apr_java_spring\\src\\main\\resources\\FileWRITE");
		fileReader =new FileReader("C:\\Users\\joeyi\\spring-workspace\\1804_apr_java_spring\\src\\main\\resources\\FileREAD");
		/**for (int i=1; i<100; i++) {
			fileWriter.write(fileReader.read());
		}*/
		int c;
		while((c=fileReader.read())!=-1) {
			fileWriter.write(c);
		}
		} catch(IOException e) {
			e.printStackTrace();
		}
		finally {
		try {
			fileReader.close();
			fileWriter.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		}
	}
}
