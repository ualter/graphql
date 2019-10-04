package com.graphql.mortgages.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.graphql.mortgages.model.Loan;

@Repository
public interface LoanRepository extends JpaRepository<Loan, Long>  {

}
