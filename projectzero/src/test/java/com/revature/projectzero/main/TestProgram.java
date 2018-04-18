package com.revature.projectzero.main;

import static org.junit.Assert.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.revature.projectzero.accounts.Account;
import com.revature.projectzero.accounts.User;
import com.revature.projectzero.db.DatabaseSingleton;
import com.revature.projectzero.db.MockDB;

public class TestProgram {

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
	public void test04() {
		//SETUP INPUT
		ByteArrayInputStream in = new ByteArrayInputStream((
				"useraccount\r\n" +
				"Apo\r\n" +
				"Apo45ty\r\n" + 
				"Antonio\r\n" +
				"Tapia\r\n" +
				"ATapia\r\n" 
		).getBytes());
		System.setIn(in);
		//SETUP MOCK DB
		com.revature.projectzero.service.BankService.setDb(new MockDB());
		//CAPTURE OUTPUT IN OUT VARIABLE
		(new CreateAccountBehavior()).execute(out);
		System.out.println(outContent.toString());
		System.out.println("*******String*******");
		//Test STRING
		String s = "Please enter the type of account you wish to create\r\n" + 
				"enter \"useraccount(ua)\" to create a user account\r\n" + 
				"enter \"adminaccount(aa)\" to create a admin account\r\n" + 
				"enter \"quit(q)\" to go back to the main menu\r\n" + 
				"\r\n" + 
				"Enter username:\r\n" + 
				"User name taken please pick another!\r\n" + 
				"Enter username:\r\n" + 
				"Username not taken!\r\n" + 
				"Enter Name:\r\n" + 
				"Enter Last Name:\r\n" + 
				"Enter Password:\r\n" + 
				"Account Creation Successful\r\n"  ;
		System.out.println(s);
		assertTrue(s.equals(outContent.toString()));
	}
	@Test
	public void test03() {
		ByteArrayInputStream in = new ByteArrayInputStream((
		"quit\r\n").getBytes());
		System.setIn(in);
		(new MainMenuBehavior()).execute(out);
		System.out.println(outContent.toString());
		assertTrue(com.revature.projectzero.main.Program.isDone());
	}
	@Test
	public void test02() {
		ByteArrayInputStream in = new ByteArrayInputStream((
		"createaccount\r\n").getBytes());
		System.setIn(in);
		(new MainMenuBehavior()).execute(out);
		System.out.println(outContent.toString());
		assertTrue(com.revature.projectzero.main.Program.getState()==ProgramState.createAccountLoop);
	}
	
	@Test
	public void test01() {
		ByteArrayInputStream in = new ByteArrayInputStream((
		"login\r\n").getBytes());
		System.setIn(in);
		(new MainMenuBehavior()).execute(out);
		System.out.println(outContent.toString());
		assertTrue(com.revature.projectzero.main.Program.getState()==ProgramState.userLoginLoop);
	}

}
