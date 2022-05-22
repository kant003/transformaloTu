package com.cebem.transformatolotu.services;

import com.cebem.transformatolotu.models.Tirada;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class DadoService {
    @Autowired
    RestTemplate restTemplate;

    public Tirada getTiradaFromAPI(String numDados, String tipoDado) {
        String url ="https://www.dejete.com/api?nbde=" + numDados +"&tpde=" + tipoDado;
        Tirada tirada = restTemplate.getForObject(url, Tirada.class);
        return tirada;
    }
    
}
