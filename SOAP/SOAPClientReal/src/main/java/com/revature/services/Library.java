package com.revature.services;

import java.util.List;

import javax.jws.WebService;

import com.revature.beans.Book;
import com.revature.exception.LibraryYearException;

@WebService
public interface Library {
	List<Book> getAllBooks();
	String addBook(Book book) throws LibraryYearException;
}
