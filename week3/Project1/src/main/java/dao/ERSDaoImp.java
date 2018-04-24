package dao;

import model.Employee;
import model.Requests;
import util.ConnectionUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by bryanvillegas on 4/19/18.
 */
public class ERSDaoImp implements ERSDao{

    public boolean insertEmp(Employee emp){
        int index = 0;
        try(Connection conn = ConnectionUtil.getConnection()){
            CallableStatement stmt = conn.prepareCall("{CALL insert_emp(?,?,?,?)}");
            stmt.setString(++index, emp.getUsername());
            stmt.setString(++index, emp.getPassword());
            stmt.setString(++index, emp.getFirstName());
            stmt.setString(++index, emp.getLastName());

            return stmt.executeUpdate() > 0;
        } catch(SQLException sqle){
            System.err.println(sqle.getMessage());
            System.err.println("SQL State: " + sqle.getSQLState());
            System.err.println("Error Code: " + sqle.getErrorCode());
        }
        return false;
    }
    public Employee getEmp(String user, String password){

        int index = 0;
        try(Connection conn = ConnectionUtil.getConnection()){
            PreparedStatement stmt = conn.prepareStatement("SELECT * FROM employee WHERE email = ? AND password = ?");

            stmt.setString(++index, user);
            stmt.setString(++index, password);

            ResultSet rs = stmt.executeQuery();
            if(rs.next()){
                return new Employee(rs.getInt("employee_id"), rs.getString("email"), rs.getString("password"),
                        rs.getString("firstname"), rs.getString("lastname"));
            }
        } catch(SQLException sqle){
            System.err.println(sqle.getMessage());
            System.err.println("SQL State: " + sqle.getSQLState());
            System.err.println("Error Code: " + sqle.getErrorCode());
        }
        return null;


    }
    //public boolean insertManager(Employee user){}
    public List<Employee> getAllEmps(){
        int index = 0;
        try (Connection conn = ConnectionUtil.getConnection()) {
            List<Employee> emps = new ArrayList<>();
            PreparedStatement stmt = conn.prepareStatement("SELECT * FROM employee");

            ResultSet rs = stmt.executeQuery();
            //nt empID, String username, String password, String firstName, String lastName, boolean isManager

            while (rs.next()) {
                emps.add(new Employee(rs.getInt("employee_id"), rs.getString("email"),
                        rs.getString("password"), rs.getString("firstname"),
                        rs.getString("lastname")));
            }
            return emps;
        } catch (SQLException sqle) {
            System.err.println(sqle.getMessage());
            System.err.println("SQL State: " + sqle.getSQLState());
            System.err.println("Error Code: " + sqle.getErrorCode());
        }
        return null;
    }
//    public boolean updateEmp(){}

    public boolean insertRequest(int id, double amount, String pur){
        int index = 0;
        try(Connection conn = ConnectionUtil.getConnection()){
            CallableStatement stmt = conn.prepareCall("{CALL insert_request(?,?,?)}");
            stmt.setInt(++index, id);
            stmt.setDouble(++index, amount);
            stmt.setString(++index, pur);


            return stmt.executeUpdate() > 0;
        } catch(SQLException sqle){
            System.err.println(sqle.getMessage());
            System.err.println("SQL State: " + sqle.getSQLState());
            System.err.println("Error Code: " + sqle.getErrorCode());
        }
        return false;
    }
    public List<Requests> getAllRequests(int id){
        int index = 0;
        try (Connection conn = ConnectionUtil.getConnection()) {
            List<Requests> requests = new ArrayList<>();
            PreparedStatement stmt = conn.prepareStatement("SELECT * FROM request WHERE requested_by= ?");

            stmt.setInt(++index, id);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                requests.add(new Requests(rs.getInt("request_id"), rs.getString("purpose"),
                        rs.getDouble("request_amount"), rs.getInt("requested_by"),
                        (Integer)rs.getInt("approved_by"), rs.getBoolean("status")));
            }
            return requests;
        } catch (SQLException sqle) {
            System.err.println(sqle.getMessage());
            System.err.println("SQL State: " + sqle.getSQLState());
            System.err.println("Error Code: " + sqle.getErrorCode());
        }
        return null;
    }
    public boolean updateRequests(int id, int manId){

        int index = 0;
        try (Connection conn = ConnectionUtil.getConnection()) {

            CallableStatement stmt = conn.prepareCall("{CALL update_request(?,?)}");
            stmt.setInt(++index, id);
            stmt.setInt(++index, manId);

            return stmt.executeUpdate() > 0;

        } catch (SQLException sqle) {
            System.err.println(sqle.getMessage());
            System.err.println("SQL State: " + sqle.getSQLState());
            System.err.println("Error Code: " + sqle.getErrorCode());
        }
        return false;
    }
    //public boolean deleteRequests(){}
    public List<Requests> getAllEmpRequests(){
        int index = 0;
        try (Connection conn = ConnectionUtil.getConnection()) {
            List<Requests> requests = new ArrayList<>();
            PreparedStatement stmt = conn.prepareStatement("SELECT * FROM request");

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                requests.add(new Requests(rs.getInt("request_id"), rs.getString("purpose"),
                        rs.getDouble("request_amount"), rs.getInt("requested_by"),
                        (Integer)rs.getInt("approved_by"), rs.getBoolean("status")));
            }
            return requests;
        } catch (SQLException sqle) {
            System.err.println(sqle.getMessage());
            System.err.println("SQL State: " + sqle.getSQLState());
            System.err.println("Error Code: " + sqle.getErrorCode());
        }
        return null;

    }
}
