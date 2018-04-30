package app;

import static org.hamcrest.CoreMatchers.instanceOf;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Properties;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import dev.Log;

public class RequestHelper {
	
	
	public static Object process(HttpServletRequest req)
	{
		String username="hello@world.com";
		String password="12345678";
		try(FileInputStream in2= 
				new FileInputStream("C:\\Users\\joeyi\\spring-workspace\\ers\\src\\main\\resources\\userdb.properties"))
		{ Properties props= new Properties();
			props.load(in2);
			username = props.getProperty("username");
			password = props.getProperty("password");
			System.out.println(username);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		HttpSession session=req.getSession();
		//int auth=Integer.parseInt(session.getAttribute("auth").toString());
		switch(req.getRequestURI())
		{
			case "/ers/login.do":
				return loginController.loginSession(req);
			case "/ers/logout.do":
				req.getSession(true).invalidate();
				return "/html/home.html";
			case "/ers/register.do": 
				return "Please wait for Manager to create your user account";
			case "/ers/submitRequest.do":
				int eid = Integer.parseInt(req.getParameter("reid").toString());
				String purpose = req.getParameter("purpose");
				double amount = Double.parseDouble(req.getParameter("amount").toString());
				return Service.submitRequest((float) amount, purpose, eid);
			case "/ers/getEmployeeRequests.do":
				//eid = Integer.parseInt(session.getAttribute("EID").toString());
				int eid1=Integer.parseInt(req.getParameter("reid").toString());
				return Service.getEmployeeRequests(eid1);
			case "/ers/getAllRequests.do":
				return Service.getAllRequests();
			case "ers/getAllPendingRequests.do":
				eid = Integer.parseInt(req.getParameter("reid").toString());
				return Service.getPendingRequests(eid);
			case "ers/getAllResolvedRequests.do":
				eid = Integer.parseInt(req.getParameter("reid").toString());
				return Service.getResolvedRequests(eid);
			case "/ers/getRequest.do":
				return Service.getRequest(Integer.parseInt(req.getParameter("reid").toString()));
			case "/ers/requests.do":
				return Service.getRequest(
						Integer.parseInt(req.getParameter("EID").toString()));
			case "/ers/approveRequest.do":
				return Service.approveRequest(
						Integer.parseInt(req.getParameter("rid").toString()), 
						Integer.parseInt(req.getParameter("UID").toString()),
						Integer.parseInt(req.getParameter("ap").toString()));
			case "/ers/getEmployee.do":
				//int auth =Integer.parseInt(req.getSession(false).getAttribute("auth").toString());
			//	if (auth ==1) return "/html/employeetable.html";
				
				System.out.println("username "+username);
				//int eid=Service.getId(req.getParameter("username"));
				eid = Service.getId(username);
				return Service.getEmployee(eid);
			case "/ers/updateEmployee.do":
				int eid2=Service.getId(username);
				return Service.updateEmployee(eid2, username, password);
			case "/ers/updateManager.do":
				int mid=Service.getId(username);
				return Service.updateEmployee(mid, username, password);
			case "/ers/getAllEmployees.do":
				return Service.getAllEmployees();
			default: return "Nothing here";
				
		}
	}

}
