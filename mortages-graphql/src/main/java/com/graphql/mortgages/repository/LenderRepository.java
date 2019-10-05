package com.graphql.mortgages.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.graphql.mortgages.model.Lender;

@Repository
public interface LenderRepository extends JpaRepository<Lender, Long>{

}
