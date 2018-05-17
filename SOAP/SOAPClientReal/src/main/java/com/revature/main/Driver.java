package com.revature.main;

import java.io.PrintWriter;
import java.util.List;

import org.apache.cxf.interceptor.LoggingInInterceptor;
import org.apache.cxf.interceptor.LoggingOutInterceptor;
import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;

import com.revature.beans.Book;
import com.revature.services.Library;

public class Driver {

	public static void main(String[] args) {
		
		String serviceUrl = "http://localhost:8085/SOAPServer/Library";
		JaxWsProxyFactoryBean factory = new JaxWsProxyFactoryBean();
		factory.setServiceClass(Library.class); //Now our client knows the SOAP methods
		factory.setAddress(serviceUrl);
		
		//Following methods are used for intercepting data going and out.
		//Specific to SOAP
		LoggingInInterceptor inInterceptor = new LoggingInInterceptor();
		LoggingOutInterceptor outInterceptor = new LoggingOutInterceptor();
		factory.getInInterceptors().add(inInterceptor);
		factory.getOutInterceptors().add(outInterceptor);
		//Just as servlets have requests and response, SOAP has interceptors.
		inInterceptor.setPrintWriter(new PrintWriter(System.out));
		outInterceptor.setPrintWriter(new PrintWriter(System.out));
		
		//CONSUMING SOAP
		Library library = (Library) factory.create();
		try{
			System.out.println(library.addBook(new Book("Origin", "Dan Brown", 2017)));
			System.out.println(library.addBook(new Book("Bob Wars", "Bobbert", 2001)));
			System.out.println(library.addBook(new Book("Bobby Potter", "Bobbert", 2005)));
			System.out.println(library.addBook(new Book("Lord of the Bobberts", "Dan Brown", 1999)));
		}catch(Exception e){
			e.printStackTrace();
		}
		
		List<Book> bookList = library.getAllBooks();	
	}
}
