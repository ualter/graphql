package com.graphql.mortgages.query;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.graphql.mortgages.model.Loan;
import com.graphql.mortgages.service.LoanService;

@Component
public class LoanQueryResolver implements GraphQLQueryResolver {
	
	@Autowired
	private LoanService loanService;
	
	public List<Loan> findAllLoans() {
		return this.loanService.listAllLoans();
	}
	
	public Long countLoans() {
		return this.loanService.countTotal();
	}
	
	public List<Loan> findAllLoansCreditGreaterThan(Float credit) {
		return this.loanService.findAllLoansCreditGreaterThan(credit);
	}
	
	public Float sumCreditAllLoans() {
		return this.loanService.sumCreditAllLoans();
	}

}
