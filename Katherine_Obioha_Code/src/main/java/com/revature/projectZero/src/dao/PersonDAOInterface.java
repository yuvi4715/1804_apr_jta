package com.kobio.dao;

import java.sql.SQLException;
import java.util.List;

import com.kobio.model.Person;

public interface PersonDAOInterface {

	public boolean CreatePerson(Person person) throws SQLException;
	public Person getPerson(String username);
	public List<Person>getAllPerson();
	public boolean updatePerson(Person customer);
	public boolean deletePerson(Person customer);
}
