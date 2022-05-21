package com.cebem.transformatolotu.services;

import java.util.ArrayList;


import com.cebem.transformatolotu.models.Quote;
import com.cebem.transformatolotu.repositories.QuoteRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QuoteService {

    @Autowired
    QuoteRepository quoteRepository;

    public Quote getRandomQuote(){
        ArrayList<Quote> quotes = (ArrayList<Quote>) quoteRepository.findAll();
        Integer getRandomQuoteId = (int) (Math.random()*quotes.size());
        Quote randomQuote=null;
        for (Quote quote : quotes) {
            if(quote.getId().equals(getRandomQuoteId)) randomQuote=quote;
        }
        return randomQuote;
    }
    
    
}
