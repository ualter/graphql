package com.graphql.mortgages.mutation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.graphql.mortgages.model.Lender;
import com.graphql.mortgages.service.LenderService;

@Component
public class LenderMutationResolver implements GraphQLMutationResolver {
	
	@Autowired
	private LenderService lenderService;
	
	public Lender newLender(String name, Boolean isBank) {
		return this.lenderService.saveLender(name, isBank);
	}
	
    public Boolean deleteLender(Long lenderId) {
    	return this.lenderService.deleteLender(lenderId);
    }


}
