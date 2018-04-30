package com.revature.frontController;

import static org.junit.Assert.*;

import org.junit.Test;

public class DispatcherTest {

	@Test
	public void UnknownCommand() {
		FrontCommand fc = Dispatcher.getCommand(null);
		assertTrue(fc instanceof UnknownCommand);
	}
	@Test
	public void UnknownCommand2() {
		FrontCommand fc = Dispatcher.getCommand("");
		assertTrue(fc instanceof UnknownCommand);
	}
	@Test
	public void GetRequestReceipts() {
		FrontCommand fc = Dispatcher.getCommand("GetRequestReceipts");
		assertTrue(fc instanceof GetRequestReceipts);
	}
	@Test
	public void ProcessLoginPost() {
		FrontCommand fc = Dispatcher.getCommand("ProcessLoginPost");
		assertTrue(fc instanceof ProcessLoginPost);
	}
	@Test
	public void GetAllEmployees() {
		FrontCommand fc = Dispatcher.getCommand("GetAllEmployees");
		assertTrue(fc instanceof GetAllEmployees);
	}
	@Test
	public void LogOut() {
		FrontCommand fc = Dispatcher.getCommand("LogOut");
		assertTrue(fc instanceof LogOut);
	}
	@Test
	public void UploadReinbursementReceipt() {
		FrontCommand fc = Dispatcher.getCommand("UploadReinbursementReceipt");
		assertTrue(fc instanceof UploadReinbursementReceipt);
	}
	@Test
	public void UploadEmployee() {
		FrontCommand fc = Dispatcher.getCommand("UploadEmployee");
		assertTrue(fc instanceof UploadEmployee);
	}
	@Test
	public void UpdateReinbursementReceipt() {
		FrontCommand fc = Dispatcher.getCommand("UpdateReinbursementReceipt");
		assertTrue(fc instanceof UpdateReinbursementReceipt);
	}
	@Test
	public void SearchCommand() {
		FrontCommand fc = Dispatcher.getCommand("SearchCommand");
		assertTrue(fc instanceof SearchCommand);
	}
	
	

}
