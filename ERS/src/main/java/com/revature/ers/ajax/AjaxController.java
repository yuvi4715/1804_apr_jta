package com.revature.ers.ajax;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.ers.model.ERS_User;
import com.revature.ers.model.Request;
import com.revature.ers.service.ERS_Service;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.*;

public class AjaxController{
    private static ERS_User user;

    //Mainly for tests with Ajax
    public static String getUser(HttpServletRequest request, HttpServletResponse response){
        //ERS_User myuser = (ERS_User) request.getSession().getAttribute("loggedUser");
        //System.out.println("Logged user is: " + myuser.toString());
        //System.out.println("We got: " + request.getParameter("email"));
        //System.out.println("And: " + request.getParameter("passwd"));
        user = ERS_Service.getERS_Service().getUser(request.getParameter("email"), request.getParameter("passwd"));
        if(user != null){
            try {
                String str = new ObjectMapper().writeValueAsString(user);
                //System.out.println("Got the user!");
                //System.out.println("This is: " + str);
                return str;
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }
            return "We failed";
        }
        else
            return "User was null";
    }

    public static String empViewCertainReq(HttpServletRequest request, HttpServletResponse response){
        System.out.println("Im in empViewCertReq");
        ERS_User user = (ERS_User) request.getSession().getAttribute("loggedUser");
        System.out.println(user);
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
}