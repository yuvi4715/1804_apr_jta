<%@page import="com.revature.model.Reimbursment"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.revature.model.Employee"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<meta  name="viewport"  content="width=device-width, initial-scale=2" />
<link
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
	rel="stylesheet">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Manager Page</title>
</head>
<body>
	<a href = "http://localhost:8082/Project1_Reimbursment/Logout.jsp">Log Out</a>
	<% 
		Employee em = (Employee)session.getAttribute("LoggedInManager");
	%>
	<div>
		<h1><em> Manager Reimbursement System </em> </h1>
	</div>
	<form action="ManagerRequests" method="post">
		<pre>
			<input  type = "hidden" name = "email" value = "<%=em.getEmail()%>"  />
		<input type="submit" value="ViewAllPending"  name = "switch"/>  <input type="submit" value="ViewAllRecords" name = "switch"/>  <input type="submit" value="ViewEmployee" name = "switch"/>
			<br>
			<b>Record Id:</b> <input type="number" name="requestId" placeholder= "Record Id"  /> <b>Approve/Deny:</b> <input type="text" name="status" placeholder= "Approve or Deny"  /> <b>Email:</b> <input type="email" name="manager" placeholder= "Your Email"  /> 
			<input type="submit" value="ApproveDeny" name= "switch"/> 
		</pre>
	</form>	
	
		
		<% List<Reimbursment> users =  (List<Reimbursment>)session.getAttribute("All Pending");
			out.print(users);
			List<Reimbursment> rec1 =  (List<Reimbursment>)session.getAttribute("List All");
			out.print(rec1);	
			List<Reimbursment> rec2 =  (List<Reimbursment>)session.getAttribute("All Emplyoee List");
			out.print(rec2);	
			%>
	
</body>
</html>