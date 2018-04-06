package fileIO;
//Kevin Rivera - Revature
//Assignment Week 1: File I/O - Problem 24, 25, 26, 27, 28.
//This class is an example of File I/O by opening and reading each line 
//of a file using a BufferedReader, then tokenizing the line to get and
//assign those strings values to members of the class. Then those objects
//were inserted into a HashMap, using the member employeeID as the key.

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class FileIO_Example {
	BufferedReader inputStream = null;
	//PrintWriter outputStream = null;
	
	private String employeeID;
	private String firstName;
	private String lastName;
	private String role;
	
	public String getEmployeeID() {
		return employeeID;
	}

	public void setEmployeeID(String employeeID) {
		this.employeeID = employeeID;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public void manageFile() throws Exception {
		try {
			//Open file into a BufferedReader so we can read each line at a time
			inputStream = new BufferedReader(new FileReader("C:\\STS\\Workspace\\Asssignment_Week1\\src\\fileIO\\txt1"));
			
			//Tokenize each line using the delimiter: ":"
			StringTokenizer tokenizer = new StringTokenizer(inputStream.readLine(),":");
			
			//Create two objects to add them to a HashMap
			FileIO_Example employee1 = new FileIO_Example();
			FileIO_Example employee2 = new FileIO_Example();
			
			//Fill first object with first line of file
			employee1.setEmployeeID(tokenizer.nextToken());
			employee1.setFirstName(tokenizer.nextToken());
			employee1.setLastName(tokenizer.nextToken());
			employee1.setRole(tokenizer.nextToken());
			
			//Get next line in the file
			tokenizer = new StringTokenizer(inputStream.readLine(),":");
			
			//Fill the second object with the information from the line
			employee2.setEmployeeID(tokenizer.nextToken());
			employee2.setFirstName(tokenizer.nextToken());
			employee2.setLastName(tokenizer.nextToken());
			employee2.setRole(tokenizer.nextToken());
			
			//Place objects in a new HashMap and use their ID as the key
			HashMap<String,FileIO_Example> hm = new HashMap<>();
			hm.put(employee1.getEmployeeID(), employee1);
			hm.put(employee2.getEmployeeID(), employee2);
			
			System.out.println("If you got here, you're good, my man.");
			
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} finally {
			if (inputStream != null)
				inputStream.close();
			//if (outputStream != null)
			//	outputStream.close();
		}	
	}
	
	public static void main(String[] args) throws Exception {
		new FileIO_Example().manageFile();
	}
	
}
