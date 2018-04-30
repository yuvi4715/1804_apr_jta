package com.hpark12.ajax;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hpark12.reimbursementModel.User;
import com.hpark12.reimbursementService.ReimbursementService;
import com.hpark12.util.logUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

class AjaxMethods {

    static String insertRequest(HttpServletRequest req, HttpServletResponse resp){

        User user = (User)req.getSession().getAttribute("currentUser");

        logUtil.log.info(user);
        logUtil.log.info(req.getParameter("amount"));
        logUtil.log.info(req.getParameter("purpose"));

        boolean bool = ReimbursementService.addReimbursement(user,
                Double.parseDouble(req.getParameter("amount")),req.getParameter("purpose"));
        if(bool) {
            return "Request Successful";
        }else
            return "Request Failed";
    }

    static String viewPending(HttpServletRequest req) {

        User user = (User)req.getSession().getAttribute("currentUser");
        logUtil.log.info(ReimbursementService.viewPending(user).toString());

        return ReimbursementService.viewPending(user).toString();
    }

    static String viewApproved(HttpServletRequest req) {

        User user = (User)req.getSession().getAttribute("currentUser");
        logUtil.log.info(ReimbursementService.viewApproved(user).toString());

        return ReimbursementService.viewApproved(user).toString();
    }

    static String approveRequest(HttpServletRequest req){

        User user = (User)req.getSession().getAttribute("currentUser");
        int id = Integer.parseInt((req.getParameter("reimbursementId")));
        int temp = Integer.parseInt(req.getParameter("status"));
        if(temp == 1){
            ReimbursementService.approveReimbursement(user, id,1);
        }else if(temp == 0){
            ReimbursementService.approveReimbursement(user, id,0);
        }else{
            return "Failed";
        }
        return "Task Completed";
    }

    static String viewAllPending(HttpServletRequest req) {

        User user = (User)req.getSession().getAttribute("currentUser");
        logUtil.log.info(ReimbursementService.viewAllPending(user).toString());

        return ReimbursementService.viewAllPending(user).toString();
    }

    static String viewAllApproved(HttpServletRequest req) {

        User user = (User)req.getSession().getAttribute("currentUser");
        logUtil.log.info(ReimbursementService.viewAllApproved(user).toString());

        return ReimbursementService.viewAllApproved(user).toString();
    }


    static String viewAll(){
        return ReimbursementService.allEmployees().toString();

    }


}
