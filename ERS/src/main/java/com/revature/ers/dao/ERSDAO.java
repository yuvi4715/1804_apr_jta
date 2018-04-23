package com.revature.ers.dao;

import java.util.List;

import com.revature.ers.model.*;

public interface ERSDAO{
    public boolean insert_user(ERS_User user);
    public boolean insert_request(Request request);
    public boolean modify_request(Request request);
    public boolean modify_user(ERS_User user);
    public List<Request> emp_view_certain_requests(ERS_User user, String status);
    public List<Request> man_view_all_requests();
    public List<Request> man_view_certain_requests(String status);
    public List<Request> man_view_emp_requests(int requester);
}