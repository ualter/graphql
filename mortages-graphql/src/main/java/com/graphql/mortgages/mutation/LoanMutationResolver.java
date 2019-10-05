package com.graphql.mortgages.mutation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.graphql.mortgages.model.Lender;
import com.graphql.mortgages.model.Loan;
import com.graphql.mortgages.service.LoanService;

@Component
public class LoanMutationResolver implements GraphQLMutationResolver {
	
	@Autowired
	private LoanService loanService;
	
	public Loan newLoan(Float credit, Float interest, String foreignCurrency, Long borrowerId, List<Lender> lenders) {
		return this.loanService.saveLoans(credit, interest, foreignCurrency, borrowerId, lenders);
	}
	
    public Boolean deleteLoan(Long loanId) {
    	return this.loanService.deleteLoan(loanId);
    }


}
