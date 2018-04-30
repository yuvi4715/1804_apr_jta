package app;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import dev.Log;
import employee.Employee;
import employee.EmployeeDAO;
import employee.EmployeeImpl;
import manager.Manager;
import manager.ManagerDAO;
import manager.ManagerImpl;
import request.Request;
import request.RequestDAO;
import request.RequestImpl;

public class Service
{
	static EmployeeDAO em = EmployeeImpl.getInstance();
	static ManagerDAO ma = ManagerImpl.getInstance();
	static RequestDAO req = RequestImpl.getInstance();
	
	public static Request getRequest(int rid)
	{
		return ma.getRequest(rid);
	}
	public static boolean approveRequest(int rid, int mid, int ap) {
		return ma.approveRequest(rid, mid, ap);
	}

	public static void getImg(int rid) {
		ma.getImg(rid);
		
	}

	public static List<Employee> getAllEmployees() {
		return ma.getAllEmployees();
		
	}

	public static Object login(String username, String password) 
	{		
		Properties props =new Properties();
		try(OutputStream out=new FileOutputStream("C:\\Users\\joeyi\\spring-workspace\\ers\\src\\main\\resources\\userdb.properties")) 
		{
			props.setProperty("username", username);
			props.setProperty("password", password);
			props.store(out, null);
		}catch (FileNotFoundException e) {
			Log.debug(e.getMessage());
		} catch (IOException e) {
			Log.debug(e.getMessage());
		}
		
		try {
			ConnectionUtil.getConnection();
			System.out.println(username);
			int id=getId(username);
			return (id>0 && id%2==0) ? ma.getManager(id) : em.getEmployee(id);
		} catch (SQLException | IOException e) {
			Log.debug("Login "+e.getMessage());
			return null;
		}
	}

	public static boolean logout() {
		Properties props =new Properties();
		try(OutputStream out=new FileOutputStream("C:\\Users\\joeyi\\spring-workspace\\ers\\src\\main\\resources\\userdb.properties")) 
		{
			props.setProperty("username", null);
			props.setProperty("password", null);
			props.store(out, null);
			ConnectionUtil.getConnection().close();
		}catch (FileNotFoundException e) {
			Log.debug("logout: "+e.getMessage());
			return false;
		} catch (IOException e) {
			Log.debug("logout: "+e.getMessage());
			return false;
		} catch (SQLException e) {
			Log.debug("logout: "+e.getMessage());
		}
		
		return true;
	}

	public static Manager getManager(int mid) {
		return ma.getManager(mid);
	}

	public static Manager updateManager(int mid, String username, String password) 
	{
		
		return ma.updateManager(mid, username, password);
	}
	

	public static Employee getEmployee(int eid) {
		return em.getEmployee(eid);
	}
	
	public static Employee updateEmployee(int eid,  String username, String password) {
		em.updateEmployee(eid, username, password);
		ma.deleteUser(username);
		ma.createUser(username, password);
		ma.grantEmployee(username);
		return em.getEmployee(eid);
	}

	public static List<Request> getAllPendingRequests() {
		return ma.getAllPendingRequests();
	}

	public static List<Request> getAllResolvedRequests() {
		return ma.getAllResolvedRequests();
	}
	
	public static List<Request> getAllRequests(){
		List<Request> result = new ArrayList<>(getAllPendingRequests());
		result.addAll(getAllResolvedRequests());
		return result;
	}
	public static List<Request> getEmployeeRequests(int eid) {
		return ma.getEmployeeRequests(eid);
	}
	
	public static List<Request> getPendingRequests(int eid) {
		return em.getPendingRequests(eid);
		
	}
	
	public static List<Request> getResolvedRequests(int eid) {
		return em.getResolvedRequests(eid);
	}
	
	public static boolean submitRequest(float amount, String purpose, int eid) {
		return em.submitRequest(amount, purpose, eid);
		
	}

	public static void uploadImg(int rid) {
		em.uploadImg(rid);
	}
	
	
	public static boolean insertManager(String username, String password, String lastname, String firstname)
	{
		return ma.insertManager(username, password, lastname, firstname);
	}
	
	
	public static boolean insertEmployee(String username, String password, String lastname, String firstname)
	{
		ma.createUser(username, password);
		ma.grantEmployee(username);
		return ma.insertEmployee(username, password, lastname, firstname);
	}
	
	public static boolean deleteEmployee(int eid)
	{
		ma.deleteUser(ma.getEmployee(eid).getUsername());
		return ma.deleteEmployee(eid);
	}
	//table not found error
	public static int getId(String username)
	{
		int e= em.getId(username);
		int m= ma.getId(username);
	    return e>-1? e: m;
	}
}
