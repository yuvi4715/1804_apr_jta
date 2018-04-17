package com.kobio.dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.kobio.connection.ConnectionProperties;
import com.kobio.controller.Controller;
import com.kobio.model.Account;
import com.kobio.model.Person;




public class PersonDAO implements PersonDAOInterface {

	final static Logger logger =Logger.getLogger(PersonDAO.class);
	private static AccountDAOInterface accdao = AccountDAO.getInstance();
private static PersonDAO instance;
	
	private PersonDAO()
	{
		
	}
	
	public static PersonDAO getInstance()
	{
		if(instance == null)
		{
			instance = new PersonDAO();
		}
		return instance;
	}
	
	
	@Override
	public  boolean CreatePerson(Person person) throws SQLException  {
		// TODO Auto-generated method stub
		try(Connection conn = ConnectionProperties.getConnection())
		{
			PreparedStatement stmt = conn.prepareStatement("INSERT INTO Person"
					+ "(email, username, password, firstname, lastname, role, ssn) VALUES (?,?,?,?,?,?,?)");
		
			stmt.setString(1,person.getEmail());
			stmt.setString(2,person.getUsername());
			stmt.setString(3,person.getPassword());
			stmt.setString(4,person.getFirstname());
			stmt.setString(5,person.getLastname());
			stmt.setString(6,person.getRole());
			stmt.setString(7,person.getSsn());
			
			if(!stmt.execute())
			{  
				
				logger.info("gettin person id from person to create account for user");
				PreparedStatement stmt1 = conn.prepareStatement("SELECT personid "
						+ " FROM person WHERE email = ?");
				logger.info("setting values");
				
				stmt1.setString(1, person.getEmail());
				
				ResultSet result = stmt1.executeQuery();
				if(result.next()){
				Controller.p.setID(result.getInt("personid"));
				}
				logger.info("calling create account class");
				accdao.CreateAccount(Controller.a);
				
				return stmt.getUpdateCount()>0;
				
				
			}
		} finally{}
		
		
		
		return false;
	}

	@Override
	public Person getPerson(String username) {
		
		try(Connection conn = ConnectionProperties.getConnection())
		{
			PreparedStatement stmt = conn.prepareStatement("SELECT firstname, "
					+ "lastname, email, password, personid, role, ssn FROM person WHERE username = ?");
			stmt.setString(1, username);
			ResultSet rs = stmt.executeQuery();
			
			
			
			if(rs.next())
			{
	//			
			 Person person = new Person(rs.getString("firstname"), rs.getString("lastname"), username, rs.getString("password"), 
					 rs.getString("role"), rs.getString("ssn"), rs.getString("email"));
			 person.setID(rs.getInt("personid"));
			 accdao.getAccount(person.getID());
			 return person;
				
			}
			else
			{		logger.error("username is not in the database");
					System.out.println("Username is not in the database. Please sign up");
					new Controller().menu();
			
			}
		
		}
		catch(SQLException e)
		{
			System.err.println(e.getMessage());
			System.err.println(e.getSQLState());
			System.err.println(e.getErrorCode());
		}
		return null;
	}
	

	@Override
	public List<Person> getAllPerson() {
		// TODO Auto-generated method stub
		try(Connection conn= ConnectionProperties.getConnection())
		{
			List<Person>pers = new ArrayList<Person>();
			PreparedStatement stmt = conn.prepareStatement("SELECT firstname, "
					+ "lastname, email, password, personid, role, ssn, username FROM person");
			ResultSet rs = stmt.executeQuery();
			while(rs.next()){
				Person t = new Person();
				t.setFirstname(rs.getString("firstname"));
				t.setLastname(rs.getString("lastname"));
				t.setEmail(rs.getString("email"));
				t.setPassword(rs.getString("password"));
				t.setID(rs.getInt("personid"));
				t.setRole(rs.getString("role"));
				t.setSsn(rs.getString("ssn"));
				t.setUsername(rs.getString("username"));
				
				pers.add(t);
			}
			
			return pers;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean updatePerson(Person customer) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deletePerson(Person customer) {
		// TODO Auto-generated method stub
		return false;
	}



	
	}


