package com.revature.Util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * Created by bryanvillegas on 4/13/18.
 */
public class ConnectionUtil {
    private ConnectionUtil(){}
    public static Connection getConnection(){
        InputStream in = null;
        try{
            Properties props = new Properties();
            in = new FileInputStream("src/main/resources/db.properties");
            props.load(in);
            return DriverManager.getConnection(props.getProperty("url"), props.getProperty("username"),
                    props.getProperty("password"));
        }catch(SQLException sqle){
            System.err.print(sqle.getMessage());
        }catch (FileNotFoundException fnfe){
            fnfe.printStackTrace();
        }catch (IOException ioe){
            ioe.printStackTrace();
        }
        finally {
            try{
                in.close();
            }catch(IOException ioe){
                ioe.printStackTrace();
            }
        }
        return null;
    }
}
