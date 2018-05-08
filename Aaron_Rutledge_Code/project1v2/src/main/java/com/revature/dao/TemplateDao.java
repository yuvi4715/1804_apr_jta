package com.revature.dao;

import java.util.List;

public interface TemplateDao<T,K> {
	
	boolean insert(T t);	// Create
	public T get(Integer id); // Read
	public List<T> getAll();
	public boolean update(T t);	// Update
	public boolean updateEmail(T t);
	public boolean delete(K key); // Delete
	public T login(String email, String pass);
	public boolean updateStatus(K key, int newStatus);
	public List<T> getBy(String colName, Integer num);
	public List<T> getBy(String colName, String str);
	
	

}