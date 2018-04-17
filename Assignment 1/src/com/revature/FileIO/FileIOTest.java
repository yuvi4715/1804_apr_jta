package com.revature.FileIO;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;
//problems 24,25,26,27, 28
public class FileIOTest {
	public static void main(String[] args) throws Exception {
		FileIOTest fIO = new FileIOTest();
	
			fIO.byteStreamMethod();
	}
	
	public void byteStreamMethod() throws Exception{
		FileInputStream in = null;
		ObjectOutputStream oos = null;
		
		BufferedReader br = null;
		Person p = new Person();
		try {
			in = new FileInputStream("C:\\Users\\Mitchell H's PC\\Documents\\workspace-sts-3.9.3.RELEASE\\JavaHomework1\\src\\com\\revature\\FileIO\\myPerson.txt");
			br = new BufferedReader(new InputStreamReader(in));
			String line;
			String readFile = "";
			
			while((line = br.readLine()) != null) {
				readFile = readFile + line;
			}
			StringTokenizer st = new StringTokenizer(readFile,":");
			ArrayList<Object> al = new ArrayList<Object>();
			
			while(st.hasMoreTokens()) {
				al.add(st.nextToken());
			}
			p.setId((String)al.get(0));
			p.setFirstName((String)al.get(1));
			p.setLastName((String)al.get(2));
			p.setRole((String)al.get(3));
			
			HashMap<String,Person> hm = new HashMap<String,Person>();
			hm.put(p.getId(), p);
			
			System.out.println(hm.get(p.getId()).getFirstName());
			
			 
		}finally {
			if (in != null) {
				in.close();
			}
	}
	
}
}
