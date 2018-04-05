package fileIO;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.HashMap;

public class Problem28 {
	
	public static void main(String[] args) throws IOException {
		
		InputStream p25 = null;
		BufferedReader buffer = null;
		
		
		
		try {
			
			p25 = new FileInputStream("C:\\Users\\haunt\\Documents\\workspace-sts-3.9.3.RELEASE\\com.revature.week1\\src\\main\\resources\\EmployeesFile.txt");
			buffer = new BufferedReader(new InputStreamReader(p25));
			StringBuilder strBldr = null;
			String str = null;
			StringTokenizer strTknr = null;
			
			Employee [] emp = new Employee[4];
			
			HashMap<Integer, Employee> map = new HashMap<>();
			
			
			
			for (int i = 0; i < 4; i++) {
				emp[i] = new Employee();
				
				strBldr = new StringBuilder(buffer.readLine());
				str = new String(strBldr.toString());
				strTknr = new StringTokenizer(str, ":");
				
				emp[i].setEmpID(strTknr.nextToken());
				emp[i].setFirstName(strTknr.nextToken());
				emp[i].setLastName(strTknr.nextToken());
				emp[i].setRole(strTknr.nextToken());
				
				Integer temp = i;
				
				
				map.put(temp, emp[i]);
				
				
				
			}
			
			
			
			
		} catch (Exception e) {
			
			System.out.println("Something wrong with file read.");
			
		} finally {
			
			if (p25 != null) {
				p25.close();
				
			}
			if (buffer != null) {
				buffer.close();
				
			}
			
			
			
		}
		
		
		
		
	}
	
	
}
