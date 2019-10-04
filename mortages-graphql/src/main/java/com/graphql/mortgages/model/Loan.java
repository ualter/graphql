package com.graphql.mortgages.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
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
	private Integer interest;
	private Boolean isActive;
	private Float balance;
	private Float trust;
	private Integer risk;
	private Boolean calculated;
	private Boolean directive;
	private String foreignCurrency;
	@ManyToOne
    @JoinColumn(name = "borrower_id",nullable = false, updatable = false)
	private Borrower borrower;

}
