package assignment.Joey.fileio;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.StringTokenizer;

import assignment.Joey.StringConcept.StringPlay;

/**1. Consider a text file has the following colon-separated lines:
2. Employee id:First Name:Last Name:Role
3. Read the file, and parse(tokenize) the fields using StringTokenizer with delimiter(:)
4. While parsing the file, place the information in an object, which should have four instance variables: Employee Id, First Name, Last Name, Role. 
5. Place these objects in a HashMap with the key as employee id and value as the object
i.e HashMap should have[
Key: 01 Value : Object representing first line
Key: the 02 Value: Object representing second line
*/



public class Employee {


	int age; //age
	int eid; //Employee Id, 
	String fName; //First Name, 
	String lName; //Last Name, 
	String Role; //Role
	static HashMap <Integer, Employee > employeeMap = new HashMap<>();
	//overload constructor
	
	public Employee(int eid, String fName, String lName, String role) {
		super();
		this.eid = eid;
		this.fName = fName;
		this.lName = lName;
		Role = role;
	}
	

	public Employee(int age, int eid, String fName, String lName, String role) {
		super();
		this.age = age;
		this.eid = eid;
		this.fName = fName;
		this.lName = lName;
		Role = role;
	}


	public int getAge() {
		return age;
	}


	public void setAge(int age) {
		this.age = age;
	}


	@Override
	public String toString() {
		return "Key: "+eid +"  Value:[eid=" + eid + ", fName=" + fName + ", lName=" + lName + ", Role=" + Role + "]";
	}

	
	public int getEid() {
		return eid;
	}

	public void setEid(int eid) {
		this.eid = eid;
	}

	public String getfName() {
		return fName;
	}

	public void setfName(String fName) {
		this.fName = fName;
	}

	public String getlName() {
		return lName;
	}

	public void setlName(String lName) {
		this.lName = lName;
	}

	public String getRole() {
		return Role;
	}

	public void setRole(String role) {
		Role = role;
	}

	public static HashMap<Integer, Employee> getEmployeeMap() {
		return employeeMap;
	}

	public static void setEmployeeMap(HashMap<Integer, Employee> employeeMap) {
		Employee.employeeMap = employeeMap;
	}

	

	public static void main(String[] args) throws IOException {
		
		readFile.read("C:\\Users\\joeyi\\spring-workspace\\1804_apr_java_spring\\src\\main\\resources\\EmployeeResources");
		
		System.out.println("Formatted toString of employeeMap" + employeeMap);
		System.out.println("For loop print of employeeMap");
		for(Entry<Integer, Employee> e: employeeMap.entrySet()) {
			System.out.println(e);
		}
		
	}
}
	
	class EmployeeCompare implements Comparator<Employee>{


		@Override
		public int compare(Employee o1, Employee o2) {
			int result=o1.getlName().compareToIgnoreCase(o2.getlName());
			if (result!=0) return result; //compare by lastname
			result = o1.getfName().compareToIgnoreCase(o2.getfName());
			if (result!=0) return result; //compare by firstname
			result = o1.getRole().compareToIgnoreCase(o2.getRole());
			if (result!=0) return result; 
			return o1.getAge()-o2.getAge();
		}

		public static String compareByName(Employee o1, Employee o2) {
			int nameNum= o1.getlName().compareToIgnoreCase(o2.getlName());
			if (nameNum==0)
			{	nameNum = o1.getfName().compareToIgnoreCase(o2.getfName());
				if (nameNum==0) compareByDep(o1, o2);
			}
			else if (nameNum<0) return o1.getlName();
			return o2.getfName() ; 
		}
		
		public static Employee compareByDep(Employee o1, Employee o2)
		{
			int department =o1.getRole().compareToIgnoreCase(o2.getRole());
			if (department==0) compareByAge(o1,o2);
			else if (department<-1) return o1;
			return o2;
			
			
		}
		public static Employee compareByAge(Employee o1, Employee o2)
		{
			if (o1.getAge() <o2.getAge()) return o1;
			else return o2;
		}
		
	}
	class readFile 
	{
		
		public static void read(String fileName) throws IOException {
		BufferedReader br=new BufferedReader(new FileReader(fileName));
		String data=null;
		String fNameTemp=null;
		String lNameTemp=null;
		String roleTemp=null;
		Integer eidTemp=null;
		
		try {
			
			while((data=br.readLine())!=null) {
				   
				   StringTokenizer st = new StringTokenizer(data);
				   eidTemp=StringPlay.parseInt(st.nextToken(":"), "[\\D]+"); //temporarily store eid
				   fNameTemp=st.nextToken(":"); 
				   lNameTemp=st.nextToken(":");
				   roleTemp=st.nextToken(":");
				   Employee.employeeMap.put(eidTemp, new Employee(eidTemp, fNameTemp, lNameTemp,roleTemp));
				
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {br.close();}
		
	}
	

}
