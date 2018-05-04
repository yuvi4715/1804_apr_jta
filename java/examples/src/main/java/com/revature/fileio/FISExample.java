package com.revature.fileio;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FISExample {

	FileInputStream fis = null;
	FileOutputStream fos = null;
	int x;

	public static void main(String[] args) throws FileNotFoundException, IOException {
		new FISExample().readWriteBytes();
	}
	void readWriteBytes() {
		try {
			fis = new FileInputStream("C:\\Workspace\\1804_apr_java\\src\\main\\resources\\One.txt");
			fos = new FileOutputStream("C:\\Workspace\\1804_apr_java\\src\\main\\resources\\Two.txt");
			while ((x = fis.read()) != -1) {
				fos.write(x);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				fis.close();
				fos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}


}
