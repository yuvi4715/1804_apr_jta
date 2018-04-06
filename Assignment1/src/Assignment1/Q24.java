package Assignment1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.StringTokenizer;
import java.util.HashMap;


public class Q24
{
	public static void main(String args[]) throws Exception
	{
		BufferedReader iStream=null;
		
		
		Employee e1 = new Employee();
		Employee e2 = new Employee();
		
		
		try
		{
			iStream = new BufferedReader(new FileReader("C:\\Users\\firen\\Documents\\workspace-sts-3.9.3.RELEASE\\Assignment1\\src\\Assignment1\\Info.txt"));
			
			String line;
			int finished=0;
			while((line=iStream.readLine()) != null)
			{
				StringTokenizer splitter = new StringTokenizer(line, ":");
				
				if(finished == 0)
				{
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
