package com.revature.ers.service;

import java.util.List;

import com.revature.ers.dao.*;
import com.revature.ers.model.ERS_User;
import com.revature.ers.model.Request;

public class ERS_Service{
    private static ERSDAO dao = new ERSDAOImpl();

    public boolean insert_user(ERS_User user){
        return dao.insert_user(user);
    }

    public boolean insert_request(Request request){
        return dao.insert_request(request);
    }

    public boolean modify_request(Request request, ERS_User user){
        if(user.getIsManager() == 1)
            return dao.modify_request(request, user);
        else 
            return false;
    }

    public boolean modify_user(ERS_User user){
        return dao.modify_user(user);
    }

    public List<Request> emp_view_certain_requests(ERS_User user, String status){
        return dao.emp_view_certain_requests(user, status);
    }

    public List<Request> man_view_all_requests(){
        return dao.man_view_all_requests();
    }

    public List<Request> man_view_certain_requests(String status){
        return dao.man_view_certain_requests(status);
    }

    public List<Request> man_view_emp_requests(int requester){
        return dao.man_view_emp_requests(requester);
    }
}