package com.graphql.mortgages.query;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.graphql.mortgages.model.Lender;
import com.graphql.mortgages.service.LenderService;

@Component
public class LenderQueryResolver implements GraphQLQueryResolver {
	
	@Autowired
	private LenderService lenderService;
	
	public List<Lender> findAllLenders() {
		return lenderService.listAllLenders();
	}
	
    public Long countLenders() {
    	return lenderService.countTotal();
    }

}
