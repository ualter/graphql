package com.graphql.mortgages.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.graphql.mortgages.model.Borrower;

@Repository
public interface BorrowerRepository extends JpaRepository<Borrower, Long>{

}
