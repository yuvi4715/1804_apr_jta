package com.hpark12.reimbursementDao;


import com.hpark12.reimbursementModel.User;
import com.hpark12.util.establishConnection;

import com.hpark12.util.logUtil;
import org.apache.log4j.Logger;
import org.json.JSONArray;
import org.json.JSONObject;

import java.sql.*;

public class ReimbursementDaoImplementation implements ReimbursementDao{

    final static Logger logger = Logger.getLogger(ReimbursementDaoImplementation.class);

    @Override
    public boolean createUser(User user) {
        try (Connection conn = establishConnection.getConnection()){
            assert conn != null;
            CallableStatement stmt = conn.prepareCall("{CALL insert_User(?,?,?,?,0)}");
            stmt.setString(1, user.getFirstName());
            stmt.setString(2, user.getLastName());
            stmt.setString(3, user.getEmail());
            stmt.setString(4, user.getPassWord());
            return stmt.executeUpdate() > 0;
        }catch (SQLException e) {
            System.err.println(e.getMessage());
            System.err.println("SQL State: " + e.getSQLState());
            System.err.println("Error Code: " + e.getErrorCode());
        }
        return false;
    }

    @Override
    public boolean createAdmin(User user) {
        try (Connection conn = establishConnection.getConnection()){
            assert conn != null;
            CallableStatement stmt = conn.prepareCall("{CALL insert_User(?,?,?,?,1)}");
            stmt.setString(1, user.getFirstName());
            stmt.setString(2, user.getLastName());
            stmt.setString(3, user.getEmail());
            stmt.setString(4, user.getPassWord());
            return stmt.executeUpdate() > 0;
        }catch (SQLException e) {
            System.err.println(e.getMessage());
            System.err.println("SQL State: " + e.getSQLState());
            System.err.println("Error Code: " + e.getErrorCode());
        }
        return false;
    }

    @Override
    public boolean addReimbursement(User user, double amount, String purpose) {
        try (Connection conn = establishConnection.getConnection()){
            CallableStatement stmt = conn.prepareCall("{CALL insert_Reimbursement_Request(?,?,?)}");
            stmt.setString(1, user.getEmail());
            stmt.setDouble(2, amount);
            stmt.setString(3, purpose);
            return stmt.executeUpdate() > 0;
        }catch (SQLException e) {
            System.err.println(e.getMessage());
            System.err.println("SQL State: " + e.getSQLState());
            System.err.println("Error Code: " + e.getErrorCode());
        }
        return false;
    }


    @Override
    public boolean approveReimbursement(User user, int reimbursement_Id, int approval) {
        try (Connection conn = establishConnection.getConnection()){
            CallableStatement stmt = conn.prepareCall("{CALL approve_Reimbursement(?,?,?)}");
            stmt.setInt(1, reimbursement_Id);
            stmt.setString(2, user.getEmail());
            stmt.setInt(3, approval);
            return stmt.executeUpdate() > 0;
        }catch (SQLException e) {
            System.err.println(e.getMessage());
            System.err.println("SQL State: " + e.getSQLState());
            System.err.println("Error Code: " + e.getErrorCode());
        }
        return false;
    }

    @Override
    public JSONArray allEmployees() {
        try (Connection conn = establishConnection.getConnection()) {
            PreparedStatement stmt = conn.prepareStatement("SELECT * FROM User_Account");
            ResultSet rs = stmt.executeQuery();
            JSONArray jArray = new JSONArray();
            while (rs.next())
            {
                int userId=rs.getInt("User_ID");
                String email=rs.getString("User_Email");
                String firstname = rs.getString("First_Name");
                String lastname = rs.getString("Last_Name");

                JSONObject jObj = new JSONObject();
                jObj.put("User_ID", userId);
                jObj.put("Email", email);
                jObj.put("First_Name", firstname);
                jObj.put("Last_Name", lastname);
                jArray.put(jObj);
            }
            return jArray;
        } catch (SQLException sqle) {
            logUtil.log.info("Error in loginUser of ReimbursementDaoImplementation.java");
            System.err.println(sqle.getMessage());
            System.err.println("SQL State: " + sqle.getSQLState());
            System.err.println("Error Code: " + sqle.getErrorCode());
        }
        return null;
    }



    public User loginUser(String email, String password) {
        try (Connection conn = establishConnection.getConnection()) {
            assert conn != null;
            PreparedStatement stmt =
                    conn.prepareStatement("SELECT * FROM User_Account WHERE User_Email = ? AND User_Password = ?");
            stmt.setString(1, email);
            stmt.setString(2, password);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                User user = new User(rs.getString("User_Email"), rs.getString("User_Password"),
                        rs.getString("First_Name"), rs.getString("Last_Name"),
                        rs.getInt("Is_Admin"));
                return user;
            }
        } catch (SQLException sqle) {
            logUtil.log.info("Error in loginUser of ReimbursementDaoImplementation.java");
            System.err.println(sqle.getMessage());
            System.err.println("SQL State: " + sqle.getSQLState());
            System.err.println("Error Code: " + sqle.getErrorCode());
        }
        return null;
    }

    @Override
    public JSONArray viewPending(User user){
        try (Connection conn = establishConnection.getConnection()) {
            PreparedStatement stmt =
                    conn.prepareStatement("SELECT * FROM Reimbursement WHERE Employee_Email = ? AND Status = 0");
            stmt.setString(1, user.getEmail());
            ResultSet rs = stmt.executeQuery();
            JSONArray jArray = new JSONArray();
            while (rs.next())
            {
                int  r_Id=rs.getInt("Reimbursement_ID");
                String purpose=rs.getString("Purpose");
                double amount = rs.getDouble("Reimbursement_Amount");
                Date date_made = rs.getDate("Reimbursement_Date_Time");
                JSONObject jObj = new JSONObject();
                jObj.put("Reimbursement_ID", r_Id);
                jObj.put("Purpose", purpose);
                jObj.put("Amount", amount);
                jObj.put("Date_Submitted", date_made);
                jArray.put(jObj);
            }
            return jArray;
        } catch (SQLException sqle) {
            logUtil.log.info("Error in loginUser of ReimbursementDaoImplementation.java");
            System.err.println(sqle.getMessage());
            System.err.println("SQL State: " + sqle.getSQLState());
            System.err.println("Error Code: " + sqle.getErrorCode());
        }
        return null;
    }

    @Override
    public JSONArray viewApproved(User user){
        try (Connection conn = establishConnection.getConnection()) {
            PreparedStatement stmt =
                    conn.prepareStatement("SELECT * FROM Reimbursement WHERE Employee_Email = ? AND Status = 1");
            stmt.setString(1, user.getEmail());
            ResultSet rs = stmt.executeQuery();
            JSONArray jArray = new JSONArray();
            while (rs.next())
            {
                int  r_Id=rs.getInt("Reimbursement_ID");
                String purpose=rs.getString("Purpose");
                double amount = rs.getDouble("Reimbursement_Amount");
                Date date_made = rs.getDate("Reimbursement_Date_Time");
                String approving_manager = rs.getString("Admin_Email");
                Date date_approved = rs.getDate("Reimbursement_Review_Date");
                JSONObject jObj = new JSONObject();
                jObj.put("Reimbursement_ID", r_Id);
                jObj.put("Purpose", purpose);
                jObj.put("Amount", amount);
                jObj.put("Date_Submitted", date_made);
                jObj.put("Manager", approving_manager);
                jObj.put("Date_Approved", date_approved);
                jArray.put(jObj);
            }
            return jArray;
        } catch (SQLException sqle) {
            logUtil.log.info("Error in loginUser of ReimbursementDaoImplementation.java");
            System.err.println(sqle.getMessage());
            System.err.println("SQL State: " + sqle.getSQLState());
            System.err.println("Error Code: " + sqle.getErrorCode());
        }
        return null;
    }

    @Override
    public JSONArray viewAllPending(User user){
        try (Connection conn = establishConnection.getConnection()) {
            PreparedStatement stmt =
                    conn.prepareStatement("SELECT * FROM Reimbursement WHERE Status = 0");
            ResultSet rs = stmt.executeQuery();
            JSONArray jArray = new JSONArray();
            while (rs.next())
            {
                int  r_Id=rs.getInt("Reimbursement_ID");
                String purpose=rs.getString("Purpose");
                double amount = rs.getDouble("Reimbursement_Amount");
                Date date_made = rs.getDate("Reimbursement_Date_Time");
                JSONObject jObj = new JSONObject();
                jObj.put("Reimbursement_ID", r_Id);
                jObj.put("Purpose", purpose);
                jObj.put("Amount", amount);
                jObj.put("Date_Submitted", date_made);
                jArray.put(jObj);
            }
            return jArray;
        } catch (SQLException sqle) {
            logUtil.log.info("Error in loginUser of ReimbursementDaoImplementation.java");
            System.err.println(sqle.getMessage());
            System.err.println("SQL State: " + sqle.getSQLState());
            System.err.println("Error Code: " + sqle.getErrorCode());
        }
        return null;
    }

    @Override
    public JSONArray viewAllApproved(User user){
        try (Connection conn = establishConnection.getConnection()) {
            PreparedStatement stmt =
                    conn.prepareStatement("SELECT * FROM Reimbursement WHERE Status = 1");
            ResultSet rs = stmt.executeQuery();
            JSONArray jArray = new JSONArray();
            while (rs.next())
            {
                int  r_Id=rs.getInt("Reimbursement_ID");
                String purpose=rs.getString("Purpose");
                double amount = rs.getDouble("Reimbursement_Amount");
                Date date_made = rs.getDate("Reimbursement_Date_Time");
                String approving_manager = rs.getString("Admin_Email");
                Date date_approved = rs.getDate("Reimbursement_Review_Date");
                JSONObject jObj = new JSONObject();
                jObj.put("Reimbursement_ID", r_Id);
                jObj.put("Purpose", purpose);
                jObj.put("Amount", amount);
                jObj.put("Date_Submitted", date_made);
                jObj.put("Manager", approving_manager);
                jObj.put("Date_Approved", date_approved);
                jArray.put(jObj);
            }
            return jArray;
        } catch (SQLException sqle) {
            logUtil.log.info("Error in loginUser of ReimbursementDaoImplementation.java");
            System.err.println(sqle.getMessage());
            System.err.println("SQL State: " + sqle.getSQLState());
            System.err.println("Error Code: " + sqle.getErrorCode());
        }
        return null;
    }




    }




