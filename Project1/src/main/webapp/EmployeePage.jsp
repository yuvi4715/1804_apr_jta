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
<title>Employee Page</title>
</head>
<body>
	<a href = "http://localhost:8082/Project1_Reimbursment/Logout.jsp">Log Out</a>
	<% 
		Employee em = (Employee)session.getAttribute("LoggedInEmployee");
	%>
	<div>
		<h1><em> Employee Reimbursement System </em> </h1>
	</div>
	<h3><b>Employee</b></h3>
	<table border='1' width='100%'>
	<% out.print("<tr><th>Email</th><th>Password</th><th>Name</th>");
    out.print("<tr><td>"+em.getEmail()+"</td><td>"+ em.getPassword() +"</td> <td>"+em.getFirstName() +" "+em.getLastName() +"</td><td>");
	%>
	</table>
	<form action="UserRequests" method="post">
		<pre>
			<input type = "hidden" name = "email" value = "<%=em.getEmail()%>"/>
		 <input type="submit" value="View Pending" name = "switch"/>  <input type="submit" value="View Approved" name = "switch"/>  <input type="submit" value="View All" name = "switch"/>
			<br>
			<b>username:</b> <input type="email" name="user" placeholder= "Email"  /> <b>Amount:</b> <input type="number" name="amount" placeholder= "00.00"  /> <b>Purpose:</b> <input type="text" name="purpose" placeholder= "Purpose"  /> 
			<input type="submit" value="New Reimbursement" name= "switch"/> 
		</pre>
	</form>	
	
		
		<% List<Reimbursment> users =  (List<Reimbursment>)session.getAttribute("All List");
			out.print(users);
			List<Reimbursment> rec1 =  (List<Reimbursment>)session.getAttribute("Pending");
			out.print(rec1);	
			List<Reimbursment> rec2 =  (List<Reimbursment>)session.getAttribute("Approved List");
			out.print(rec2);	
			%>
</body>
</html>