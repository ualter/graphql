package com.graphqljava.books.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode
@Entity
public class Author {

	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

	private String firstName;

	private String lastName;

	public Author() {
    }

	public Author(Long id) {
        this.id = id;
    }
}