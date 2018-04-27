package com.revature.db;

import java.util.List;

import com.revature.models.Employee;
import com.revature.models.Manager;
import com.revature.models.ReinbursementRequest;

public interface DatabaseSingleton {
	boolean create(Employee e,String password);
	boolean create(Manager m,String password);
	boolean create(ReinbursementRequest r);
	boolean update(Employee e,String newEmail);
	boolean update(Manager m,String newEmail);
	boolean update(ReinbursementRequest r);
	Employee readEmployee(String email);
	Manager readManager(String email);
	ReinbursementRequest readRR(long id);
	boolean delete(Employee e);
	boolean delete(Manager m);
	boolean delete(ReinbursementRequest r);
	Employee login(Employee e, String password);
	Manager login(Manager e, String password);
	Employee[] getAllEmployees(int page);
	ReinbursementRequest[] getAllRRs(int page);
	ReinbursementRequest[] getAllRRs(String search,int page);
	ReinbursementRequest[] getAllRRs(int page,String email);
	ReinbursementRequest[] getAllRRs(int page,String email,String search);
	ReinbursementRequest[] getAllUnresolvedRRs(int page);
	ReinbursementRequest[] getAllUnresolvedRRs(String search,int page);
	ReinbursementRequest[] getAllUnresolvedRRs(int page,String email);
	ReinbursementRequest[] getAllUnresolvedRRs(int page, String email,String search);
}
