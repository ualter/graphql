package com.graphql.mortgages.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.graphql.mortgages.model.Loan;

@Repository
public interface LoanRepository extends JpaRepository<Loan, Long>  {
	
	
	@Query("SELECT l from Loan l WHERE l.credit >= ?1")
	List<Loan> findAllLoansCreditGreaterThan(Float credit);
	
	@Query("SELECT SUM(l.credit) from Loan l")
	Float sumCreditAllLoans();

}
