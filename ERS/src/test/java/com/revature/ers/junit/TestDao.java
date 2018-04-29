package com.revature.ers.junit;

import static org.junit.Assert.assertTrue;

import java.sql.Date;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import com.revature.ers.dao.ERSDAO;
import com.revature.ers.dao.ERSDAOImpl;
import com.revature.ers.model.ERS_User;
import com.revature.ers.model.Request;
import com.revature.ers.service.ERS_Service;

public class TestDao {

	@Ignore
	public void testInsert_user() {
		ERS_User user = new ERS_User(0, "pass1", "JUnit", "Test", "JUnit@test.com", 0);
		ERSDAO dao = ERSDAOImpl.getERSDAOImpl();
		assertTrue("Insert of user is: ", dao.insert_user(user));
	}

	@Ignore
	public void testInsert_request() {
		Request request = new Request(0,101,0,10.0,"JUnit testing, and somehow spent $10", 
				"PENDING", new Date(1L), new Date(1L));
		ERSDAO dao = ERSDAOImpl.getERSDAOImpl();
		assertTrue("Insert of request is: ", dao.insert_request(request));
	}

	@Ignore
	public void testModify_request() {
		ERS_User user = new ERS_User(102, "pass1", "JUnit", "Test", "JUnit@test.com", 1);
		Request request = new Request(105,101,0,10.0,"JUnit testing, and somehow spent $5", 
				"DENIED", new Date(1L), new Date(1L));
		ERSDAO dao = ERSDAOImpl.getERSDAOImpl();
		assertTrue("Insert of request is: ", dao.modify_request(request, user));
	}

	@Ignore
	public void testModify_user() {
		ERS_User user = new ERS_User(105, "JUnitpass1", "testJunitModified", "User", "JUnitModUser@test.com", 0);
		ERSDAO dao = ERSDAOImpl.getERSDAOImpl();
		assertTrue("Insert of user is: ", dao.modify_user(user));
	}
	@Ignore
	public void testEmp_view_certain_requests() {
		ERSDAO dao = ERSDAOImpl.getERSDAOImpl();
		List<Request> requestList = dao.emp_view_certain_requests(new ERS_User(101, "JUnitpass1", 
					"testJunitModified", "User", "JUnitModUser@test.com", 0), "PENDING");
		boolean test = false;
		if(requestList == null) {
			test = false;
		}
		else if (requestList.iterator().hasNext())
			test = true;
		for (Request requests : requestList) {
			System.out.println(requests.toString());
		}
		assertTrue("Check if boolean is true: ", test);
	}

	@Ignore
	public void testMan_view_all_requests() {
		ERSDAO dao = ERSDAOImpl.getERSDAOImpl();
		List<Request> requestList = dao.man_view_all_requests();
		boolean test = false;
		if(requestList == null) {
			test = false;
		}
		else if (requestList.iterator().hasNext())
			test = true;
		for (Request requests : requestList) {
			System.out.println(requests.toString());
		}
		assertTrue("Check if boolean is true: ", test);
	}

	@Ignore
	public void testMan_view_certain_requests() {
		ERSDAO dao = ERSDAOImpl.getERSDAOImpl();
		List<Request> requestList = dao.man_view_certain_requests("PENDING");
		boolean test = false;
		if(requestList == null) {
			test = false;
		}
		else if (requestList.iterator().hasNext())
			test = true;
		for (Request requests : requestList) {
			System.out.println(requests.toString());
		}
		assertTrue("Check if boolean is true: ", test);
	}

	@Ignore
	public void testMan_view_emp_requests() {
		ERSDAO dao = ERSDAOImpl.getERSDAOImpl();
		List<Request> requestList = dao.man_view_emp_requests(101);
		boolean test = false;
		if(requestList == null) {
			test = false;
		}
		else if (requestList.iterator().hasNext())
			test = true;
		for (Request requests : requestList) {
			System.out.println(requests.toString());
		}
		assertTrue("Check if boolean is true: ", test);
	}

	@Ignore
	public void testGetUser(){
		ERS_Service serv = ERS_Service.getERS_Service();
		ERS_User user = serv.getUser("user1@ERS.com", "pass1");
		if(user != null){
			System.out.println(user.toString());
			assertTrue(true);
		}
		else {
			System.out.println("user is null.");
			assertTrue(false);
		}
		
	}

	@Ignore
	public void testGetAllUsers(){
		List<ERS_User> userlist = ERS_Service.getERS_Service().getAllUsers();
		boolean test = false;
		if (userlist != null){
			test = true;
		}
		for (ERS_User user : userlist){
			System.out.println(user.toString());
		}
		assertTrue(test);
	}
}
