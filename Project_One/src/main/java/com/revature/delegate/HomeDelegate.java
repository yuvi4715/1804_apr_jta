package com.revature.delegate;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.beans.Login;

public class HomeDelegate {
	
		public void goHome(HttpServletRequest req, HttpServletResponse resp) throws IOException {
			// Get our session information
			HttpSession session = req.getSession();
			// Give a personalized response
			Login login = (Login) session.getAttribute("user");

			if (login == null) {
				resp.sendRedirect("login");
			} else {
				PrintWriter pw = resp.getWriter();
				pw.write("<!DOCTYPE html><html><head>" + "<meta charset=\"ISO-8859-1\"><title>HelloWorld</title>"
						+ "</head><body>");

				pw.write("<div><div style=\"background-color:" + login.getFavColor() + "\">" + "<h4>Hello "
						+ login.getUsername() + "</h4></div>" + "<form action=\"logout\" method=\"post\">"
						+ "<input type=\"submit\" value=\"Logout\"/>" + "</form></div>");

				pw.write("</body></html>");
			}
		}
	}

