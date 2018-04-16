package com.revature.service;

import java.util.List;

import com.revature.dao.BankDAO;
import com.revature.dao.BankDAOImpl;
import com.revature.model.User;

public class BankService{
    private static BankDAO dao = new BankDAOImpl();

    public static boolean insertUser(User newUser){
        return dao.insertUser(newUser);
    }

    public static boolean updateBalance(User user){
        return dao.updateBalance(user);
    }

    public static boolean makeAdmin(User user){
        return dao.makeAdmin(user.getAccountNumber());
    }

    public static boolean approveUser(int accountNumber){
        return dao.approveUser(accountNumber);
    }

    public static User getUser(int accNum, String passwd){
        return dao.getUser(accNum, passwd);
    }

    public static List<User> getWaitingUsers(){
        return dao.getWaitingUsers();
    }
}