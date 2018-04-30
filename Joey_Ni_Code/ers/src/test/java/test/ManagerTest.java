package test;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import app.ConnectionUtil;
import app.Service;
import employee.Employee;
import junit.framework.TestCase;
import manager.Manager;
import request.Request;
/**
 * Tests for Manager 
 * @author joeyi
 *
 */
public class ManagerTest extends TestCase{
	Connection con = null;
	Service serv = new Service();
	Manager m = new Manager(282, "DUMMY@REVATURE.COM","REVATURE","DUMMY","REVATURE");
	List<Request> newList =null;
	@BeforeClass
	public void setUp() throws Exception {
		con = ConnectionUtil.getConnection();
		
	//	con.setAutoCommit(false);
		
	}

	@After
	public void tearDown() throws Exception {
		con.close();
	}

	@Test
	public void testGetAllEmployee() {
		List<Employee> req = serv.getAllEmployees().stream().collect(Collectors.toList());
		assertEquals(req.size(),4);
	}
	
	@Ignore
	@Test
	public void testApRequest()
	{	//RID, MID, APPROVAL CODE
		serv.approveRequest(1, 282, 0);
		serv.getRequest(1);
		assertEquals(serv.getRequest(1).getStatus(),0);//DENY
		serv.approveRequest(1, 282, 1);
		assertEquals(serv.getRequest(1).getStatus(),1);
	}
	
	@Test
	public void testEmployeeRequest()
	{
		assertFalse(serv.submitRequest(12, "party", 100));
		//assertTrue(serv.submitRequest(12, "party", 135));
		assertNotNull(serv.getEmployeeRequests(135));
		assertNull(serv.getEmployeeRequests(100));
	}
	
	@Test
	public void testDeleteEmployee()
	{
		//serv.deleteEmployee(111);
		assertNull(serv.getEmployee(111));
	}
	
	@Ignore @Test
	public void testInsertManager()
	{
		//assertFalse(serv.insertManager("joey@gmail.com", "revature", "ni", "joey"));
	}
	
	@Test
	public void TestGetManager()
	{
		assertNull(serv.getManager(100));
		assertEquals(serv.getManager(282), m);
	}
	
	public void testCreateEmpLogin()
	{
		
	}
	
	@Test
	public void testGetAllPendingRequest()
	{
		assertEquals(serv.getAllPendingRequests().size(),4);
	}
	
	@Test
	public void testGetAllResolvedRequest()
	{
		assertEquals((serv.getAllResolvedRequests()).size(),1);
	}
	
	@Test
	public void testUpdateManager()
	{
		Manager newm = new Manager(282, "DUMMY2@REVATURE.COM","REVATURE2","DUMMY","REVATURE");
		serv.updateManager(282, "DUMMY2@REVATURE.COM","REVATURE2");
		assertEquals(serv.getManager(282), newm);
	}

}
