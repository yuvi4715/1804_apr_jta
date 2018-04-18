package com.revature.Homework;

import static org.junit.Assert.assertTrue;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
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
	@Test
	public void testOneProblemFiftythree() {
		int[] a= {
				1,
				2,
				3,
				3
		};
		com.revature.Homework.ProblemFiftyThree.Main.test01(out,a);
		System.out.println(outContent.toString());
		String s = "Has Duplicate\r\n";
		assertTrue((s).equals(outContent.toString()));
	}
	@Test
	public void testOneProblemFiftyTwo() {
		ByteArrayInputStream in = new ByteArrayInputStream((
				"127\r\n"
			).getBytes());
		System.setIn(in);
		com.revature.Homework.ProblemFiftyTwo.Main.test01(out);
		System.out.println(outContent.toString());
		String s = "Enter Number:\r\n" +
				"721\r\n";
		assertTrue((s).equals(outContent.toString()));
	}
	@Test
	public void testOneProblemFourtyeighth() {
		ByteArrayInputStream in = new ByteArrayInputStream((
				"4\r\n"
			).getBytes());
		System.setIn(in);
		com.revature.Homework.ProblemFourtyEight.Main.test01(out);
		System.out.println(outContent.toString());
		String s = "Enter a number:\r\n"+ 
				"24\r\n";
		assertTrue((s).equals(outContent.toString()));
	}
	@Test
	public void testOneProblemFourtyseven() {
		com.revature.Homework.ProblemFourtySeven.Main.test01(out);
		System.out.println(outContent.toString());
		String s = "4\r\n";
		assertTrue((s).equals(outContent.toString()));
	}
	@Test
	public void testOneProblemFourtysix() {
		com.revature.Homework.ProblemFourtySix.Main.test01(out);
		System.out.println(outContent.toString());
		String s = "9 10\r\n" + 
				"10 9\r\n" ;
		assertTrue((s).equals(outContent.toString()));
	}
	@Test
	public void testOneProblemFourtyfive() {
		ByteArrayInputStream in = new ByteArrayInputStream((
				"13\r\n"  
			).getBytes());
		System.setIn(in);
		com.revature.Homework.ProblemFourtyFive.Main.test01(out);
		System.out.println(outContent.toString());
		String s = "Enter Number:\r\n"+ 
				"Is Prime\r\n";
		assertTrue((s).equals(outContent.toString()));
	}
	@Test
	public void testOneProblemFourtyfour() {
		ByteArrayInputStream in = new ByteArrayInputStream((
			"anna\r\n" 
			).getBytes());
		System.setIn(in);
		com.revature.Homework.ProblemFourtyFour.Main.test01(out);
		System.out.println(outContent.toString());
		String s = "Enter String:\r\n" + 
				"anna\r\n";
		assertTrue((s).equals(outContent.toString()));
	}
	@Test
	public void testOneProblemFourtythree() {
		ByteArrayInputStream in = new ByteArrayInputStream((
			"371\r\n" 
			).getBytes());
		System.setIn(in);
		com.revature.Homework.ProblemFourtyThree.Main.test01(out);
		System.out.println(outContent.toString());
		String s = "Enter number: \r\n" +
				"Is an Armstrong Number\r\n";
		assertTrue((s).equals(outContent.toString()));
	}
	@Test
	public void testOneProblemFourtytwo() {
		//TODO
	}
	@Test
	public void testOneProblemFourtyone() {
		com.revature.Homework.ProblemFourtyOne.Main.test01(out);
		System.out.println(outContent.toString());
		String s = "1\r\n" + 
				"2\r\n" + 
				"Fizz\r\n" + 
				"4\r\n" + 
				"Buzz\r\n" + 
				"Fizz\r\n" + 
				"7\r\n" + 
				"8\r\n" + 
				"Fizz\r\n" + 
				"Buzz\r\n" + 
				"11\r\n" + 
				"Fizz\r\n" + 
				"13\r\n" + 
				"14\r\n" + 
				"FizzBuzz\r\n" + 
				"16\r\n" + 
				"17\r\n" + 
				"Fizz\r\n" + 
				"19\r\n" + 
				"Buzz\r\n" + 
				"Fizz\r\n" + 
				"22\r\n" + 
				"23\r\n" + 
				"Fizz\r\n" + 
				"Buzz\r\n" + 
				"26\r\n" + 
				"Fizz\r\n" + 
				"28\r\n" + 
				"29\r\n" + 
				"FizzBuzz\r\n" + 
				"31\r\n" + 
				"32\r\n" + 
				"Fizz\r\n" + 
				"34\r\n" + 
				"Buzz\r\n" + 
				"Fizz\r\n" + 
				"37\r\n" + 
				"38\r\n" + 
				"Fizz\r\n" + 
				"Buzz\r\n" + 
				"41\r\n" + 
				"Fizz\r\n" + 
				"43\r\n" + 
				"44\r\n" + 
				"FizzBuzz\r\n" + 
				"46\r\n" + 
				"47\r\n" + 
				"Fizz\r\n" + 
				"49\r\n" + 
				"Buzz\r\n" ;
		assertTrue((s).equals(outContent.toString()));
	}
	@Test
	@Ignore
	public void testOneProblemFourty() {
		com.revature.Homework.ProblemFourty.Main.test01(out);
		System.out.println(outContent.toString());
		String s = "Iterative\r\n" + 
				"2\r\n" + 
				"3\r\n" + 
				"5\r\n" + 
				"8\r\n" + 
				"13\r\n" + 
				"21\r\n" + 
				"34\r\n" + 
				"55\r\n" + 
				"89\r\n" + 
				"144\r\n" + 
				"233\r\n" + 
				"377\r\n" + 
				"610\r\n" + 
				"987\r\n" + 
				"1597\r\n" + 
				"2584\r\n" + 
				"4181\r\n" + 
				"6765\r\n" + 
				"10946\r\n" + 
				"17711\r\n" + 
				"28657\r\n" + 
				"46368\r\n" + 
				"75025\r\n" + 
				"121393\r\n" + 
				"196418\r\n" + 
				"317811\r\n" + 
				"514229\r\n" + 
				"832040\r\n" + 
				"1346269\r\n" + 
				"2178309\r\n" + 
				"3524578\r\n" + 
				"5702887\r\n" + 
				"9227465\r\n" + 
				"14930352\r\n" + 
				"24157817\r\n" + 
				"39088169\r\n" + 
				"63245986\r\n" + 
				"102334155\r\n" + 
				"165580141\r\n" + 
				"267914296\r\n" + 
				"433494437\r\n" + 
				"701408733\r\n" + 
				"1134903170\r\n" + 
				"1836311903\r\n" + 
				"2971215073\r\n" + 
				"4807526976\r\n" + 
				"7778742049\r\n" + 
				"12586269025\r\n" + 
				"20365011074\r\n" + 
				"32951280099\r\n" + 
				"53316291173\r\n" + 
				"86267571272\r\n" + 
				"139583862445\r\n" + 
				"225851433717\r\n" + 
				"365435296162\r\n" + 
				"591286729879\r\n" + 
				"956722026041\r\n" + 
				"1548008755920\r\n" + 
				"2504730781961\r\n" + 
				"4052739537881\r\n" + 
				"6557470319842\r\n" + 
				"10610209857723\r\n" + 
				"17167680177565\r\n" + 
				"27777890035288\r\n" + 
				"44945570212853\r\n" + 
				"72723460248141\r\n" + 
				"117669030460994\r\n" + 
				"190392490709135\r\n" + 
				"308061521170129\r\n" + 
				"498454011879264\r\n" + 
				"806515533049393\r\n" + 
				"1304969544928657\r\n" + 
				"2111485077978050\r\n" + 
				"3416454622906707\r\n" + 
				"5527939700884757\r\n" + 
				"8944394323791464\r\n" + 
				"14472334024676221\r\n" + 
				"23416728348467685\r\n" + 
				"37889062373143906\r\n" + 
				"61305790721611591\r\n" + 
				"99194853094755497\r\n" + 
				"160500643816367088\r\n" + 
				"259695496911122585\r\n" + 
				"420196140727489673\r\n" + 
				"679891637638612258\r\n" + 
				"1100087778366101931\r\n" + 
				"1779979416004714189\r\n" + 
				"2880067194370816120\r\n" + 
				"4660046610375530309\r\n" + 
				"7540113804746346429\r\n" + 
				"12200160415121876738\r\n" + 
				"19740274219868223167\r\n" + 
				"31940434634990099905\r\n" + 
				"51680708854858323072\r\n" + 
				"83621143489848422977\r\n" + 
				"135301852344706746049\r\n" + 
				"218922995834555169026\r\n" + 
				"354224848179261915075\r\n" + 
				"Recursive\r\n"+
				"2\r\n" + 
				"3\r\n" + 
				"5\r\n" + 
				"8\r\n" + 
				"13\r\n" + 
				"21\r\n" + 
				"34\r\n" + 
				"55\r\n" + 
				"89\r\n" + 
				"144\r\n" + 
				"233\r\n" + 
				"377\r\n" + 
				"610\r\n" + 
				"987\r\n" + 
				"1597\r\n" + 
				"2584\r\n" + 
				"4181\r\n" + 
				"6765\r\n" + 
				"10946\r\n" + 
				"17711\r\n" + 
				"28657\r\n" + 
				"46368\r\n" + 
				"75025\r\n" + 
				"121393\r\n" + 
				"196418\r\n" + 
				"317811\r\n" + 
				"514229\r\n" + 
				"832040\r\n" + 
				"1346269\r\n" + 
				"2178309\r\n" + 
				"3524578\r\n" + 
				"5702887\r\n" + 
				"9227465\r\n" + 
				"14930352\r\n" + 
				"24157817\r\n" + 
				"39088169\r\n" + 
				"63245986\r\n" + 
				"102334155\r\n" + 
				"165580141\r\n" + 
				"267914296\r\n" + 
				"433494437\r\n" + 
				"701408733\r\n" + 
				"1134903170\r\n" + 
				"1836311903\r\n" + 
				"2971215073\r\n" + 
				"4807526976\r\n" + 
				"7778742049\r\n" + 
				"12586269025\r\n" + 
				"20365011074\r\n" + 
				"32951280099\r\n" + 
				"53316291173\r\n" + 
				"86267571272\r\n" + 
				"139583862445\r\n" + 
				"225851433717\r\n" + 
				"365435296162\r\n" + 
				"591286729879\r\n" + 
				"956722026041\r\n" + 
				"1548008755920\r\n" + 
				"2504730781961\r\n" + 
				"4052739537881\r\n" + 
				"6557470319842\r\n" + 
				"10610209857723\r\n" + 
				"17167680177565\r\n" + 
				"27777890035288\r\n" + 
				"44945570212853\r\n" + 
				"72723460248141\r\n" + 
				"117669030460994\r\n" + 
				"190392490709135\r\n" + 
				"308061521170129\r\n" + 
				"498454011879264\r\n" + 
				"806515533049393\r\n" + 
				"1304969544928657\r\n" + 
				"2111485077978050\r\n" + 
				"3416454622906707\r\n" + 
				"5527939700884757\r\n" + 
				"8944394323791464\r\n" + 
				"14472334024676221\r\n" + 
				"23416728348467685\r\n" + 
				"37889062373143906\r\n" + 
				"61305790721611591\r\n" + 
				"99194853094755497\r\n" + 
				"160500643816367088\r\n" + 
				"259695496911122585\r\n" + 
				"420196140727489673\r\n" + 
				"679891637638612258\r\n" + 
				"1100087778366101931\r\n" + 
				"1779979416004714189\r\n" + 
				"2880067194370816120\r\n" + 
				"4660046610375530309\r\n" + 
				"7540113804746346429\r\n" + 
				"12200160415121876738\r\n" + 
				"19740274219868223167\r\n" + 
				"31940434634990099905\r\n" + 
				"51680708854858323072\r\n" + 
				"83621143489848422977\r\n" + 
				"135301852344706746049\r\n" + 
				"218922995834555169026\r\n" + 
				"354224848179261915075\r\n" ;
		assertTrue((s).equals(outContent.toString()));
	}
	@Test
	public void testOneProblemThirtynine() {
		ByteArrayInputStream in = new ByteArrayInputStream((
				"1991\r\n" +
				"08\r\n" +
				"24\r\n" 
				).getBytes());
		System.setIn(in);
		com.revature.Homework.ProblemThirtyNine.Main.test01(out);
		System.out.println(outContent.toString());
		String s = "Please Enter Year: \r\n"+
				"Please Enter Month: \r\n" +
				"Please Enter Day: \r\n" +
				"27\r\n";
		assertTrue((s).equals(outContent.toString()));
	}
	@Test
	public void testOneProblemThirtyeight() {
		com.revature.Homework.ProblemThirtyEight.Main.test01(out);
		System.out.println(outContent.toString());
		String s = "Terry\r\n" + 
				   "JerTy\r\n" ;
		assertTrue((s).equals(outContent.toString()));
	}
	@Test
	public void testOneProblemThirtyseven() {
		ByteArrayInputStream in = new ByteArrayInputStream((
				"45\r\n" +
				"45\r\n" +
				"45\r\n" +
				"s\r\n" 
				).getBytes());
		System.setIn(in);
		com.revature.Homework.ProblemThirtySeven.Main.test01(out);
		System.out.println(outContent.toString());
		String s = "Enter Number\r\n" +
				"Enter Number\r\n" +
				"Enter Number\r\n" +
				"Enter Number\r\n" +
				"Minimum = 45.0 Maximum = 45.0, Mean = 45.0, Standard Deviation = 68.7386354243376\r\n";
		assertTrue((s).equals(outContent.toString()));
	}
	@Test
	public void testOneProblemThirtysix() {
		String[] a = {
				"1.0",
				"34.56",
				"+"
		};
		com.revature.Homework.ProblemThirtySix.Main.test01(out,a);
		System.out.println(outContent.toString());
		String s = "35.56\r\n";
		assertTrue((s).equals(outContent.toString()));
	}
	@Test
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
		//TODO
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
