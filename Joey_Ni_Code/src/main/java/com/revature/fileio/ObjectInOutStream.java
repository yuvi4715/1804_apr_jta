package com.revature.fileio;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class ObjectInOutStream {

	ObjectInputStream ois =null;
	ObjectOutputStream oos =null;
	
	public static void main(String[] args) throws ClassNotFoundException {
		new ObjectInOutStream().performSerialization(new Person());
		new ObjectInOutStream().performDeserialization(new Person());
		
	}
	
	void performSerialization(Person p) {
		try {
		oos = new ObjectOutputStream(new FileOutputStream("C:\\Users\\joeyi\\spring-workspace\\1804_apr_java_spring\\src\\main\\resources\\object.txt"));
		
			oos.writeObject(p);
			oos.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	void performDeserialization(Person p) throws ClassNotFoundException 
	{
		try {
			ois=new ObjectInputStream(new FileInputStream("C:\\Users\\joeyi\\spring-workspace\\1804_apr_java_spring\\src\\main\\resources\\object.txt"));
			Person tom=(Person) ois.readObject();
			tom.getAge();
			tom.getAddress();
			System.out.println(tom.toString());
			ois.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	
	}
}
