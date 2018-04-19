package Bank.model;

import java.io.Serializable;
import java.util.Scanner;


public class User implements Serializable{

    private String username, password;
    private int userID;
    private boolean isApproved;
    private boolean isAdmin;

    public User(){}

    public User(int id, String username1, String password1, boolean isApproved, boolean isAdmin){
        this.userID = id;
        this.username = username1;
        this.password = password1;
        this.isApproved = isApproved;
        this.isAdmin = isAdmin;
    }

    public String getUserName(){
        return username;
    }
    public String getPassword(){
        return password;
    }
    public int getUserID(){
        return userID;
    }
    public int setUserID(int id){
        return this.userID = id;
    }
    public String setUsername(String un){
        return this.username = un;
    }
    public String setPassword(String pw){
        return this.password = pw;
    }
    public boolean getApproved(){return isApproved;}
    public void setApproved(boolean app){this.isApproved = app;}
    public boolean getAdmin(){return isAdmin;}
    public boolean setAdmin(boolean a){return this.isAdmin = a;}






}
