package Problems24To28;
import java.io.*;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class mainTest {

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		String FileName = "src/Problems24To28/info.txt";
		String line = null;
		HashMap<Integer, Employee> employees = new HashMap<Integer, Employee>(); 
		
		 try 
		 {
			 FileReader fileReader = new FileReader(FileName); 
			 BufferedReader bufferedReader = new BufferedReader(fileReader);
			 while((line = bufferedReader.readLine()) != null) 
			 {
				 String[] ParsedInfo = line.split(":");
				 employees.put(Integer.parseInt(ParsedInfo[0]) , new Employee(ParsedInfo[0], ParsedInfo[1], ParsedInfo[2], ParsedInfo[3]));
	         }   
			 bufferedReader.close();
			 
			 Iterator it = employees.entrySet().iterator();
			 while(it.hasNext())
			 {
				 Map.Entry pair = (Map.Entry)it.next();
				 System.out.println(pair.getKey() + " = " + ((Employee) pair.getValue()).getFname());	
				 it.remove();
			 }
		 }
   
		 catch(FileNotFoundException ex) 
		 {   
			 System.out.println("Unable to open file '" + FileName + "'");                
		 }
	        
		 catch(IOException ex) 
		 {  
			 System.out.println("Error reading file '" + FileName + "'");                  
		 }
	}
}
