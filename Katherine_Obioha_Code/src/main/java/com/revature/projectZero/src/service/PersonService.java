package com.kobio.service;

import java.sql.SQLException;
import java.util.List;

import com.kobio.controller.Controller;
import com.kobio.dao.*;
import com.kobio.model.*;



public class PersonService {

	private static PersonDAOInterface dao = PersonDAO.getInstance();
	
	
	public PersonService() {
		
		
	}
	
	public static List<Person>getAllPerson()
	{
		return dao.getAllPerson();
	}
	
	public static Person getCustomer(String username)
	{
		return dao.getPerson(username);
		 
		 
	}
	
	public static boolean CreatePerson(Person person)
	{
		
			try {
				return dao.CreatePerson(person);
			} catch (SQLException e) {
				System.out.println(e.getMessage());
				if(e.getMessage().contains("KATHERINE.USERNAMEUNIQUECONSTRAINT"))
				{
					System.out.println("Username is already in the database. Please select another username.");
					new Controller().fillinform(person.getRole());
				}
				if(e.getMessage().contains("KATHERINE.MINLENGTHCONSTRAINT"))
				{
					
					System.out.println("Minimum Length for username is 4");
					new Controller().fillinform(person.getRole());
				}
				if(e.getMessage().contains("KATHERINE.EMAILPATTERNCONSTRAINT"))
				{
					
					System.out.println("Email address is not valid");
					new Controller().fillinform(person.getRole());
				}
				if(e.getMessage().contains("KATHERINE.EMAILUNIQUECONSTRAINT"))
				{
					
					System.out.println("Email address is already in the database, please log in");
					new Controller().fillinform(person.getRole());
				}
			}
		
			return false;
	}

	
}
