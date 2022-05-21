package com.cebem.transformatolotu.controllers;

import com.cebem.transformatolotu.models.Quote;
import com.cebem.transformatolotu.services.QuoteService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WebControllerHIMYM {

    @Autowired
    QuoteService quoteService;
    
    @RequestMapping("/webHIMYM")
    public String getRandomQuoteWeb(Model model){
        Quote quote = quoteService.getRandomQuote();
        model.addAttribute("quote", quote);
        return "indexHIMYM";
    }
}
