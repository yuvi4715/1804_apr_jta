package syntax1;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class SyntaxTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test4() {
		Problem4 p4 = new Problem4();
		
		p4.setX(15);
		p4.setY(3);
		System.out.println(p4.addFunction());
		System.out.println(p4.subtractFunction());
		System.out.println(p4.multiplyFunction());
		System.out.println(p4.divideFunction());
		
		p4 = new Problem4(5,0);
		System.out.println(p4.addFunction());
		System.out.println(p4.subtractFunction());
		System.out.println(p4.multiplyFunction());
		System.out.println(p4.divideFunction());
		
		p4.setY(1);
		System.out.println(p4.divideFunction());
		
		
	}

}
