package com.revature.javaHomework;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;
import syntax.*;

public class TestSyntax {

	@Test
	public void testQuestion4() {
		Question4 q = new Question4();
		Assert.assertEquals(10, q.Add(6, 4));
		Assert.assertEquals(10, q.Subtract(15, 5));
		Assert.assertEquals(10, q.Multiply(5, 2));
		Assert.assertEquals(10, q.Divide(30, 3));		
	}
	
	@Test
	public void testQuestion5() {
		String[] args = {};
		Question5_2.main(args);
	}
	
	@Test
	public void testQuestion6() {
		Question6 q = new Question6();
		Assert.assertEquals("This is an if statement", q.ifStatement());
		Assert.assertEquals("This is a switch statement", q.switchStatement("switch"));
		Assert.assertEquals("This is a for loop ", q.forLoop());
		Assert.assertEquals("This is a while loop ", q.whileLoop());
		Assert.assertEquals("This is a do while loop", q.doWhileLoop());
	}

}
