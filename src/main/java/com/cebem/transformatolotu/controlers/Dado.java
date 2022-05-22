package com.cebem.transformatolotu.controlers;

import com.cebem.transformatolotu.models.Tirada;
import com.cebem.transformatolotu.services.DadoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Dado {

    @Autowired
    DadoService dadoService;

    //http://localhost:8080/dado?nbde=5&tpde=6
    @GetMapping("/dado")
    public String dado(@PathVariable String nbde, @PathVariable String tpde) {
        Tirada tirada = dadoService.getTiradaFromAPI(nbde, tpde);
        return "Resultado de tirada " + tirada.id + ": " + tirada.value;
    }
}
