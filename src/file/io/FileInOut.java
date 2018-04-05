package file.io;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class FileInOut {

	public static void main(String[] args) throws IOException {
		
		FileReader input = new FileReader("C:\\Users\\Adam Ranieri\\Desktop\\employees.txt");
		BufferedReader bufRead = new BufferedReader(input);
		String myLine = null;
		
		myLine = bufRead.readLine();
		
		
		StringTokenizer t = new StringTokenizer(myLine, ":");
		
		String id = (t.nextToken());
		String firstName = (t.nextToken());
		String lastName = (t.nextToken());
		String role = (t.nextToken());
		
		
		System.out.println(role);

	}

}
