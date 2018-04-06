package questions24to28;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.StringTokenizer;

public class q24to28 {

	public static void main(String[] args) throws Exception {
		String fileName="src\\main\\resources\\Employees.txt";
		String line=null;
		HashMap<Integer,Employee> employeeMap = new HashMap<Integer, Employee>();
		//TODO move all of this outside of name
		try {
			FileReader fd = new FileReader(fileName);
			@SuppressWarnings("resource")
			BufferedReader bufferedReader=new BufferedReader(fd);
			while((line=bufferedReader.readLine())!=null) {
				Employee temp = new Employee();
				StringTokenizer st =new StringTokenizer(line,":");
				if(st.countTokens()>4||st.countTokens()<4) {
					//TODO add new custom Exception called ImproperNumberOfFields
					throw new Exception();
				}
				try {
					temp.setID(Integer.parseInt(st.nextToken()));
				}
				catch(Exception notNum) {
					System.out.println("Invalid Employee ID");
					return;
				}
				temp.setFirstName(st.nextToken());
				temp.setLastName(st.nextToken());
				temp.setJob(st.nextToken());
				employeeMap.put(temp.getID(), temp);
			}
		}
		catch(FileNotFoundException e) {
			System.out.println("file not found");
			e.printStackTrace();
			return;
		}
		catch(IOException ioE) {
			System.out.println("Input/Output Error");
			ioE.printStackTrace();
			return;
		}
		System.out.println(employeeMap);
	}
}
