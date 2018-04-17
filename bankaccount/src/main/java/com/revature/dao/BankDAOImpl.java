package com.revature.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.revature.model.User;
import com.revature.util.ConnectionUtil;

public class BankDAOImpl implements BankDAO{
    final static Logger log = Logger.getLogger(BankDAOImpl.class); 

	@Override
	public boolean insertUser(User newUser) {
        int index = 0;
        try (Connection conn = ConnectionUtil.getConnection()){
            //First insert is to bankuser table
            PreparedStatement stmt = conn.prepareStatement("INSERT INTO bankuser (firstName, lastName, isAdmin, isApproved) VALUES (?,?,?,?)");
            stmt.setString(++index, newUser.getFirstName());
            stmt.setString(++index, newUser.getLastName());
            stmt.setInt(++index, newUser.getIsAdmin());
            stmt.setInt(++index, 0);

            //If this variable is less than 3, then one of the inserts failed.
            int rowsUpdated = 0;
            rowsUpdated += stmt.executeUpdate();

            //Log insertion
            if (rowsUpdated == 0)
                log.error("Insertion of " + newUser.getFirstName() + " " + newUser.getLastName() + " into bankuser failed");
            else   
                log.info("Insertion of " + newUser.getFirstName() + " " + newUser.getLastName() + " into bankuser succeeded");
            
            //Get newly generated accountNumber
            int accNum = 0;
            String getLastRowFromBankUserQuery = "SELECT * FROM " + 
            "(select * from bankuser ORDER BY accountNumber DESC) WHERE rownum <= 1 ORDER BY rownum DESC";
            stmt = conn.prepareStatement(getLastRowFromBankUserQuery);
            ResultSet rs = stmt.executeQuery();
            if (rs.next())
                accNum = rs.getInt("accountNumber");
            else
                log.error("Error occured with the ResultSet return when fetching the last row for the accountNumber.");
            
            //Second insertion requires the accountNumber, and inserts into account table.
            index = 0;
            stmt = conn.prepareStatement("INSERT INTO account(accountNumber, balance) VALUES(?,?)");
            stmt.setInt(++index, accNum);
            stmt.setDouble(++index, newUser.getBalance());

            //Execute the query and update rowsUpdated variable.
            rowsUpdated += stmt.executeUpdate();

            //Log insertion
            if (rowsUpdated == 1)
                log.error("Insertion of " + accNum + " into account failed");
            else   
                log.info("Insertion of " + accNum + " into account succeeded. Balance is: " + newUser.getBalance());
            
            //Insert into password table
            index = 0;
            stmt = conn.prepareStatement("INSERT INTO p4ssw0rd(accountNumber, pass) VALUES (?,?)");
            stmt.setInt(++index, accNum);
            stmt.setString(++index, newUser.getPass());
            
            //Execute the query and update rowsUpdated variable.
            rowsUpdated += stmt.executeUpdate();

            //Log insertion
            if (rowsUpdated == 2)
                log.error("Insertion of " + accNum + " into password failed");
            else   
                log.info("Insertion of " + accNum + " into password succeeded");

            return rowsUpdated > 2;
        } catch (SQLException e) {
            log.error(e.getMessage());
			log.error("SQL State: " + e.getSQLState());
			log.error("Error Code: " + e.getErrorCode());
        }
		return false;
	}

	@Override
	public boolean updateBalance(User user) {
        int index = 0;
        try(Connection conn = ConnectionUtil.getConnection()) {
            //Prepare the object that executes the query to update the balance
            PreparedStatement stmt = conn.prepareStatement("UPDATE account SET balance = ? WHERE accountNumber = ?");
            stmt.setDouble(++index, user.getBalance());
            stmt.setInt(++index, user.getAccountNumber());

            //If this variable is less than 1, then the balance update query failed.
            int rowsUpdated = 0;
            rowsUpdated += stmt.executeUpdate();
           
            //Log balance update
            if (rowsUpdated == 0)
                log.error("Error updating the balance of account: " + user.getAccountNumber());
            else   
                log.info("Successfully updated balance to: " + user.getBalance() + " of account: " + user.getAccountNumber());
            
            return rowsUpdated > 0;
        } catch (SQLException e) {
            log.error(e.getMessage());
			log.error("SQL State: " + e.getSQLState());
			log.error("Error Code: " + e.getErrorCode());
        }
		return false;
	}

	@Override
	public boolean approveUser(int accountNum) {
		int index = 0;
        try(Connection conn = ConnectionUtil.getConnection()) {
            //Prepare the object that executes the query to update the isApproved value
            PreparedStatement stmt = conn.prepareStatement("UPDATE bankuser SET isApproved = 1 WHERE accountNumber = ?");
            stmt.setInt(++index, accountNum);

            //If this variable is less than 1, then the isApproved value update failed.
            int rowsUpdated = 0;
            rowsUpdated += stmt.executeUpdate();
           
            //Log isApproved value update
            if (rowsUpdated == 0)
                log.error("Error updating isApproved value of account: " + accountNum);
            else   
                log.info("Successfully updated isApproved value to: true of account: " + accountNum);
            
            return rowsUpdated > 0;
        } catch (SQLException e) {
            log.error(e.getMessage());
			log.error("SQL State: " + e.getSQLState());
			log.error("Error Code: " + e.getErrorCode());
        }
		return false;
	}

	@Override
	public boolean makeAdmin(int accountNum) {
		int index = 0;
        try(Connection conn = ConnectionUtil.getConnection()) {
            //Prepare the object that executes the query to update the isAdmin value
            PreparedStatement stmt = conn.prepareStatement("UPDATE bankuser SET isAdmin = 1 WHERE accountNumber = ?");
            stmt.setInt(++index, accountNum);

            //If this variable is less than 1, then the isAdmin value update failed.
            int rowsUpdated = 0;
            rowsUpdated += stmt.executeUpdate();
           
            //Log isAdmin value update
            if (rowsUpdated == 0)
                log.error("Error updating isAdmin value of account: " + accountNum);
            else   
                log.info("Successfully updated isAdmin value to: true of account: " + accountNum);
            
            return rowsUpdated > 0;
        } catch (SQLException e) {
            log.error(e.getMessage());
			log.error("SQL State: " + e.getSQLState());
			log.error("Error Code: " + e.getErrorCode());
        }
		return false;
	}

	@Override
	public User getUser(int accNum, String passwd) {
        int index = 0;
        try(Connection conn = ConnectionUtil.getConnection()) {
            //Prepare the object that executes the query to update retrieve user info if credentials are correct.
            PreparedStatement stmt = conn.prepareStatement("SELECT bankuser.accountNumber, firstName," + 
            " lastName, isAdmin, isApproved, balance FROM bankuser INNER JOIN  p4ssw0rd ON " +
            "bankuser.accountNumber = p4ssw0rd.accountNumber INNER JOIN account ON " +
            "bankuser.accountNumber = account.accountNumber WHERE bankuser.accountNumber = ? AND p4ssw0rd.pass = ?");
            stmt.setInt(++index, accNum);
            stmt.setString(++index, passwd);
            
            ResultSet rs = stmt.executeQuery();

            //Log if credentials were correct or not
            if (rs.next() == false){
                log.error("Incorrect credentials, login failed.");
                return null;
            }
            else   
                log.info("Successfully retrieved the user with the provided credentials.");
            
            //Return new User object with the info retrieved
            return new User(rs.getInt("isAdmin"), rs.getInt("isApproved"), rs.getString("firstName"),
                        rs.getString("lastName"), rs.getInt("accountNumber"), rs.getDouble("balance"), "dummy");
        } catch (SQLException e) {
            log.error(e.getMessage());
			log.error("SQL State: " + e.getSQLState());
			log.error("Error Code: " + e.getErrorCode());
        }
		return null;
	}

	@Override
	public List<User> getWaitingUsers() {
        int index = -1;
        List<User> userList = new ArrayList<>();
        try(Connection conn = ConnectionUtil.getConnection()) {
            //Prepare the statement that will receive a ResultSet containing the users with isApproved = 0
            PreparedStatement stmt = conn.prepareStatement("SELECT bankuser.accountNumber, firstName," + 
            " lastName, isAdmin, isApproved, balance FROM bankuser INNER JOIN  p4ssw0rd ON " +
            "bankuser.accountNumber = p4ssw0rd.accountNumber INNER JOIN account ON " +
            "bankuser.accountNumber = account.accountNumber WHERE isApproved = 0");

            ResultSet rs = stmt.executeQuery();
            
            //Iterate through the ResultSet and add each user to the list
            while(rs.next()){
                userList.add(++index, new User(rs.getInt("isAdmin"), rs.getInt("isApproved"), rs.getString("firstName"),
                rs.getString("lastName"), rs.getInt("accountNumber"), rs.getDouble("balance"), "dummy"));
            }
            return userList;
        } catch (SQLException e) {
            log.error(e.getMessage());
			log.error("SQL State: " + e.getSQLState());
			log.error("Error Code: " + e.getErrorCode());
        }
		return null;
	}

	@Override
	public int getLastAccountNumber() {
        try(Connection conn = ConnectionUtil.getConnection()){
            //Get newly generated accountNumber
            int accNum = 0;
            String getLastRowFromBankUserQuery = "SELECT * FROM " + 
            "(select * from bankuser ORDER BY accountNumber DESC) WHERE rownum <= 1 ORDER BY rownum DESC";
            PreparedStatement stmt = conn.prepareStatement(getLastRowFromBankUserQuery);
            ResultSet rs = stmt.executeQuery();
            if (rs.next())
                accNum = rs.getInt("accountNumber");
            else
                log.error("Error occured with the ResultSet return when fetching the last row for the accountNumber.");
            return accNum;
        } catch (SQLException e) {
            log.error(e.getMessage());
			log.error("SQL State: " + e.getSQLState());
			log.error("Error Code: " + e.getErrorCode());
        }
        return 0;
	}

}