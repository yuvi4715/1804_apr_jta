package Bank.dao;

import Bank.dao.BankDao;
import Bank.model.Accounts;
import Bank.model.User;
import Bank.util.ConnectionUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by bryanvillegas on 4/15/18.
 */
public class BankDaoImp implements BankDao {


    public boolean insertUser(User user) {
        int index = 0;
        try(Connection conn = ConnectionUtil.getConnection()){
            CallableStatement stmt = conn.prepareCall("{CALL insert_user(?,?)}");
            stmt.setString(++index, user.getUserName());
            stmt.setString(++index, user.getPassword());

            return stmt.executeUpdate() > 0;
        } catch(SQLException sqle){
            System.err.println(sqle.getMessage());
            System.err.println("SQL State: " + sqle.getSQLState());
            System.err.println("Error Code: " + sqle.getErrorCode());
        }
        return false;
    }

    public User getUser(String username, String password) {
        int index = 0;
        try(Connection conn = ConnectionUtil.getConnection()){
            PreparedStatement stmt = conn.prepareStatement("SELECT * FROM bankUsers WHERE username = ? AND userPassword = ?");

            stmt.setString(++index, username);
            stmt.setString(++index, password);

            ResultSet rs = stmt.executeQuery();
            if(rs.next()){
                return new User(rs.getInt("user_id"), rs.getString("username"), rs.getString("userPassword"),
                        rs.getBoolean("isApproved"), rs.getBoolean("isAdmin"));
            }
        } catch(SQLException sqle){
            System.err.println(sqle.getMessage());
            System.err.println("SQL State: " + sqle.getSQLState());
            System.err.println("Error Code: " + sqle.getErrorCode());
        }
        return null;
    }

    public List<User> getAllUsers() {
        int index = 0;
        try (Connection conn = ConnectionUtil.getConnection()) {
            List<User> users = new ArrayList<>();
            PreparedStatement stmt = conn.prepareStatement("SELECT * FROM bankUsers");

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                users.add(new User(rs.getInt("user_id"), rs.getString("username"), rs.getString("userPassword"),
                        rs.getBoolean("isApproved"), rs.getBoolean("isAdmin")));
            }
            return users;
        } catch (SQLException sqle) {
            System.err.println(sqle.getMessage());
            System.err.println("SQL State: " + sqle.getSQLState());
            System.err.println("Error Code: " + sqle.getErrorCode());
        }
        return null;
    }

    public boolean updateUser(int id) {
        int index = 0;
        try (Connection conn = ConnectionUtil.getConnection()) {

            CallableStatement stmt = conn.prepareCall("{CALL update_user(?)}");
            stmt.setInt(++index, id);

            return stmt.executeUpdate() > 0;

        } catch (SQLException sqle) {
            System.err.println(sqle.getMessage());
            System.err.println("SQL State: " + sqle.getSQLState());
            System.err.println("Error Code: " + sqle.getErrorCode());
        }
        return false;
    }


    @Override
    public boolean insertAccount(int id) {
        int index = 0;
        try(Connection conn = ConnectionUtil.getConnection()){
            CallableStatement stmt = conn.prepareCall("{CALL insert_account(?)}");
            stmt.setInt(++index, id);


            return stmt.executeUpdate() > 0;
        } catch(SQLException sqle){
            System.err.println(sqle.getMessage());
            System.err.println("SQL State: " + sqle.getSQLState());
            System.err.println("Error Code: " + sqle.getErrorCode());
        }
        return false;
    }

    @Override
    public List<Accounts> getAllAccounts(int id) {
        int index = 0;
        try (Connection conn = ConnectionUtil.getConnection()) {
            List<Accounts> accounts = new ArrayList<>();
            PreparedStatement stmt = conn.prepareStatement("SELECT * FROM accounts WHERE account_user_id = ?");

            stmt.setInt(++index, id);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                accounts.add(new Accounts(rs.getInt("account_id"), rs.getDouble("moneyAmount")));
            }
            return accounts;
        } catch (SQLException sqle) {
            System.err.println(sqle.getMessage());
            System.err.println("SQL State: " + sqle.getSQLState());
            System.err.println("Error Code: " + sqle.getErrorCode());
        }
        return null;
    }


    @Override
    public boolean updateAccount(int id, double newAmount) {
        int index = 0;
        try (Connection conn = ConnectionUtil.getConnection()) {

            CallableStatement stmt = conn.prepareCall("{CALL update_accounts(?,?)}");
            stmt.setInt(++index, id);
            stmt.setDouble(++index, newAmount);

            return stmt.executeUpdate() > 0;

        } catch (SQLException sqle) {
            System.err.println(sqle.getMessage());
            System.err.println("SQL State: " + sqle.getSQLState());
            System.err.println("Error Code: " + sqle.getErrorCode());
        }
        return false;
    }

    @Override
    public boolean deleteAccount(int id) {
        return false;
    }
    @Override
    public boolean insertAdmin(User user){

        int index = 0;
        try(Connection conn = ConnectionUtil.getConnection()){
            CallableStatement stmt = conn.prepareCall("{CALL insert_admin(?,?)}");
            stmt.setString(++index, user.getUserName());
            stmt.setString(++index, user.getPassword());

            return stmt.executeUpdate() > 0;
        } catch(SQLException sqle){

            System.err.println(sqle.getMessage());
            System.err.println("SQL State: " + sqle.getSQLState());
            System.err.println("Error Code: " + sqle.getErrorCode());
        }
        return false;

    }


}
