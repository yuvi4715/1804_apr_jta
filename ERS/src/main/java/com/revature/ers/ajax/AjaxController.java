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
            return "Insert succeeded.";
        }
        else 
            return "Insert failed.";
    }

    public static String modifyUser(HttpServletRequest request, HttpServletResponse response){
        System.out.println("I'm in modifyuser");
        ERS_User user = (ERS_User) request.getSession().getAttribute("loggedUser");
        String firstN = request.getParameter("firstN");
        String lastN = request.getParameter("lastN");
        String email = request.getParameter("email");
        String passwd = request.getParameter("passwd");
        if (firstN != null)
            user.setFirstName(firstN);
        if (lastN != null)
            user.setLastName(lastN);
        if (email != null)
            user.setEmail(email);
        if (passwd != null)
            user.setPasswd(passwd);
        
        if(ERS_Service.getERS_Service().modify_user(user)){
            return "Modify succeeded.";
        }
        else
            return "Modify failed.";
    }

    public static String getUser(HttpServletRequest request, HttpServletResponse response){
        System.out.println("I'm getting the current logged user.");
        try {
            ERS_User user = (ERS_User) request.getSession().getAttribute("loggedUser");
            String str = new ObjectMapper().writeValueAsString(user);
            return str;
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return "No user logged in";
    }

    public static String getAllEmp(HttpServletRequest request, HttpServletResponse response){
        System.out.println("Im in getAllEmp");
        List<ERS_User> list = ERS_Service.getERS_Service().getAllUsers();
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

    public static String manCertReq(HttpServletRequest request, HttpServletResponse response){
        System.out.println("Im in manCertReq");
        List<Request> list = ERS_Service.getERS_Service().man_view_certain_requests(request.getParameter("status"));
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

    public static String manAllReq(HttpServletRequest request, HttpServletResponse response){
        System.out.println("Im in manCertReq");
        List<Request> list = ERS_Service.getERS_Service().man_view_all_requests();
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

    public static String manCertEmp(HttpServletRequest request, HttpServletResponse response){
        System.out.println("Im in manCertEmp");
        List<Request> list = ERS_Service.getERS_Service().man_view_emp_requests(Integer.parseInt(request.getParameter("requester")));
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

    public static String modRequest(HttpServletRequest request, HttpServletResponse response){
        System.out.println("I'm in modRequest");
        ERS_User user = (ERS_User) request.getSession().getAttribute("loggedUser");
        Request req = new Request(Integer.parseInt(request.getParameter("requestid")),0,user.getUser_id(),0,"", request.getParameter("status"), new Date(1L), new Date(1L));
        if(ERS_Service.getERS_Service().modify_request(req, user))
            return "Modified successfully.";
        else
            return "Failed to modify request.";
    }
}