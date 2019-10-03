package com.graphqljava.books.mutation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.graphqljava.books.model.Book;
import com.graphqljava.books.service.BookService;

@Component
public class BookMutationResolver implements GraphQLMutationResolver {
	
	@Autowired
	private BookService bookService;
	
	public Book newBook(String title, String isbn, Integer pageCount, Long authorId) {
		return this.bookService.createBook(title, isbn, pageCount, authorId);
	}
	
	public Boolean deleteBook(Long bookId) {
		return this.bookService.deleteBook(bookId);
	}
	
	public Book updateBookPageCount(Integer pageCount, Integer bookId) {
		return this.updateBookPageCount(pageCount, bookId);
	}


}
