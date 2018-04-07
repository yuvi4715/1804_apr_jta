import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import com.revature.exception.ExceptionExample;

public class ExceptionTest {
	ExceptionExample ee= new ExceptionExample();
	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	@Ignore
	public void test() {
			ee.divideByNumbers(10, 0);
			
	}
	@Test (expected=NullPointerException.class)
	public void checkForNullPointer() {
		ee.pointerException();
	}
	
	@Test
	public void numberFormatException() {
		ee.riskyBehavior();
	}

}
