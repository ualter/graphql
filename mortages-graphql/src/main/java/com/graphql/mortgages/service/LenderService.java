package com.graphql.mortgages.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.graphql.mortgages.model.Lender;
import com.graphql.mortgages.repository.LenderRepository;

@Component
public class LenderService {
	
	@Autowired
	private LenderRepository lenderRepository;
	
	public Lender saveLender(String name, Boolean isBank) {
		Lender lender = new Lender();
		lender.setName(name);
		lender.setIsBank(isBank);
		return this.lenderRepository.save(lender);
	}
	
    public Boolean deleteLender(Long lenderId) {
    	if ( this.lenderRepository.existsById( lenderId ) ) {
    		this.lenderRepository.deleteById(lenderId);
    		return true;
    	}
    	return false;
    }
    
    public Optional<Lender> getLender(Long lenderId) {
    	return this.lenderRepository.findById(lenderId);
    }
    
    public Boolean isValidLender(Long lenderId) {
    	return this.lenderRepository.existsById(lenderId);
    }

	public List<Lender> listAllLenders() {
		return this.lenderRepository.findAll();
	}

	public Long countTotal() {
		return this.lenderRepository.count();
	}
    
    
    

}
