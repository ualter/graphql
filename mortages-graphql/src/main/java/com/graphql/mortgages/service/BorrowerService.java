package com.graphql.mortgages.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.graphql.mortgages.model.Borrower;
import com.graphql.mortgages.repository.BorrowerRepository;
import com.graphql.mortgages.utils.Utility;

@Component
public class BorrowerService {
	
	@Autowired
	private BorrowerRepository borrowerRepository;
	
	public Borrower saveBorrower(String eyeColor, String name, String gender) {
		Borrower borrower = new Borrower();
		borrower.setEyeColor(eyeColor);
		borrower.setName(name);
		borrower.setGender(gender);
		borrower.setAddress(Utility.address());
		borrower.setCompany(Utility.company());
		borrower.setEmail(Utility.email());
		borrower.setPhone(Utility.phone());
		borrower.setAge(Utility.age());
		borrower.setRegistered(Utility.dates());
		return this.borrowerRepository.save(borrower);
	}
	
    public Boolean deleteBorrower(Long borrowerId) {
    	if ( this.borrowerRepository.existsById( borrowerId ) ) {
    		this.borrowerRepository.deleteById(borrowerId);
    		return true;
    	}
    	return false;
    }
    
    public Optional<Borrower> getBorrower(Long borrowerId) {
    	return this.borrowerRepository.findById(borrowerId);
    }

	public List<Borrower> listAllBorrowers() {
		return this.borrowerRepository.findAll();
	}

	public Long countTotal() {
		return this.borrowerRepository.count();
	}
    
    
    

}
