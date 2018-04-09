package FileIO;

import java.io.File;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Scanner;
import java.util.StringTokenizer;

public class question24To26 {
	public static void main(String[] args) throws Exception {
		FileReader fr = new FileReader("/Users/huayangzhang/Documents/workspace-sts-3.9.3.RELEASE/1804_apr_java/src/main/resources/HelloWorld.txt");
		System.out.println(fr);
		Scanner scanner = new Scanner(fr);

		while (scanner.hasNextLine()) {
			String str = scanner.nextLine(); // read line
			StringTokenizer st = new StringTokenizer(str, ":");

			// parse line
			while (st.hasMoreTokens()) {
				String e = st.nextToken();
				int employeeID = Integer.parseInt(e); // convert String to int
				String f = st.nextToken();
				String l = st.nextToken();
				String r = st.nextToken();
				
			}
		}
		scanner.close();
	}

}
