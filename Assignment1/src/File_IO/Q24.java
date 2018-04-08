//John Eifert
package File_IO;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.StringTokenizer;
import java.util.HashMap;

//This program answers questions 24-28 alongside Employee.java and Info.txt

public class Q24
{
	public static void main(String args[]) throws Exception
	{
		BufferedReader iStream=null;
		
		Employee e1 = new Employee();
		Employee e2 = new Employee();
		
		
		try
		{
			iStream = new BufferedReader(new FileReader("C:\\Git_Repos\\1804_apr_jta\\Assignment1\\src\\File_IO\\Info.txt"));
			
			String line;
			int finished=0;
			while((line=iStream.readLine()) != null)
			{
				//Parses Info.txt:
				StringTokenizer splitter = new StringTokenizer(line, ":");
				
				if(finished == 0)
				{
					//Reads the data from Info.txt into e1:
					e1.employeeID=Integer.parseInt(splitter.nextToken());
					e1.firstName=splitter.nextToken();
					e1.lastName=splitter.nextToken();
					e1.role=splitter.nextToken();
					
					System.out.println(e1.employeeID);
					System.out.println(e1.firstName);
					System.out.println(e1.lastName);
					System.out.println(e1.role);
				}
				else
				{
					//Reads the data from Info.txt into e2:
					e2.employeeID=Integer.parseInt(splitter.nextToken());
					e2.firstName=splitter.nextToken();
					e2.lastName=splitter.nextToken();
					e2.role=splitter.nextToken();
					
					System.out.println(e2.employeeID);
					System.out.println(e2.firstName);
					System.out.println(e2.lastName);
					System.out.println(e2.role);
				}
				
				finished++;
			}
			
			
			//Put the e1 and e2 in a HashMap with their employeeIDs as their keys (question 28):
			HashMap<Integer, Employee> map = new HashMap<Integer, Employee>();
			map.put(e1.employeeID, e1);
			map.put(e2.employeeID, e2);
		}
		finally
		{
			if(iStream!=null)
			{
				iStream.close();
			}
		}
	}
}
