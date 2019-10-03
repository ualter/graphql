package com.graphqljava.books.mutation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.graphqljava.books.model.Author;
import com.graphqljava.books.service.AuthorService;

@Component
public class AuthorMutationResolver implements GraphQLMutationResolver {
	
	@Autowired
	private AuthorService authorService;
	
	public Author newAuthor(String firstName, String lastName) {
		return this.authorService.createAuthor(firstName, lastName);
	}

}
