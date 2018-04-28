package com.revature.ers.ajax;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.ers.model.ERS_User;
import com.revature.ers.service.ERS_Service;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.*;

public class AjaxController{
    private static ERS_User user;

    public static String getUser(HttpServletRequest request, HttpServletResponse response){
        System.out.println("We got: " + request.getParameter("email"));
        System.out.println("And: " + request.getParameter("passwd"));
        user = ERS_Service.getERS_Service().getUser(request.getParameter("email"), request.getParameter("passwd"));
        if(user != null){
            try {
                String str = new ObjectMapper().writeValueAsString(user);
                System.out.println("Got the user!");
                System.out.println("This is: " + str);
                return str;
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }
            return "We failed";
        }
        else
            return "User was null";
    }
}