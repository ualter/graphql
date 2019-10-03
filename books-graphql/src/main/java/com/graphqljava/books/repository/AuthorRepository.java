package com.graphqljava.books.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.graphqljava.books.model.Author;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long>{

}
