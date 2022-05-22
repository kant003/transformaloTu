package com.cebem.transformatolotu.controllers;

import com.cebem.transformatolotu.utils.Utils;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Main {
    @GetMapping("/mezclaCadena/{texto}")
    public String greet(@PathVariable String texto){
        return Utils.stringShuffle(texto);
    }
}
