package com.revature.FileIO;
import java.io.*;
import java.util.HashMap;
import java.util.Set;
import java.util.StringTokenizer;

public class ExcercisesIO {

	FileReader fr = null;
	FileWriter fw = null;
	StringTokenizer st = null;
	public String s;
	HashMap<Integer, Object> hm = new HashMap();
	
	public static void main(String[] args) {
		try {
			new ExcercisesIO().readEmployees();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	void readEmployees() throws IOException{
		fr = new FileReader("C:\\Users\\pinky\\Documents\\workspace-sts-3.9.3.RELEASE\\Assignment_Week_1\\src\\main\\resources\\Employees");
		BufferedReader in = new BufferedReader(fr);
		
		while((s =in.readLine()) != null) {
			StringTokenizer st = new StringTokenizer(s, ":");
			Employee e = new Employee(Integer.parseInt(st.nextToken()), st.nextToken(), st.nextToken(), st.nextToken());
			hm.put(e.getId(), e);
		}
		fr.close();
		in.close();
		
		Set<Integer> si = hm.keySet();
		
		for(int i : si) {
			System.out.print("Key: " + i + " Value: " + hm.get(i) + ", ");
		}
	}
}
