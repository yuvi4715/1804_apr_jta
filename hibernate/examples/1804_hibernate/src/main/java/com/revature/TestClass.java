package com.revature;

import java.util.Date;
import com.revature.dao.EmployeeDaoImpl;
import com.revature.model.EmployeeAnn;
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
		
		EmployeeAnn e1 = new EmployeeAnn(1, "Tom", "SDET", new Date(), "Yuvi");
		EmployeeDaoImpl ed1 = new EmployeeDaoImpl();
		ed1.insertEmployeeAnn(e1);
	}

}
