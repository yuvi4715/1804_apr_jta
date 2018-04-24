package service;

import dao.ERSDao;
import dao.ERSDaoImp;
import model.Employee;
import model.Requests;

import java.util.List;

/**
 * Created by bryanvillegas on 4/19/18.
 */
public class ERSService {

    private static ERSDao dao = new ERSDaoImp();
    public static boolean insertEmp(Employee emp){
        return dao.insertEmp(emp);
    }
    public static Employee getEmp(String user, String password){
        return dao.getEmp(user, password);
    }
    public static boolean insertRequest(int id, double amount, String pur){
        return dao.insertRequest(id, amount, pur);
    }
    public static List<Requests> getAllRequests(int id){
        return dao.getAllRequests(id);
    }
    public static List<Employee> getAllEmps(){
        return dao.getAllEmps();
    }
    public static boolean updateRequests(int id, int manId){
        return dao.updateRequests(id, manId);
    }
    public static List<Requests> getAllEmpRequests(){
        return dao.getAllEmpRequests();
    }

}
