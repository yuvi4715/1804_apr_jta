package com.revature.db;

import com.revature.models.Employee;
import com.revature.models.Manager;
import com.revature.models.ReinbursementRequest;

public class DatabaseSingletonService {
	private static DatabaseSingleton db = DatabaseSingletonImpl.getInstance();
	private DatabaseSingletonService() {}
	public static Employee loginEmployee(Employee e, String password) {
		return db.login(e, password);
	}
	public static Manager loginManager(Manager m, String password) {
		return db.login(m, password);
	}
	public static boolean create(Employee e,String password){
		return db.create(e, password);
	}
	public static boolean create(Manager m,String password){
		return db.create(m, password);
	}
	public static boolean create(ReinbursementRequest r){
		return db.create(r);
	}
	public static boolean update(Employee e,String newEmail){
		return db.update(e, newEmail);
	}
	public static boolean update(Manager m,String newEmail){
		return db.update(m, newEmail);
	}
	public static boolean update(ReinbursementRequest r){
		return db.update(r);
	}
	public static Employee readEmployee(String email){
		return db.readEmployee(email);
	}
	public static Manager readManager(String email){
		return db.readManager(email);
	}
	public static ReinbursementRequest readRR(long id){
		return db.readRR(id);
	}
	public static boolean delete(Employee e){
		return db.delete(e);
	}
	public static boolean delete(Manager m){
		return db.delete(m);
	}
	public static boolean delete(ReinbursementRequest r){
		return db.delete(r);
	}
	public static Employee[] getAllEmployees(int page){
		return db.getAllEmployees(page);
	}
	public static ReinbursementRequest[] getAllRRs(int page){
		return db.getAllRRs(page);
	}
	public static ReinbursementRequest[] getAllRRs(int page,String email){
		return db.getAllRRs(page,email);
	}
	public static ReinbursementRequest[] getAllRRSearch(int page,String search){
		return db.getAllRRs(search,page);
	}
	public static ReinbursementRequest[] getAllRRsSearch(int page,String email,String search){
		return db.getAllRRs(page, email, search);
	}
	public static ReinbursementRequest[] getAllUnresolvedRRs(int page){
		return db.getAllUnresolvedRRs(page);
	}
	public static ReinbursementRequest[] getAllUnresolvedRRs(int page,String email){
		return db.getAllUnresolvedRRs(page,email);
	}
	public static ReinbursementRequest[] getAllUnresolvedRRsSearch(int page,String search){
		return db.getAllUnresolvedRRs(search,page);
	}
	public static ReinbursementRequest[] getAllUnresolvedRRsSearch(int page,String email,String search){
		return db.getAllUnresolvedRRs(page,email,search);
	}
}
