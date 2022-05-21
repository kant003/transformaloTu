package com.cebem.transformatolotu.repositories;

import com.cebem.transformatolotu.models.Quote;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuoteRepository extends CrudRepository<Quote, Integer>{
    
}
