package fileIO;
/**
 * Dominick Sermeno
 * Batch 1804
 * Q's: 24-28
 */
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;
import java.util.StringTokenizer;

public class FileIOEmployeeReader
{

	public static void main(String[] args) throws IOException 
	{
		
		new FileIOEmployeeReader().readFile();
		
	}

	void readFile() throws IOException
	{
		// Declare File path/////////////
		File employeeFile = new File("C:\\Users\\domin\\Desktop\\Program Workspace\\EclipseJava\\1804_april_java\\src\\fileIO\\Employee.txt");
		/////////////////////////////////
		
		
		Scanner employeeScanner = new Scanner(employeeFile); 
		String feed = employeeScanner.nextLine();
		StringTokenizer sToken = new StringTokenizer(feed, ":");
		HashMap<Integer,Employee> hM = new HashMap<Integer,Employee>();
		
		//////Fill the Hash Set////////////////
		while (sToken.hasMoreTokens()) 
		{
			String ID,firstName,lastName,role;
			ID = sToken.nextToken();
			firstName = sToken.nextToken();
			lastName = sToken.nextToken();
			role = sToken.nextToken();
			Integer emID = Integer.parseInt(ID);
			Employee test = new Employee(emID,firstName,lastName,role);
			hM.put(test.key, test);
		}
		////////////////////////////////////////
		
		////////////Iterate over the set////////
		Set<Integer> theKeys= hM.keySet();
		Iterator<Integer> iTHM = theKeys.iterator();
		while(iTHM.hasNext())
		{
			Integer curr = iTHM.next();
			System.out.println(hM.get(curr));		
		}
		////////////////////////////////////////
		
		employeeScanner.close();//Always close resources
	}
	
	
 class Employee
	{
		String firstName,lastName,role;
		int key;
		public Employee(int i, String fN, String lN,String r)
		{
			key = i;
			firstName = fN;
			lastName = lN;
			role = r;
			
		}
		@Override
		public String toString() {
			return "Employee [ID = " + key + ", firstName = " + firstName + 
					", lastName = " + lastName + ", role = " + role + "]";
		}
		
		
	}
}
