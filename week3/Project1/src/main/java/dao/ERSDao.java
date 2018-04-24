package dao;

import model.Employee;
import model.Requests;

import java.util.List;

/**
 * Created by bryanvillegas on 4/19/18.
 */
public interface ERSDao {
    boolean insertEmp(Employee user);
    //boolean insertManager(Employee user);
    Employee getEmp(String user, String password);
    List<Employee> getAllEmps();
    //public boolean updateEmp();

    boolean insertRequest(int id, double amount, String pur);
    List<Requests> getAllRequests(int id);
    List<Requests> getAllEmpRequests();
    boolean updateRequests(int id, int manId);
    //public boolean deleteRequests();
}
