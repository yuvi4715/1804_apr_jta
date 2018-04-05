/**
 * 
 */
package com.revature.assignments.weekone.fio;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;
import java.util.Map.Entry;

/**
 * @author Ed M
 * @date Apr 4, 2018
 * @time time 3:38:04 PM
 */// Q24-Q28
public class F_IO {
	// Employee id:First Name:Last Name:Role
	// Read the file, and parse(tokenize) the fields using StringTokenizer with
	// delimiter(:)
	// While parsing the file, place the information in an object, which should have
	// four instance variables: Employee Id, First Name, Last Name, Role.
	// Place these objects in a HashMap with the key as employee id and value as the
	// object
	// i.e HashMap should have[
	// Key: 01 Value : Object representing first line
	// Key: the 02 Value: Object representing second line

	// Q24 - Q28
	private HashMap<Integer, Employee> hmap = new HashMap<Integer, Employee>();

	public F_IO() {
		try {
			File file = new File(
					"C:\\Users\\kaiser\\CS\\RevatureTraning\\Repo\\1804_apr_jta\\Week One\\com\\revature\\assignments\\weekone\\fio\\Employee.txt");
			FileReader fileReader = new FileReader(file);
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			StringBuffer stringBuffer = new StringBuffer();
			String line;
			while ((line = bufferedReader.readLine()) != null) {
				stringBuffer.append(line);
				stringBuffer.append("\n");
			}
			fileReader.close();
			System.out.println("Contents of file:");
			StringTokenizer token = new StringTokenizer(stringBuffer.toString(), "\n:");
			int fourCount = 1;
			String idHolder = null;
			String fristNameHolder = null;
			String lastNameHolder = null;
			String roleHolder = null;
			int tobeConverted = -1;
			while (token.hasMoreTokens()) {
				
				String temp0 = token.nextToken();
				// System.out.println(temp0);
				if (fourCount == 1 ) {
					idHolder = temp0;
					//System.out.println( idHolder);
					fourCount++;
				}else if (fourCount == 2) {
					fristNameHolder = temp0;
					// System.out.println(fristNameHolder);
					fourCount++;
				}else if (fourCount == 3) {
					lastNameHolder = temp0;
					// System.out.println(lastNameHolder);
					fourCount++;
				}else if (fourCount == 4) {
					roleHolder = temp0;
					
					Employee tempE = new Employee(idHolder, fristNameHolder, lastNameHolder, roleHolder);
					
					Integer key = Integer.valueOf(idHolder);
					hmap.put(key,tempE);
					
					System.out.println(tempE.toString());
					fourCount = 1;
				}
			}


		} catch (IOException e) {
			e.printStackTrace();
		}
		HashMap<Integer, Employee> testhmap = hmap;
		for (Entry<Integer, Employee> entry : hmap.entrySet()) {
			Integer key = entry.getKey();
			String value = entry.toString();
			System.out.println("Key: " + key.toString() + " Value: " + value);
		}
		
	}

	public class Employee {
		String id;
		String firstName;
		String lastName;
		String role;

		public String getId() {
			return id;
		}

		public String getFirstName() {
			return firstName;
		}

		public String getLastName() {
			return lastName;
		}

		public String getRole() {
			return role;
		}

		private Employee(String id, String firstName, String lastName, String role) {
			this.id = id;
			this.firstName = firstName;
			this.lastName = lastName;
			this.role = role;

		}

		

		public String toString() {
			return ("Employee id: " + id + " ,Frist Name" + firstName + ", Last Name: " + lastName + ", Role: " + role);

		}

	}

	public static void main(String[] args) {
		F_IO test = new F_IO();

	}

}
