package exceptionsQuestion11;

import java.io.PrintStream;

public class ExceptionsQuestion11 {
	
//	Create a class that manually throws an exception of your custom type


		public static void main(String... strings ) {
			test01(System.out);
		}
		public static void test01(PrintStream out) {
			try {
				throw new ExceptionsQuestion11b();
			}catch(Exception e) {
				out.println(e.getMessage());
			}
		}
	}

