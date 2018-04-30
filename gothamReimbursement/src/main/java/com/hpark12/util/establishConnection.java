package com.hpark12.util;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;


public class establishConnection {


    static {
        try {
            Class.forName("oracle.jdbc.OracleDriver");
        } catch (ClassNotFoundException e) {
            logUtil.log.error("Go import jdbc");
        }

    }


    public static Connection getConnection() {

        InputStream in = null;

        try {
            Properties props = new Properties();
            in = new FileInputStream("C:\\Users\\Richard\\IdeaProjects\\gothamReimbursement\\src\\main\\resources\\ReimbursementDB.properties");
            props.load(in);
            return DriverManager.getConnection(props.getProperty("jdbc.url"),
                    props.getProperty("jdbc.username"), props.getProperty("jdbc.password"));
        } catch (SQLException e) {
            logUtil.log.error("Debug establish connection");
            System.err.println(e.getMessage());
            System.err.println("SQL State: " + e.getSQLState());
            System.err.println("Error Code: " + e.getErrorCode());
        } catch (FileNotFoundException fnfe) {
            System.err.println(fnfe.getMessage());
        } catch (IOException ioe) {
            System.err.println(ioe.getMessage());
        } finally {
            try {
                in.close();
            } catch (IOException ioe) {
                System.err.println("When closing InputStream: " + ioe.getMessage());
            }
        }

        return null;
    }



}