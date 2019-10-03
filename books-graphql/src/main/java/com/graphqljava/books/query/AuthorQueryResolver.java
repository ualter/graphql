package com.graphqljava.books.query;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.graphqljava.books.model.Author;
import com.graphqljava.books.service.AuthorService;


@Component
public class AuthorQueryResolver implements GraphQLQueryResolver {

	@Autowired
	private AuthorService authorService;
	
	public List<Author> findAllAuthors() {
		return this.authorService.findAllAuthors();
	}
	
	public Long countAuthors() {
		return this.authorService.countAuthors();
	}
	
    
}