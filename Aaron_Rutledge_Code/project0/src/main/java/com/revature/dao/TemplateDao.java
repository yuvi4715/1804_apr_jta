package com.revature.dao;

import java.util.List;

import com.revature.model.AccountHolder;

public interface TemplateDao<T,K> {
	
	boolean insert(T t);	// Create
	public T get(K key);	// Read
	public List<T> getAll();
	public boolean update(T t);	// Update
	public boolean delete(K key); // Delete
	public T login(K key, String pass);
	public boolean updateStatus(K key);
	

}
