package filesI0;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;
import java.util.StringTokenizer;

		public class FilesIO 
		{


		BufferedReader inputStream = null;
		
		private String employeeID;
		private String firstName;
		private String lastName;
		private String role;
		
		public String getEmployeeID() 
		{
			return employeeID;
		}

		public void setEmployeeID(String employeeID) 
		{
			this.employeeID = employeeID;
		}

		public String getFirstName() 
		{
			return firstName;
		}

		public void setFirstName(String firstName) 
		{
			this.firstName = firstName;
		}

		public String getLastName() 
		{
			return lastName;
		}

		public void setLastName(String lastName) 
		{
			this.lastName = lastName;
		}

		public String getRole() 
		{
			return role;
		}

		public void setRole(String role) 
		{
			this.role = role;
		}

		public void manageFile() throws Exception 
		{
			try 
			{

				inputStream = new BufferedReader(new FileReader("/Users/ramnerylugo/Documents/workspace-sts-3.9.3.RELEASE/1804_FirstAssigment/src/filesI0/textFile.txt"));
				
				StringTokenizer tokenizer = new StringTokenizer(inputStream.readLine(),":");
				
				FilesIO employee1 = new FilesIO();
				FilesIO employee2 = new FilesIO();
				
				employee1.setEmployeeID(tokenizer.nextToken());
				employee1.setFirstName(tokenizer.nextToken());
				employee1.setLastName(tokenizer.nextToken());
				employee1.setRole(tokenizer.nextToken());
				
				tokenizer = new StringTokenizer(inputStream.readLine(),":");
				
				employee2.setEmployeeID(tokenizer.nextToken());
				employee2.setFirstName(tokenizer.nextToken());
				employee2.setLastName(tokenizer.nextToken());
				employee2.setRole(tokenizer.nextToken());
				
				HashMap<String,FilesIO> hm = new HashMap<>();
				hm.put(employee1.getEmployeeID(), employee1);
				hm.put(employee2.getEmployeeID(), employee2);
				
				System.out.println("Test Message.");
				
				
			} 
			catch (FileNotFoundException e) 
			{
				e.printStackTrace();
			} 
			finally 
			{
				if (inputStream != null)
					inputStream.close();
				

			}	
		}
		
		public static void main(String[] args) throws Exception 
		{
			new FilesIO().manageFile();
		}
		
	}
	
	

