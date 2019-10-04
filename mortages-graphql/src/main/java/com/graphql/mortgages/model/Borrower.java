package com.graphql.mortgages.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode
@Entity
public class Borrower {
	
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private String eyeColor;
	private String name;
    private String gender;
    private String company;
    private String email;
    private String phone;
    private String address;
    private String registered;

}
