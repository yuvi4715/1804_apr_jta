package com.revature.dao;

import java.util.List;

import com.revature.model.User;

public interface BankDAO{
    public boolean insertUser(User newUser);
    public boolean updateBalance(User user);
    public boolean approveUser(int accountNum);
    public boolean makeAdmin(int accountNum);
    public User getUser(int accountNum, String passwd);
    public List<User> getWaitingUsers();
}