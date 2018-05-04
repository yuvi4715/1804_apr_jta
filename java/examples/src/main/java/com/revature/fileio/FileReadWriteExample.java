package com.revature.fileio;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileReadWriteExample {

	FileReader fr = null;
	FileWriter fw = null;
	int c;
	
	public static void main(String[] args) throws IOException {
		new FileReadWriteExample().readChar();
		new FileReadWriteExample().writeChar();
	}
	
	void readChar() throws IOException{
		fr = new FileReader("C:\\Workspace\\1804_apr_java\\src\\main\\resources\\FileRead.txt");
		while ((c = fr.read()) != -1) {
			System.out.println(c);
		}
		fr.close();
	}
	
	void writeChar() throws IOException {
		fw = new FileWriter("C:\\Workspace\\1804_apr_java\\src\\main\\resources\\FileWrite.txt");
		fr = new FileReader("C:\\Workspace\\1804_apr_java\\src\\main\\resources\\FileRead.txt");
		for (int i=1; i< 200; i++) {
			//System.out.println(fr.read());
			fw.write(fr.read());
		}
		fr.close();
		fw.close();
	}
}
