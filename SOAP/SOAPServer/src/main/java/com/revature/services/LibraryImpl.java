package com.revature.services;

import java.util.ArrayList;
import java.util.List;

import javax.jws.WebService;

import com.revature.beans.Book;
import com.revature.exception.LibraryYearException;

/*
 * The WebService endpoint tells apache cxf that this class's implementation wil be used
 * for SOAP interactions. Therefore, a WSDL will be generated that serves as teh contract
 * for these methods. CONTRACT LAST
 */
@WebService(endpointInterface="com.revature.services.Library")
public class LibraryImpl implements Library {
	
	public static List<Book> bookList = new ArrayList<>();

	@Override
	public List<Book> getAllBooks() {
		System.out.println("=======GET ALL BOOKS INVOKED======");
		return bookList;
	}

	@Override
	public String addBook(Book book) throws LibraryYearException {
		System.out.println("=======ADDING A BOOK=======");
		System.out.println("Adding: " + book);
		bookList.add(book);
		if(book.getYear()< 2000){
			throw new LibraryYearException("This book is too old! Ew!");
		}
		return "Successefully added a new book, with the title: " + book.getTitle();
	}

}
