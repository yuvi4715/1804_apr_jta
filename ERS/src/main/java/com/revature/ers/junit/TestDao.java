package com.revature.ers.junit;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.sql.Date;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import com.revature.ers.dao.ERSDAO;
import com.revature.ers.dao.ERSDAOImpl;
import com.revature.ers.model.ERS_User;
import com.revature.ers.model.Request;

public class TestDao {

	@Ignore
	public void testInsert_user() {
		ERS_User user = new ERS_User(0, "pass1", "JUnit", "Test", "JUnit@test.com", 0);
		ERSDAO dao = new ERSDAOImpl();
		assertTrue("Insert of user is: ", dao.insert_user(user));
	}

	@Ignore
	public void testInsert_request() {
		Request request = new Request(0,101,0,10.0,"JUnit testing, and somehow spent $10", 
				"PENDING", new Date(1L), new Date(1L));
		ERSDAO dao = new ERSDAOImpl();
		assertTrue("Insert of request is: ", dao.insert_request(request));
	}

	@Ignore
	public void testModify_request() {
		Request request = new Request(105,101,0,10.0,"JUnit testing, and somehow spent $10", 
				"DENIED", new Date(1L), new Date(1L));
		ERSDAO dao = new ERSDAOImpl();
		assertTrue("Insert of request is: ", dao.modify_request(request));
	}

	@Ignore
	public void testModify_user() {
		ERS_User user = new ERS_User(105, "JUnitpass1", "testJunitModified", "User", "JUnitModUser@test.com", 0);
		ERSDAO dao = new ERSDAOImpl();
		assertTrue("Insert of user is: ", dao.modify_user(user));
	}
	@Ignore
	public void testEmp_view_certain_requests() {
		ERSDAO dao = new ERSDAOImpl();
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
		ERSDAO dao = new ERSDAOImpl();
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
		ERSDAO dao = new ERSDAOImpl();
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

	@Test
	public void testMan_view_emp_requests() {
		ERSDAO dao = new ERSDAOImpl();
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

}
