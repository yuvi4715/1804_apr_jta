package app;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import employee.Employee;
import manager.Manager;

/**
 * Login Controller
 */
public class loginController {

	public static String loginSession(HttpServletRequest request) {
		HttpSession session = request.getSession(true);
		
		String user = request.getParameter("username");
		String password = request.getParameter("password");
		if (request.getRequestURI().equals("/ers/login.do")) {
			/*if (request.getSession(false).getAttribute("username") == null) {
				return "/ers/html/home.html";
			}*/
			if (Service.login(user, password) != null) {
				//session.getMaxInactiveInterval()
				session.setAttribute("user", user);
				session.setAttribute("password", password);
				
				
				//	response.addCookie(cookie);
				int uid = Service.getId(user);
				session.setAttribute("UID", uid);
				if (uid % 2 == 0) // even is mid
				{
					session.setAttribute("MID", uid);
					session.setAttribute("Lastname", Service.getManager(uid).getLastname());
					session.setAttribute("Firstname", Service.getManager(uid).getFirstname());
					session.setAttribute("auth", 1);
					Manager ma = Service.getManager(uid);
					//return Service.getManager(uid);
				} else {
					session.setAttribute("EID", uid);
					session.setAttribute("Lastname", Service.getEmployee(uid).getLastname());
					session.setAttribute("Firstname", Service.getEmployee(uid).getFirstname());
					session.setAttribute("auth", 0);
					Employee em = Service.getEmployee(uid);
					//	return Service.getEmployee(uid);
					
				}

			}else return "Failure";//+"invalidlogin"; 
			

		}
		return "Success Login";//"/ers/html/user.html";//+session.getAttribute("user");
		/*
		 * response.setIntHeader("auth", 1);
		 * 
		 * Cookie loginCookie = new Cookie("user", user); //setting cookie to expire in
		 * 10 minutes loginCookie.setMaxAge(10*60); response.addCookie(loginCookie);
		 * 
		 * // Log.debug("Servlet Context "+session.getServletContext()); /*
		 * pw.println("session started"); sessionId=session.getId();
		 * pw.println(request.getParameter("username")); pw.println("Welcome " +
		 * session.getAttribute("username")); pw.println("Your id is:"+
		 * Service.getId(username)); String
		 * json=mapper.writeValueAsString(Service.getAllEmployees()); String
		 * result1=mapper.writeValueAsString(result); pw.println(sessionId +
		 * " is your session ID"); pw.println(json); pw.write(json);
		 * 
		 * json = mapper.writeValueAsString(result); //
		 * response.getWriter().write(json);
		 * //response.sendRedirect("/ers/html/user.html"); //redirects require full URI
		 * //System.out.println(response.getHeader("auth"));
		 * //request.getRequestDispatcher("/html/user.html").forward(request, response);
		 * dispatch(request, response, "/html/user.html"); }
		 */

	}

}
