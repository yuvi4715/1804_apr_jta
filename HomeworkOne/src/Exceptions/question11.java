//Create a class that manually throws an exception of your custom type

package Exceptions;

import Exceptions.question10;
import Exceptions.question11;

public class question11 {

	public static void main(String[] args) throws question10 {
		new question11().usingArrays();
	}
	
	void usingArrays() throws question10{
		String s2 = null;
		if (s2 == null) {
			// always throw new
			throw new question10();
		}
	}
	
}
