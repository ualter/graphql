package com.graphql.mortgages.query;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.graphql.mortgages.model.Borrower;
import com.graphql.mortgages.service.BorrowerService;

@Component
public class BorrowerQueryResolver implements GraphQLQueryResolver {
	
	@Autowired
	private BorrowerService borrowerService;
	
	public List<Borrower> findAllBorrowers() {
		return borrowerService.listAllBorrowers();
	}
	
    public Long countBorrowers() {
    	return borrowerService.countTotal();
    }

}



