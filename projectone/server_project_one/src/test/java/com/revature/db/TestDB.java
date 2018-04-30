package com.revature.db;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.Test;

import com.revature.models.Employee;
import com.revature.models.Manager;
import com.revature.models.ReinbursementRequest;

import junit.framework.TestCase;

public class TestDB extends TestCase {
	
	@Test
    public void testReadReinbursementReceipt() throws SQLException  {
		Employee e = new Employee("Antonio", "Tapia", "antonio.tapia.maldonado@gmail.com", false);
		Manager m= new Manager("Antonio", "Tapia", "antonio.tapia.maldonado@gmail.com", false);
		ReinbursementRequest rr = new ReinbursementRequest(0, "image.jpeg", m, e, "Suchi with the boss", 400, (short) 0, false);
		//  create mock
		Connection testConnection = mock(Connection.class);
		PreparedStatement testStatement = mock(PreparedStatement.class);
		ResultSet rs = mock(ResultSet.class);
	    // define the whens
		when(rs.next()).thenReturn(true);
		when(rs.getString("image")).thenReturn(rr.getImageURL());
		when(rs.getString("handledBy")).thenReturn(rr.getHandledBy().getEmail());
		when(rs.getString("owner")).thenReturn(rr.getOwner().getEmail());
		when(rs.getString("description")).thenReturn(rr.getDescription());
		when(rs.getDouble("amount")).thenReturn(rr.getAmount());
		when(rs.getShort("status")).thenReturn(rr.getStatus());
		when(rs.getBoolean("isDeleted")).thenReturn(false);
		when(testStatement.executeQuery()).thenReturn(rs);
        when(testConnection.prepareStatement("SELECT * FROM reinbursementrequest WHERE RRId = ? AND isDeleted = 0")).thenReturn(testStatement);
        //setup the variables
        DatabaseSingletonImpl db = (DatabaseSingletonImpl) DatabaseSingletonImpl.getInstance();
        db.setCon(testConnection);
        boolean returnBool = db.readRR(rr.getId()).equals(rr);
        assertTrue(returnBool);
    }
	@Test
    public void testReadManager() throws SQLException  {
		Employee e = new Employee("Antonio", "Tapia", "antonio.tapia.maldonado@gmail.com", false);
		Manager m= new Manager("Antonio", "Tapia", "antonio.tapia.maldonado@gmail.com", false);
		ReinbursementRequest rr = new ReinbursementRequest(0, "image.jpeg", m, e, "Suchi with the boss", 400, (short) 0, false);
		//  create mock
		Connection testConnection = mock(Connection.class);
		PreparedStatement testStatement = mock(PreparedStatement.class);
		ResultSet rs = mock(ResultSet.class);
	    // define the whens
		when(rs.next()).thenReturn(true);
		when(rs.getString("fname")).thenReturn(m.getFname());
		when(rs.getString("lname")).thenReturn(m.getLname());
		when(rs.getString("email")).thenReturn(m.getEmail());
		when(rs.getBoolean("isDeleted")).thenReturn(false);
		when(testStatement.executeQuery()).thenReturn(rs);
        when(testConnection.prepareStatement("SELECT * FROM manager WHERE email = ? AND isDeleted = 0")).thenReturn(testStatement);
        //setup the variables
        DatabaseSingletonImpl db = (DatabaseSingletonImpl) DatabaseSingletonImpl.getInstance();
        db.setCon(testConnection);
        boolean returnBool = db.readManager(m.getEmail()).equals(m);
        assertTrue(returnBool);
    }
	@Test
    public void testReadEmployee() throws SQLException  {
		Employee e = new Employee("Antonio", "Tapia", "antonio.tapia.maldonado@gmail.com", false);
		Manager m= new Manager("Antonio", "Tapia", "antonio.tapia.maldonado@gmail.com", false);
		ReinbursementRequest rr = new ReinbursementRequest(0, "image.jpeg", m, e, "Suchi with the boss", 400, (short) 0, false);
		//  create mock
		Connection testConnection = mock(Connection.class);
		PreparedStatement testStatement = mock(PreparedStatement.class);
		ResultSet rs = mock(ResultSet.class);
	    // define the whens
		when(rs.next()).thenReturn(true);
		when(rs.getString("fname")).thenReturn(e.getFname());
		when(rs.getString("lname")).thenReturn(e.getLname());
		when(rs.getString("email")).thenReturn(e.getEmail());
		when(rs.getBoolean("isDeleted")).thenReturn(false);
		when(testStatement.executeQuery()).thenReturn(rs);
        when(testConnection.prepareStatement("SELECT * FROM employee WHERE email = ? AND isDeleted = 0")).thenReturn(testStatement);
        //setup the variables
        DatabaseSingletonImpl db = (DatabaseSingletonImpl) DatabaseSingletonImpl.getInstance();
        db.setCon(testConnection);
        boolean returnBool = db.readEmployee(e.getEmail()).equals(e);
        assertTrue(returnBool);
    }
	@Test
    public void testUpdateReinbursementRequest() throws SQLException  {
		//  create mock
		Connection testConnection = mock(Connection.class);
		CallableStatement testStatement = mock(CallableStatement.class);
	    // define the whens
		when(testStatement.executeUpdate()).thenReturn(1);
        when(testConnection.prepareCall("{CALL updateReinbursementRequest(?,?,?,?,?,?,?,?)}")).thenReturn(testStatement);
        //setup the variables
        DatabaseSingletonImpl db = (DatabaseSingletonImpl) DatabaseSingletonImpl.getInstance();
        db.setCon(testConnection);
        Employee e = new Employee("Antonio", "Tapia", "antonio.tapia.maldonado@gmail.com", false);
        Manager m= new Manager("Antonio", "Tapia", "antonio.tapia.maldonado@gmail.com", false);
        ReinbursementRequest rr = new ReinbursementRequest(0, "image.jpeg", m, e, "Suchi with the boss", 400, (short) 0, false);
        boolean returnBool = db.update(rr);
        assertTrue(returnBool);
    }
	@Test
    public void testUpdateManager() throws SQLException  {
		//  create mock
		Connection testConnection = mock(Connection.class);
		CallableStatement testStatement = mock(CallableStatement.class);
	    // define the whens
		when(testStatement.executeUpdate()).thenReturn(1);
        when(testConnection.prepareCall("{CALL updateManager(?,?,?,?,?)}")).thenReturn(testStatement);
        //setup the variables
        DatabaseSingletonImpl db = (DatabaseSingletonImpl) DatabaseSingletonImpl.getInstance();
        db.setCon(testConnection);
        Employee e = new Employee("Antonio", "Tapia", "antonio.tapia.maldonado@gmail.com", false);
        Manager m= new Manager("Antonio", "Tapia", "antonio.tapia.maldonado@gmail.com", false);
        ReinbursementRequest rr = new ReinbursementRequest(0, "image.jpeg", m, e, "Suchi with the boss", 400, (short) 0, false);
        boolean returnBool = db.update(m , "maria@revature.com");
        assertTrue(returnBool);
    }
	@Test
    public void testUpdateEmployee() throws SQLException  {
		//  create mock
		Connection testConnection = mock(Connection.class);
		CallableStatement testStatement = mock(CallableStatement.class);
	    // define the whens
		when(testStatement.executeUpdate()).thenReturn(1);
        when(testConnection.prepareCall("{CALL updateEmployee(?,?,?,?,?)}")).thenReturn(testStatement);
        //setup the variables
        DatabaseSingletonImpl db = (DatabaseSingletonImpl) DatabaseSingletonImpl.getInstance();
        db.setCon(testConnection);
        Employee e = new Employee("Antonio", "Tapia", "antonio.tapia.maldonado@gmail.com", false);
        Manager m= new Manager("Antonio", "Tapia", "antonio.tapia.maldonado@gmail.com", false);
        ReinbursementRequest rr = new ReinbursementRequest(0, "image.jpeg", m, e, "Suchi with the boss", 400, (short) 0, false);
        boolean returnBool = db.update(e, "maria@revature.com");
        assertTrue(returnBool);
    }
	@Test
    public void testCreateRR() throws SQLException  {
		//  create mock
		Connection testConnection = mock(Connection.class);
		CallableStatement testStatement = mock(CallableStatement.class);
	    // define the whens
		when(testStatement.executeUpdate()).thenReturn(1);
        when(testConnection.prepareCall("{CALL insertReinbursementRequest(?, ?, ?, ?, ?,?,?,?)}")).thenReturn(testStatement);
        //setup the variables
        DatabaseSingletonImpl db = (DatabaseSingletonImpl) DatabaseSingletonImpl.getInstance();
        db.setCon(testConnection);
        Employee e = new Employee("Antonio", "Tapia", "antonio.tapia.maldonado@gmail.com", false);
        Manager m= new Manager("Antonio", "Tapia", "antonio.tapia.maldonado@gmail.com", false);
        ReinbursementRequest rr = new ReinbursementRequest(0, "image.jpeg", m, e, "Suchi with the boss", 400, (short) 0, false);
        boolean returnBool = db.create(rr);
        assertTrue(returnBool);
    }
	@Test
    public void testCreateManager() throws SQLException  {
		//  create mock
		Connection testConnection = mock(Connection.class);
		CallableStatement testStatement = mock(CallableStatement.class);
	    // define the whens
		when(testStatement.executeUpdate()).thenReturn(1);
        when(testConnection.prepareCall("{CALL insertManager(?,?,?,?,?)}")).thenReturn(testStatement);
        //setup the variables
        DatabaseSingletonImpl db = (DatabaseSingletonImpl) DatabaseSingletonImpl.getInstance();
        db.setCon(testConnection);
        Manager m= new Manager("Antonio", "Tapia", "antonio.tapia.maldonado@gmail.com", false);
        boolean returnBool = db.create(m,"password");
        assertTrue(returnBool);
    }
	
	@Test
    public void testCreateEmployeeFalseWhenZero() throws SQLException  {
		//  create mock
		Connection testConnection = mock(Connection.class);
		CallableStatement testStatement = mock(CallableStatement.class);
	    // define return value for method getUniqueId()
		when(testStatement.executeUpdate()).thenReturn(0);
        when(testConnection.prepareCall("{CALL insertEmployee(?,?,?,?,?)}")).thenReturn(testStatement);
        DatabaseSingletonImpl db = (DatabaseSingletonImpl) DatabaseSingletonImpl.getInstance();
        db.setCon(testConnection);
        Employee e = new Employee("Antonio", "Tapia", "antonio.tapia.maldonado@gmail.com", false);
        boolean returnBool = db.create(e,"password");
        assertFalse(returnBool);
    }
	@Test
    public void testCreateEmployeeTrue() throws SQLException  {
		//  create mock
		Connection testConnection = mock(Connection.class);
		CallableStatement testStatement = mock(CallableStatement.class);
	    // define return value for method getUniqueId()
		when(testStatement.executeUpdate()).thenReturn(1);
        when(testConnection.prepareCall("{CALL insertEmployee(?,?,?,?,?)}")).thenReturn(testStatement);
        DatabaseSingletonImpl db = (DatabaseSingletonImpl) DatabaseSingletonImpl.getInstance();
        db.setCon(testConnection);
        Employee e = new Employee("Antonio", "Tapia", "antonio.tapia.maldonado@gmail.com", false);
        boolean returnBool = db.create(e,"password");
        assertTrue(returnBool);
    }
}
