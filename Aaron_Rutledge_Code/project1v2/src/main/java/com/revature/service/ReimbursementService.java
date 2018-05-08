package com.revature.service;


import java.util.List;

import com.revature.dao.ReimbursementDao;
import com.revature.dao.TemplateDao;
import com.revature.model.Reimbursement;

public class ReimbursementService {
	
	private static TemplateDao<Reimbursement, Integer> dao = new ReimbursementDao();
	
	private ReimbursementService() {}
	
	public static boolean insert(Reimbursement t) {
		
		return dao.insert(t);
		
	}
	
	public static Reimbursement get(Integer k) {
		
		return dao.get(k);
		
	}
	
	public static boolean update(Reimbursement t) {
		
		return dao.update(t);
		
	}
	
	public static List<Reimbursement> getAll() {
		
		return dao.getAll();
		
		
	}

	public static List<Reimbursement> getBy(String colName, Integer num) {
	
		return dao.getBy(colName, num);
	
	}
	
	public static List<Reimbursement> getBy(String colName, String str) {
		
		return dao.getBy(colName, str);
	
	}

}
