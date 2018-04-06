package FileIO;

import java.io.*;

/**
 * Created by bryanvillegas on 4/5/18.
 */
import java.util.StringTokenizer;
import  java.util.HashMap;
import java.util.Map;
public class Employee {

    int empID;
    String firstName;
    String lastName;
    String role;

    public static void main(String[] args){

        String empFile = "empFile.txt";
        String line = null;
        StringTokenizer tok;
        Employee emp = new Employee();
        HashMap<Integer, Employee> map = new HashMap<Integer, Employee>();

        try{
            FileReader fileReader = new FileReader(empFile);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            while((line = bufferedReader.readLine()) != null){
                tok = new StringTokenizer(line, ":");
                emp.empID = Integer.parseInt(tok.nextToken());

                emp.firstName = tok.nextToken();
                emp.lastName = tok.nextToken();
                emp.role = tok.nextToken();

                map.put(emp.empID, emp);
                emp = new Employee();

            }

            print(map);
            bufferedReader.close();
        }
        catch(FileNotFoundException e){

            System.out.println("File not found");

        }
        catch(IOException ex){



        }


    }
    public static void print(Map<Integer, Employee> map){
        Employee e = map.get(1234);
        System.out.println("Name : " + e.firstName + " " + e.lastName);

    }
}
