package com.revature.Homework;

import static org.junit.Assert.assertTrue;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.revature.Homework.ProblemEighteen.ProblemEighteenMain;
import com.revature.Homework.ProblemEighth.ProblemEighth;
import com.revature.Homework.ProblemEleven.ProblemEleven;
import com.revature.Homework.ProblemFive.ProblemFiveMain;
import com.revature.Homework.ProblemFour.ProblemFour;
import com.revature.Homework.ProblemFourteen.ProblemFourteen;
import com.revature.Homework.ProblemNine.ProblemNineMain;
import com.revature.Homework.ProblemOne.Question01;
import com.revature.Homework.ProblemSeven.ProblemSevenBankCustomer;
import com.revature.Homework.ProblemSeventeen.ProblemSeventeenMain;
import com.revature.Homework.ProblemSixteen.ProblemSixteenMain;
import com.revature.Homework.ProblemTen.ProblemTen;
import com.revature.Homework.ProblemThirteen.ProblemThirdteenMain;
import com.revature.Homework.ProblemThirtyThree.CheckOddEven;
import com.revature.Homework.ProblemThirtyTwo.CheckPassFail;
import com.revature.Homework.ProblemThree.Question3;
import com.revature.Homework.ProblemTwelve.ProblemTwelve;
import com.revature.Homework.ProblemTwentyEight.ProblemTwentyEightMain;
import com.revature.Homework.ProblemTwentySeven.ProblemTwentySevenMain;
import com.revature.Homework.ProblemTwentySix.ProblemTwentySixMain;
import com.revature.Homework.ProblemTwo.Question2;
import com.revature.Homework.ProblemsSix.ProblemSix;

public class Tests {

	private ByteArrayOutputStream outContent;
	
	private PrintStream out;
	@Before
	public void setUpStreams() {
		outContent = new ByteArrayOutputStream();
		out = new PrintStream(outContent);
		System.out.println("******* START TEST *******");	
	}

	@After
	public void tearDown() throws IOException {
		System.out.println("******* END TEST *******");
		outContent.close();
		out.close();
		System.setIn(System.in);
	}
	/*
	@Test
	public void testOneProblemFourtyseven() {
		ProblemFiveMain.test01(out);
		System.out.println(outContent.toString());
		String s = "";
		assertTrue((s).equals(outContent.toString()));
	}
	@Test
	public void testOneProblemFourtysix() {
		ProblemFiveMain.test01(out);
		System.out.println(outContent.toString());
		String s = "";
		assertTrue((s).equals(outContent.toString()));
	}
	@Test
	public void testOneProblemFourtyfive() {
		ProblemFiveMain.test01(out);
		System.out.println(outContent.toString());
		String s = "";
		assertTrue((s).equals(outContent.toString()));
	}
	@Test
	public void testOneProblemFourtyfour() {
		ProblemFiveMain.test01(out);
		System.out.println(outContent.toString());
		String s = "";
		assertTrue((s).equals(outContent.toString()));
	}
	@Test
	public void testOneProblemFourtythree() {
		ProblemFiveMain.test01(out);
		System.out.println(outContent.toString());
		String s = "";
		assertTrue((s).equals(outContent.toString()));
	}
	@Test
	public void testOneProblemFourtytwo() {
		ProblemFiveMain.test01(out);
		System.out.println(outContent.toString());
		String s = "";
		assertTrue((s).equals(outContent.toString()));
	}
	@Test
	public void testOneProblemFourtyone() {
		ProblemFiveMain.test01(out);
		System.out.println(outContent.toString());
		String s = "";
		assertTrue((s).equals(outContent.toString()));
	}
	@Test
	public void testOneProblemFourty() {
		ProblemFiveMain.test01(out);
		System.out.println(outContent.toString());
		String s = "";
		assertTrue((s).equals(outContent.toString()));
	}
	@Test
	public void testOneProblemThirtynine() {
		ProblemFiveMain.test01(out);
		System.out.println(outContent.toString());
		String s = "";
		assertTrue((s).equals(outContent.toString()));
	}
	@Test
	public void testOneProblemThirtyeight() {
		ProblemFiveMain.test01(out);
		System.out.println(outContent.toString());
		String s = "";
		assertTrue((s).equals(outContent.toString()));
	}
	@Test
	public void testOneProblemThirtyseven() {
		ProblemFiveMain.test01(out);
		System.out.println(outContent.toString());
		String s = "";
		assertTrue((s).equals(outContent.toString()));
	}
	@Test
	public void testOneProblemThirtysix() {
		ProblemFiveMain.test01(out);
		System.out.println(outContent.toString());
		String s = "";
		assertTrue((s).equals(outContent.toString()));
	}
*/	@Test
	public void testOneProblemThirtyfive() {
		ByteArrayInputStream in = new ByteArrayInputStream((
				"1\r\n" +
				"2.0\r\n" +
				"l\r\n" 
				).getBytes());
		System.setIn(in);
		com.revature.Homework.ProblemThirtyFive.KeyboardScanner.test01(out);
		System.out.println(outContent.toString());
		String s = "Enter Number\r\n" + 
				"Enter Double Presicion\r\n" + 
				"Enter String\r\n" + 
				"Integer 1\r\n" + 
				"Double 2.0\r\n" + 
				"String l\r\n" + 
				"";
		assertTrue((s).equals(outContent.toString()));
	}

	@Test
	public void testOneProblemThrityfour() {
		ByteArrayInputStream in = new ByteArrayInputStream("1".getBytes());
		System.setIn(in);
		com.revature.Homework.ProblemThirtyFour.Main.test01(out);
		System.out.println(outContent.toString());
		String s = "Enter Number\r\n" +
				"One\r\n" + 
				"One\r\n" ;
		assertTrue((s).equals(outContent.toString()));
	}

	@Test
	public void testOneProblemThirtythree() {
		ByteArrayInputStream in = new ByteArrayInputStream("3".getBytes());
		System.setIn(in);
		CheckOddEven.test01(out);
		String result = outContent.toString();
		System.out.println(result);
		String s = "Enter Number\r\n" +  
				"Odd\r\n";
		assertTrue((s).equals(result));
	}
	@Test
	public void testOneProblemThritytwo() {
		ByteArrayInputStream in = new ByteArrayInputStream("5".getBytes());
		System.setIn(in);
		CheckPassFail.test01(out);
		System.out.println(outContent.toString());
		String s = "Enter Number\r\n" + 
				"FAIL\r\n";
		assertTrue((s).equals(outContent.toString()));
	}
	@Test
	public void testOneProblemThrityone() {
		//TODO	
	}
	@Test
	public void testOneProblemThirty() {
		//TODO
	}
	@Test
	public void testOneProblemTwentynine() {
		//TODO
	}
	@Test
	public void testOneProblemTwentyeight() throws NumberFormatException, IOException {
		ProblemTwentyEightMain.test01(out);
		System.out.println(outContent.toString());
		String s = "1 : pedro\r\n";
		assertTrue((s).equals(outContent.toString()));
	}
	@Test
	public void testOneProblemtTwentyseven() throws NumberFormatException, IOException {
		ProblemTwentySevenMain.test01(out);
		System.out.println(outContent.toString());
		String s = "Employee [FirstName=pedro, LastName=rodriguez, Role=engineer, id=1]\r\n" + 
				"Employee [FirstName=pedro, LastName=rodriguez, Role=engineer, id=1]\r\n";
		assertTrue((s).equals(outContent.toString()));
	}
	@Test
	public void testOneProblemTwentysix() throws NumberFormatException, IOException {
		ProblemTwentySixMain.test01(out);
		System.out.println(outContent.toString());
		String s = "Employee [FirstName=pedro, LastName=rodriguez, Role=engineer, id=1]\r\n" + 
				"Employee [FirstName=pedro, LastName=rodriguez, Role=engineer, id=1]\r\n";
		assertTrue((s).equals(outContent.toString()));
	}
	
	@Test
	public void testOneProblemTwentythree() {
	}
	@Test
	public void testOneProblemTwentytwo() {
		//TODO
	}
	@Test
	public void testOneProblemTwentyonw() {
		//TODO
	}
	@Test
	public void testOneProblemTwenty() {
		//TODO
	}
	@Test
	public void testOneProblemNineteen() {
		//TODO
	}
	@Test
	public void testOneProblemEighteen() {
		ProblemEighteenMain.test01(out);
		System.out.println(outContent.toString());
		String s = "Totals : 65\r\n";
		assertTrue((s).equals(outContent.toString()));
	}
	@Test
	public void testOneProblemSeventeen() {
		ProblemSeventeenMain.test01(out);
		System.out.println(outContent.toString());
		String s = "pickles\r\n" + 
				"ketchup\r\n" + 
				"mustard\r\n" + 
				"onion\r\n";
		assertTrue((s).equals(outContent.toString()));
	}
	@Test
	public void testOneProblemSixteen() {
		ProblemSixteenMain.test01(out);
		System.out.println(outContent.toString());
		String s = "String Hell \r\n";
		assertTrue((s).equals(outContent.toString()));
	}
	@Test
	public void testOneProblemFifteen() {
		//TODO cant implement because of System.exit
	}
	@Test
	public void testOneProblemFourteen() {
		ProblemFourteen.test01(out);
		System.out.println(outContent.toString());
		String s = "Top of the morning to you\r\n" + 
				   "Good bye !\r\n";
		assertTrue((s).equals(outContent.toString()));
	}
	@Test
	public void testOneProblemThridteen() {
		ProblemThirdteenMain.test01(out);
		System.out.println(outContent.toString());
		String s = "Problem ten Error\r\n";
		assertTrue((s).equals(outContent.toString()));
	}
	@Test
	public void testOneProblemTwelve() {
		ProblemTwelve.test01(out);
		System.out.println(outContent.toString());
		String s = "Starting try block\r\n" + 
				"Starting catch block\r\n" + 
				"Starting finally block\r\n"	;
		assertTrue((s).equals(outContent.toString()));
	}
	@Test
	public void testOneProblemEleven() {
		ProblemEleven.test01(out);
		System.out.println(outContent.toString());
		String s = "Problem Eleven Error\r\n" ;
		assertTrue((s).equals(outContent.toString()));
	}
	@Test
	public void testOneProblemTen() {
		ProblemTen.test01(out);
		System.out.println(outContent.toString());
		String s = "Problem ten Error\r\n";
		assertTrue((s).equals(outContent.toString()));
	}
	@Test
	public void testOneProblemNine() {
		ProblemNineMain.test01(out);
		System.out.println(outContent.toString());
		String s = "Human eating\r\n" + 
				"Moving\r\n" + 
				"Human eating\r\n" + 
				"Moving\r\n" + 
				"Walking\r\n" + 
				"Human eating\r\n" + 
				"Moving\r\n" + 
				"Walking\r\n";
		assertTrue((s).equals(outContent.toString()));
	}

	@Test
	public void testOneProblemEight() {
		ProblemEighth.test01(out);
		System.out.println(outContent.toString());
		String s = "Lerry ID: 0 has a balance of 180000.0\r\n" + 
				"Terry ID: 1 has a balance of 180000.0\r\n" + 
				"ProblemEightBankCustomer [name=Lerry, balance=40000.0, customerID=0]\r\n" + 
				"ProblemEightBankCustomer [name=Terry, balance=40000.0, customerID=1]\r\n";
		assertTrue((s).equals(outContent.toString()));
	}
	@Test
	public void testOneProblemSeven() {
		ProblemSevenBankCustomer.test01(out);
		System.out.println(outContent.toString());
		String s = "ProblemSevenBankCustomer [name=Antonio, balance=0.0, customerID=0]\r\n";
		assertTrue((s).equals(outContent.toString()));
	}
	@Test
	public void testOneProblemSix() {
		ProblemSix.test01(out);
		System.out.println(outContent.toString());
		String s = "Executed if\r\n" + 
				"Executed switch\r\n" + 
				"For loop executed 1 times\r\n" + 
				"For loop executed 2 times\r\n" + 
				"For loop executed 3 times\r\n" + 
				"Executed while loop\r\n" + 
				"do while loop executed\r\n" + 
				"Executed break statement\r\n" + 
				"Executed continue statement\r\n";
		assertTrue((s).equals(outContent.toString()));
	}
	@Test
	public void testOneProblemFive() {
		ProblemFiveMain.test01(out);
		System.out.println(outContent.toString());
		String s = "3.0\r\n" + 
				"-1.0\r\n" + 
				"2.0\r\n" + 
				"0.5\r\n";
		assertTrue((s).equals(outContent.toString()));
	}
	
	@Test
	public void testOneProblemFour() {
		ProblemFour.test01(out);
		System.out.println(outContent.toString());
		String s = "3.0\r\n" + 
				"-1.0\r\n" + 
				"2.0\r\n" + 
				"0.5\r\n";
		assertTrue((s).equals(outContent.toString()));
	}
	@Test
	public void testOneProblemThree() {
		Question3.test01(out);
		System.out.println(outContent.toString());
		String s = "false\r\n" + 
				   "true\r\n" + 
				   "true\r\n";
		assertTrue((s).equals(outContent.toString()));
	}
	@Test
	public void testOneProblemTwo() {
		assertTrue(Question2.maximum(5, 10, 20)==20);
	}
	
	@Test
	public void testOneProblemOne() {
		Question01.test01(out);
		System.out.println(outContent.toString());
		String s = "19\r\n" + 
					"2\r\n" + 
					"72\r\n" + 
					"1\r\n";
		assertTrue((s).equals(outContent.toString()));
	}

}
