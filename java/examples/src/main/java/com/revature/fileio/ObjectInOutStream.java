package com.revature.fileio;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class ObjectInOutStream {

	ObjectInputStream ois;
	ObjectOutputStream oos;
	//static Person p;
	
	public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
		new ObjectInOutStream().performSerialization(new Person());
		new ObjectInOutStream().performDeSerialization(new Person());
	}

	void performSerialization(Person p) throws FileNotFoundException, IOException {
		oos = new ObjectOutputStream(new FileOutputStream("src\\main\\resources\\object.txt"));
		oos.writeObject(p);
		oos.close();
	}
	
	void performDeSerialization(Person p) throws FileNotFoundException, IOException, ClassNotFoundException{
		ois = new ObjectInputStream(new FileInputStream("src\\main\\resources\\object.txt"));
		Person Tom = (Person) ois.readObject();
		System.out.println(Tom.getAddress());
		System.out.println(Tom.getAge());
		System.out.println(Tom.getName());
		System.out.println(Tom.getSsn());
		//System.out.println(Tom.get);
		ois.close();
	}
}
