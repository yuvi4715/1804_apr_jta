package com.revature.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.revature.model.Employee;
import com.revature.model.Request;
import com.revature.service.EmployeeService;

public class EmployeeController {
	
	public static String displayAll(HttpServletRequest request) {
		
		request.setAttribute("redirectFlag", new Integer(0));
		
		
		StringBuilder strBldr = new StringBuilder("");
		
		List<Employee> empList = EmployeeService.getAll();
		
		
		for(Employee emp : empList) {
			strBldr.append("<tr><td>" + emp.getUserid() + "</td><td>" + emp.getlName() 
							+ "</td><td>" + emp.getfName() + "</td><td>" + emp.getEmail() 
							+ "</td><td>" + emp.getHireDate() + "</td></tr>");	
		}
		
		String str = strBldr.toString();
		
		return str;
	}
	
	public static String display (HttpServletRequest request) {
		
		HttpSession session = request.getSession();
		request.setAttribute("redirectFlag", new Integer(0));
		
		Integer userid = (Integer) session.getAttribute("userid");
		String fName = (String) session.getAttribute("fName");
		String lName = (String) session.getAttribute("lName");
		String email = (String) session.getAttribute("email");
		
		StringBuilder strBldr = new StringBuilder("");
		
		strBldr.append("<form action=\"/project1v2/updateEmployee.do\" method=\"post\">\r\n" + 
				"		<table class=\"table table-bordered table-striped\">\r\n" + 
				"			<tr>\r\n" + 
				"				<td>User ID</td>\r\n" + 
				"				<td>" + userid + "</td>\r\n" + 
				"			</tr><tr>" +
				"				<td> " + fName + "</td>\r\n" + 
				"				<td><input type=\"text\" class=\"form-control\" \r\n" + 
				"    						id=\"newFirstName\" name=\"newFirstName\" \r\n" + 
				"    						placeholder=\"Name Change\"></td>\r\n" + 
				"			</tr><tr>\r\n" + 
				"				<td>" + lName +"</td>\r\n" + 
				"				<td><input type=\"text\" class=\"form-control\" \r\n" + 
				"    						id=\"newLastName\" name=\"newLastName\" \r\n" + 
				"    						placeholder=\"Name Change\"></td>\r\n" + 
				"			</tr><tr>\r\n" + 
				"				<td>" + email +"</td>\r\n" + 
				"				<td><input type=\"text\" class=\"form-control\" \r\n" + 
				"    						id=\"newEmail\" name=\"newEmail\" \r\n" + 
				"    						placeholder=\"Enter a new email here.\"></td>\r\n" + 
				"			</tr><tr>\r\n" + 
				"				<td>********</td>\r\n" + 
				"				<td><input type=\"text\" class=\"form-control\" \r\n" + 
				"    						id=\"newPassword\" name=\"newPassword\" \r\n" + 
				"    						placeholder=\"New password. Leave blank to not change.\"></td>\r\n" + 
				"			</tr></table>\r\n" + 
				"			<button type=\"submit\" value=\"submitRequest\" class=\"btn btn-primary\">Submit</button>\r\n" + 
				"	</form>");
		
		String str = strBldr.toString();
		
		return str;
		
	}
	
	public static String update (HttpServletRequest request) { 
		
		HttpSession session = request.getSession();
		request.setAttribute("redirectFlag", new Integer(1));
		
		
		Integer userid = (Integer) session.getAttribute("userid");
		String fName = (String) session.getAttribute("fName");
		String lName = (String) session.getAttribute("lName");
		String email = (String) session.getAttribute("email");
		
		String newfName = request.getParameter("newFirstName");
		String newlName = request.getParameter("newLastName");
		String newPass = request.getParameter("newPassword");
		String newEmail = request.getParameter("newEmail");
		
		//System.out.println(userid + " " + fName + " " + lName + " " + email);
		//System.out.println(newfName + " " + newlName + " " + newPass + " " + newEmail);
		//if (newPass.equals("")) {
		//	System.out.println("newPass is an empty string");
		//}
		//if (newPass.equals(null)) {
		//	System.out.println("newPass is null");
		//}
		
		
		Employee emp = EmployeeService.get(userid);
		boolean boolOther = false;
		boolean boolEmail = false;
		
		if (!(newfName.equals(""))) {
			
			//System.out.println("set fName");
			emp.setfName(newfName);
			boolOther = true;
		}
		if (!(newlName.equals(""))) {

			//System.out.println("set lName");
			emp.setlName(newlName);
			boolOther = true;
		}
		if (!(newEmail.equals(""))) {

			//System.out.println("set email");
			emp.setEmail(newEmail);
			boolEmail = true;
		}
		if (!(newPass.equals(""))) {

			//System.out.println("set pass");
			emp.setPassphrase(newPass);
			boolOther = true;
		}
		if (boolEmail) {

			//System.out.println("update email");
			EmployeeService.updateEmail(emp);
			
		}
		if (boolOther) {
			
			//System.out.println("update rest");
			EmployeeService.update(emp);
			
		}
		
		
		session.setAttribute("fName", emp.getfName());
		session.setAttribute("lName", emp.getlName());
		session.setAttribute("email", emp.getEmail());

		
		return "html/employeeMenu.html";
		
	}

}
