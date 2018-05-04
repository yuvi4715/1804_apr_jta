package com.revature;

import java.util.Date;
import com.revature.dao.EmployeeDaoImpl;
import com.revature.model.Employee;
import com.revature.model.EmployeeXML;

public class TestClass {

	public static void main(String[] args) {
		
//		EmployeeXML e1 = new EmployeeXML("Tom", "SDET", new Date(), "Yuvi");
////		EmployeeXML e2 = new EmployeeXML(2, "Oscar", "SDET", new Date(), "Yuvi");
////		EmployeeXML e3 = new EmployeeXML(3, "Tony", "JTA", new Date(), "Yuvi");
////		EmployeeXML e4 = new EmployeeXML(4, "Lee", "SDET", new Date(), "Yuvi");
//		
//		EmployeeDaoImpl ed1 = new EmployeeDaoImpl();
//		ed1.insertEmployee(e1);
////		ed1.insertEmployee(e2);
////		ed1.insertEmployee(e3);
////		ed1.insertEmployee(e4);
		
		//Employee e1 = new Employee("Jean", "SDET", new Date(), "Yuvi");
		EmployeeDaoImpl ed1 = new EmployeeDaoImpl();
		//ed1.insertEmployee(e1);
		//ed1.updateEmployee(602, "Clayton");
//		System.out.println(ed1.findEmployeeById(603));
//		System.out.println(ed1.getAllEmployees());
//		ed1.HQLExample(3);
		//ed1.namedQueriesExample();
		//ed1.getVSLoad(1);
		//ed1.getVSLoad(20);
		//ed1.criteriaExample();
		ed1.saveVSPersist();
	}

}
