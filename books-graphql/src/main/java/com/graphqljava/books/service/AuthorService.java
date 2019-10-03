package com.graphqljava.books.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.graphqljava.books.model.Author;
import com.graphqljava.books.repository.AuthorRepository;

@Component
public class AuthorService {

	@Autowired
	private AuthorRepository authorRepository;
	
	public List<Author> findAllAuthors() {
		return this.authorRepository.findAll();
	}
	
	public Long countAuthors() {
		return this.authorRepository.count();
	}

	public Author createAuthor(String firstName, String lastName) {
		Author author = new Author();
		author.setFirstName(firstName);
		author.setLastName(lastName);
		return this.authorRepository.save(author);
	}

	public Optional<Author> getAuthor(Long authorId) {
		return this.authorRepository.findById(authorId);
	}

}
