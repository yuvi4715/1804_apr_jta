package com.revature.javaHomework;

import static org.junit.Assert.*;
import exceptions.*;

import org.junit.Test;

public class TestExceptions {

	@Test
	public void testQuestion10() {
		_Exceptions.Question10();
	}
	
	@Test
	public void testQuestion11() {
		_Exceptions.Question11();
	}
	
	@Test
	public void testQuestion12() {
		_Exceptions.Question12();
	}
	
	@Test
	public void testQuestion13() {
		try {
			_Exceptions.Question13();
		} catch (Exception e) {
			System.out.println("The exception in Question 13 has been caught");
			System.out.println();
		}
		
	}
	
	@Test
	public void testQuestion14() {
		_Exceptions.Question14();
	}
	
	@Test
	public void testQuestion15() {
		_Exceptions.Question15();
	}

}
