package com.revature.ers.ajax;

import java.sql.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.ers.model.ERS_User;
import com.revature.ers.model.Request;
import com.revature.ers.service.ERS_Service;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.*;

public class AjaxController{

    public static String empViewCertainReq(HttpServletRequest request, HttpServletResponse response){
        System.out.println("Im in empViewCertReq");
        List<Request> list = ERS_Service.getERS_Service().emp_view_certain_requests((ERS_User) request.getSession().getAttribute("loggedUser"), request.getParameter("status"));
        if(list != null){
            try {
                System.out.println("List is not null after all.");
                String str = new ObjectMapper().writeValueAsString(list);
                return str;
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }
            System.out.println("We failed man.");
            return null;
        }
        else
            return null;
    }

    public static String insertReq(HttpServletRequest request, HttpServletResponse response){
        System.out.println("Im in insertReq");
        ERS_User user = (ERS_User) request.getSession().getAttribute("loggedUser");
        Request req = new Request(0, user.getUser_id(), 0, Double.parseDouble(request.getParameter("amount")), 
        request.getParameter("purpose"),"PENDING", new Date(1L), new Date(1L));
        if(ERS_Service.getERS_Service().insert_request(req)){
            return "Insert succeeded";
        }
        else 
            return "Insert failed.";
    }
}