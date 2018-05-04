package com.revature.ajax;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.controller.CheckUsernameController;
import com.revature.util.FinalUtil;

/* Request helper specifically for AJAX requests */
public class RequestHelper {
	
	public static Object process(HttpServletRequest request, HttpServletResponse response) {
		switch(request.getRequestURI()) {
		case "/FrontController/checkUsername.ajax":
			return CheckUsernameController.checkUsername(request, response);
		default:
			return new AjaxMessage(FinalUtil.NOT_IMPLEMENTED);
		}
	}
}
