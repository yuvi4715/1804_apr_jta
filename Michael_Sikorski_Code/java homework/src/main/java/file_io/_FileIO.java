package file_io;

import java.io.File;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;
import java.util.StringTokenizer;

import javax.swing.event.ListSelectionEvent;

public class _FileIO {
	
	static HashMap<Integer,Employee> hm;
	static File f;
	
	public _FileIO() {
		f = new File("src\\\\main\\\\java\\\\employees.txt");
	}
	
	public static void main(String[] args) {
		hm = new HashMap<>();
		try {
			Scanner in = new Scanner(f);
			while
				(in.hasNextLine()) {
				String line = in.nextLine();
				StringTokenizer st = new StringTokenizer(line,":");
				Employee e = new Employee();
				Integer id = Integer.parseInt(st.nextToken());
				e.setId(id);
				e.setFirstName(st.nextToken());
				e.setLastName(st.nextToken());
				e.setRole(st.nextToken());
				hm.put(id, e);
			}
			in.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("The HashMap contains the following data: ");
		for (Integer key : hm.keySet()) {
			System.out.print(key + " : " + hm.get(key).toString());
			System.out.println();
		} 
	}
	
	public File getFile() {
		return f;
	}
}
