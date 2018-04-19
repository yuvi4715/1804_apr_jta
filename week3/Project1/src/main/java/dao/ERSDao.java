package dao;

import model.Employee;
import model.Requests;

import java.util.List;

/**
 * Created by bryanvillegas on 4/19/18.
 */
public interface ERSDao {
    public boolean insertEmp(Employee user);
    public boolean insertManager(Employee user);
    public Employee getEmp(String user, String password);
    public List<Employee> getAllEmps();
    public boolean updateEmp();

    public boolean insertRequest();
    public List<Requests> getAllRequests();
    public boolean updateRequests();
    public boolean deleteRequests();
}
