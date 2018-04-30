package test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import junit.framework.TestResult;
import junit.framework.TestSuite;


@RunWith(value = Suite.class) 

@Suite.SuiteClasses({
	EmployeeTest.class,
	ManagerTest.class
})

public class TestRunnerSuite {
	public static void main(String[] args) {
		TestSuite suite = new TestSuite(EmployeeTest.class, ManagerTest.class, TestRunner.class);
		TestResult result = new TestResult();

		suite.run(result); //collects result in $result
		System.out.println("Number of errors = " + result.errorCount());
		System.out.println("Number of tests = " + suite.testCount());
		System.out.println("Number of test cases = " + suite.countTestCases());
		
	}
}
