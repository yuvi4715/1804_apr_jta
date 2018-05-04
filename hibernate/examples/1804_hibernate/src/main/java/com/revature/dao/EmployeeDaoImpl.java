package com.revature.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.revature.model.EmployeeAnn;
import com.revature.model.EmployeeXML;
import com.revature.util.HibernateUtil;

public class EmployeeDaoImpl implements EmployeeDao {

	public void insertEmployee(EmployeeXML emp) {

		Session session = HibernateUtil.getSession().openSession();
		Transaction t1 = null;
		try {
			t1 = session.beginTransaction();
			session.save(emp);
			t1.commit();
			// save and persist
		} catch (HibernateException h) {

		} finally {
			session.close();
		}

	}

	public void insertEmployeeAnn(EmployeeAnn emp) {

		Session session = HibernateUtil.getSession().openSession();
		Transaction t1 = null;
		try {
			t1 = session.beginTransaction();
			session.save(emp);
			t1.commit();
			// save and persist
		} catch (HibernateException h) {

		} finally {
			session.close();
		}

	}
}
