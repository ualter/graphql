package com.graphql.mortgages.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode
@Entity
public class Loan {

	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private Float credit;
	private Float interest;
	private Boolean isActive;
	private Float balance;
	private Integer trust;
	private Integer risk;
	private Boolean calculated;
	private Boolean directive;
	private String foreignCurrency;
	
	@ManyToOne
    @JoinColumn(name = "borrower_id",nullable = false, updatable = false)
	private Borrower borrower;
	
	@ManyToMany(fetch=FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinTable(name="LOAN_LENDER",
	           joinColumns=@JoinColumn(name="loan_id", referencedColumnName="id"),
	           inverseJoinColumns=@JoinColumn(name="lender_id", referencedColumnName="id"))
	private Set<Lender> lenders;

}
