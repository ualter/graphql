package com.graphqljava.books.query;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.graphqljava.books.model.Book;
import com.graphqljava.books.service.BookService;


@Component
public class BookQueryResolver implements GraphQLQueryResolver {
	

	@Autowired
	private BookService bookService;
	
	public List<Book> findAllBooks() {
		return this.bookService.findAllBooks();
	}
	
	public Long countBooks() {
		return this.bookService.countBooks();
	}
	
    
}