package com.revature.fileio;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileInputStreamExample {
	FileInputStream fis =null;
	FileOutputStream fos = null;
	int x;
	public static void main(String[] args) {
		 new FileInputStreamExample().readBytes();
	}
	
	void readBytes(){
		try{
			fos = new FileOutputStream("C:\\Users\\joeyi\\spring-workspace\\1804_apr_java_spring\\src\\main\\resources\\Two.txt");
			fis = new FileInputStream("C:\\Users\\joeyi\\spring-workspace\\1804_apr_java_spring\\src\\main\\resources\\One.txt");
			while((x=fis.read()) != -1) {
			   fos.write(x);
			}
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {
				fis.close();
				fos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}
	
	

}
