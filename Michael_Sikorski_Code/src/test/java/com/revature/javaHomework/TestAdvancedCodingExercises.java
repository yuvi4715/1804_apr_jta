/*
 *  Author: Michael Sikorski
 *  Date: 4/6/18
 *  
 *  Test Class for questions in the "Advanced Coding Exercises" section of the Java homework
 */

package com.revature.javaHomework;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import advanced_coding_exercises.*;

import static java.lang.System.out;

import java.util.Calendar;

public class TestAdvancedCodingExercises {

	@Before
	public void setUp() throws Exception {

	}

	@After
	public void tearDown() throws Exception {
	}
	
	
	
	
	@Test
	public void testQuestion38() {
		Question38 q = new Question38();
		Assert.assertEquals("123", q.replaceCharacter("153", '5', '2'));
		Assert.assertEquals("153", q.replaceCharacter("123", '2', '5'));
		Assert.assertEquals("0", q.replaceCharacter("5", '5', '0'));
		Assert.assertEquals("01", q.replaceCharacter("02", '2', '1'));
	}
	
	@Test
	public void testQuestion39() {
		Question39 q = new Question39();
		Calendar c1 = new Calendar.Builder().setCalendarType("iso8601").setDate(2013,2,3).build();
		Calendar c2 = new Calendar.Builder().setCalendarType("iso8601").setDate(2010, 4, 1).build();
		Calendar c3 = new Calendar.Builder().setCalendarType("iso8601").setDate(2000, 5, 5).build();
		Assert.assertEquals(5, q.getAge(c1), 0);
		Assert.assertEquals(8, q.getAge(c2),0);
		Assert.assertEquals(17, q.getAge(c3),0);
	}
	
	@Test
	public void testQuestion40() {
		Question40 q = new Question40(100);
		String expected = "1 1 2 3 5 8 13 21 34 55 89 144 233 377 610 987 1597 2584 4181 6765 10946 17711 28657 46368 75025 121393 196418 317811 514229 832040 1346269 2178309 3524578 5702887 9227465 14930352 24157817 39088169 63245986 102334155 165580141 267914296 433494437 701408733 1134903170 1836311903 2971215073 4807526976 7778742049 12586269025 20365011074 32951280099 53316291173 86267571272 139583862445 225851433717 365435296162 591286729879 956722026041 1548008755920 2504730781961 4052739537881 6557470319842 10610209857723 17167680177565 27777890035288 44945570212853 72723460248141 117669030460994 190392490709135 308061521170129 498454011879264 806515533049393 1304969544928657 2111485077978050 3416454622906707 5527939700884757 8944394323791464 14472334024676221 23416728348467685 37889062373143906 61305790721611591 99194853094755497 160500643816367088 259695496911122585 420196140727489673 679891637638612258 1100087778366101931 1779979416004714189 2880067194370816120 4660046610375530309 7540113804746346429 12200160415121876738 19740274219868223167 31940434634990099905 51680708854858323072 83621143489848422977 135301852344706746049 218922995834555169026 354224848179261915075 ";
		Assert.assertEquals(expected, q.fibonacciIterative(100));
		Assert.assertEquals(expected, q.fibRecHelper(100));
	}
	
	@Test
	public void testQuestion41() {
		out.println("The following line should print out FizzBuzz from 1-50");
		new Question41().FizzBuzz();
	}
	
	@Test
	public void testQuestion42() {
		Question42 q = new Question42();
	}
	
	@Test
	public void testQuestion43() {
//		Armstrong numbers: 0-9, 153, 370, 371, 407
		Question43 q = new Question43();
		Assert.assertTrue(q.isArmstrong(0));
		Assert.assertTrue(q.isArmstrong(1));
		Assert.assertTrue(q.isArmstrong(2));
		Assert.assertFalse(q.isArmstrong(22));
		Assert.assertTrue(q.isArmstrong(153));
		Assert.assertFalse(q.isArmstrong(154));
	}
	
	@Test
	public void testQuestion44() {
		Question44 q = new Question44();
		Assert.assertEquals("tset", q.reverseString("test"));
		Assert.assertEquals("321", q.reverseString("123"));
		Assert.assertEquals("racecar", q.reverseString("racecar"));
	}
	
	@Test
	public void testQuestion45() {
		Question45 q = new Question45();
		Assert.assertTrue(q.isPrime(1));
		Assert.assertFalse(q.isPrime(6));
		Assert.assertTrue(q.isPrime(7));
		Assert.assertFalse(q.isPrime(8));
		Assert.assertTrue(q.isPrime(11));
		Assert.assertTrue(q.isPrime(5));
	}

}
