package com.graphql.mortgages.mutation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.graphql.mortgages.model.Borrower;
import com.graphql.mortgages.service.BorrowerService;

@Component
public class BorrowerMutationResolver implements GraphQLMutationResolver {
	
	@Autowired
	private BorrowerService borrowerService;
	
	public Borrower newBorrower(String eyeColor, String name, String gender) {
		return this.borrowerService.saveBorrower(eyeColor, name, gender);
	}
	
    public Boolean deleteBorrower(Long borrowerId) {
    	return this.borrowerService.deleteBorrower(borrowerId);
    }
}


