package com.revature.db;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

import org.junit.Test;

import com.revature.models.Employee;
import com.revature.models.Manager;
import com.revature.models.ReinbursementRequest;

import junit.framework.TestCase;

public class TestDB extends TestCase {
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
