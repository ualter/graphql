package com.graphql.mortgages.service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.graphql.mortgages.error.handler.BorrowerNotFoundException;
import com.graphql.mortgages.error.handler.LenderNotFoundException;
import com.graphql.mortgages.model.Borrower;
import com.graphql.mortgages.model.Lender;
import com.graphql.mortgages.model.Loan;
import com.graphql.mortgages.repository.LoanRepository;
import com.graphql.mortgages.utils.Utility;

@Component
public class LoanService {
	
	@Autowired
	private BorrowerService borrowerService;
	@Autowired
	private LenderService lenderService;
	
	@Autowired
	private LoanRepository loanRepository;
	
	@Transactional
	public Loan saveLoans(Float credit, Float interest, String foreignCurrency, Long borrowerId, List<Lender> lendersId) {
		Loan loan = new Loan();
		
		Borrower borrower = this.borrowerService.getBorrower(borrowerId)
				.orElseThrow(() -> new BorrowerNotFoundException("Borrower not Found!!!", borrowerId));


		Set<Lender> lenders = new HashSet<Lender>();
		lendersId.forEach(l -> {
			Lender lender = lenderService.getLender(l.getId())
					.orElseThrow(() -> new LenderNotFoundException("Lender not Found!!!", l.getId()));
			lenders.add(lender);
		});
		
		
		loan.setCredit(credit);
		loan.setInterest(interest);
		loan.setForeignCurrency(foreignCurrency);
		loan.setBorrower(borrower);
		loan.setBalance(Utility.money());
		loan.setCalculated(Utility.randomBoolean());
		loan.setDirective(Utility.randomBoolean());
		loan.setIsActive(Utility.randomBoolean());
		loan.setRisk(Utility.risk());
		loan.setTrust(Utility.risk());
		loan.setLenders(lenders);
		return this.loanRepository.save(loan);
	}
	
	public Boolean deleteLoan(Long loanId) {
		if ( this.loanRepository.existsById(loanId) ) {
			this.loanRepository.deleteById(loanId);
			return true;
		}
		return false;
	}

	public List<Loan> listAllLoans() {
		return this.loanRepository.findAll();
	}

	public Long countTotal() {
		return this.loanRepository.count();
	}

	public List<Loan> findAllLoansCreditGreaterThan(Float credit) {
		return this.loanRepository.findAllLoansCreditGreaterThan(credit);
	}

	public Float sumCreditAllLoans() {
		return this.loanRepository.sumCreditAllLoans();
	}

}
