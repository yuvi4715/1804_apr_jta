package com.hpark12.ajax;

import com.hpark12.delegate.LoginController;
import com.hpark12.util.logUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/* Request helper specifically for AJAX requests */
class AjaxRequestHelper {

    static String process(HttpServletRequest request, HttpServletResponse response) throws IOException {
        logUtil.log.info("Im in AjaxHelper");

        switch (request.getRequestURI()) {
            case "/gothamReimbursement/html/insertRequest.ajax":
                return AjaxMethods.insertRequest(request, response);

            case "/gothamReimbursement/html/viewPending.ajax":
                return AjaxMethods.viewPending(request);

            case "/gothamReimbursement/html/viewApproved.ajax":
                return AjaxMethods.viewApproved(request);

            case "/gothamReimbursement/html/approveRequest.ajax":
                return AjaxMethods.approveRequest(request);

            case "/gothamReimbursement/html/viewAllPending.ajax":
                return AjaxMethods.viewAllPending(request);

            case "/gothamReimbursement/html/viewAllApproved.ajax":
                return AjaxMethods.viewAllApproved(request);

            case "/gothamReimbursement/html/viewAllEmployees.ajax":
                return AjaxMethods.viewAll();

            default:
                return "/html/404.html";
        }
    }
}
//            case "/gothamReimbursement/html/logout.ajax":
//                    return LoginController.logout(request);