package fileIO;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem27 {
	
	
	public static void main(String[] args) throws IOException {
		
		InputStream p25 = null;
		BufferedReader buffer = null;
		
		try {
			
			p25 = new FileInputStream("C:\\Users\\haunt\\Documents\\workspace-sts-3.9.3.RELEASE\\com.revature.week1\\src\\main\\resources\\Problem25.txt");
			buffer = new BufferedReader(new InputStreamReader(p25));
			StringBuilder strBldr = new StringBuilder(buffer.readLine());
			
			String str = new String(strBldr.toString());
			
			System.out.println(str);
			
			StringTokenizer strTknr = new StringTokenizer(str, ":");
			
			Employee emp = new Employee();
			emp.setEmpID(strTknr.nextToken());
			emp.setFirstName(strTknr.nextToken());
			emp.setLastName(strTknr.nextToken());
			emp.setRole(strTknr.nextToken());
			
			System.out.println(emp.getEmpID());
			System.out.println(emp.getFirstName());
			System.out.println(emp.getLastName());
			System.out.println(emp.getRole());
			
			
			
			
			
			
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
