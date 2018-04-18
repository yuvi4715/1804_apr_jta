package com.rev.ex;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by bryanvillegas on 4/11/18.
 */
public class ConnectionUtil {
    private ConnectionUtil(){}
    public static Connection getConnection(){
        try{
            return DriverManager.getConnection("jdbc:oracle:thin:@jta1804.cq251rayjwlu.us-east-2.rds.amazonaws.com:1521:ORCL", "chinook", "p4ssw0rd");
        }
        catch (SQLException e){
            System.err.println(e.getMessage());
            System.err.println("SQL State: " + e.getSQLState());
            System.err.println("Error Code: " + e.getErrorCode());
        }

        return null;
    }

    public static void main(String[] args){
        System.out.println(ConnectionUtil.getConnection());
    }
}
