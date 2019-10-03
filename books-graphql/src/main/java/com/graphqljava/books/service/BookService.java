package com.graphqljava.books.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.graphqljava.books.error.handler.BookNotFoundException;
import com.graphqljava.books.model.Book;
import com.graphqljava.books.repository.BookRepository;

@Component
public class BookService {
	
	@Autowired
	private BookRepository bookRepository;
	
	@Autowired
	private AuthorService authorService;

	public List<Book> findAllBooks() {
		return this.bookRepository.findAll();
	}

	public Long countBooks() {
		return this.bookRepository.count();
	}

	public Book createBook(String title, String isbn, Integer pageCount, Long authorId) {
		Book book = new Book();
		book.setTitle(title);
		book.setIsbn(isbn);
		book.setPageCount(pageCount);
		book.setAuthor(authorService.getAuthor(authorId).get());
		return this.bookRepository.save(book);
	}
	
	public Boolean deleteBook(Long bookId) {
		if ( this.bookRepository.existsById(bookId) ) {
			this.bookRepository.deleteById(bookId);
			return true;
		}
		return false;
	}
	
	public Book updateBookPageCount(Integer pageCount, Long bookId) {
		Book book = this.bookRepository.findById(bookId).orElseThrow(() -> new BookNotFoundException("Book not Found!!!", bookId));
		book.setPageCount(pageCount);
		this.bookRepository.save(book);
		return book;
	}

		


}
