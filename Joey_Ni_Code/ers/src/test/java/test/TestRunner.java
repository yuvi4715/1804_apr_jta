package test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;
/**
 * JUnit test runner class that runs a bunch of tests on a bunch of classes
 * @author joeyi
 *
 */
public class TestRunner {
	public static void main(String[] args) {
		
		Result result= JUnitCore.runClasses(ManagerTest.class);
		

	for(Failure failure: result.getFailures())
	{
		System.out.println(failure.getDescription());
		System.out.println(failure.toString());
		System.out.println(failure.getTestHeader());
	}
	
	System.out.println(result.wasSuccessful());
	}
}
