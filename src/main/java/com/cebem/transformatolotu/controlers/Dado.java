package com.cebem.transformatolotu.controlers;

import com.cebem.transformatolotu.models.Tirada;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class Dado {

    @Autowired
    RestTemplate restTemplate;


    //http://localhost:8080/getTiradas?numDados=5&tipoDado=6
    @GetMapping("/getTiradas")
    public String getTiradas(@RequestParam String numDados, @RequestParam String tipoDado) {
        String url = "https://www.dejete.com/api?nbde=" + numDados +"&tpde=" + tipoDado;
        ResponseEntity<Tirada[]> responseEntity =
        restTemplate.getForEntity(url, Tirada[].class);
        
        Tirada[] objects = responseEntity.getBody();

        String lista = " nº tirada | resultado <br/>";
        
        for (Tirada object : objects) {

            lista += "<br/>";
            lista += " &nbsp; &nbsp; &nbsp; " + object.id + " &nbsp; &nbsp; &nbsp; : &nbsp; &nbsp; &nbsp; "+ object.value;
            lista += "<br/>";

        }
        return lista;
    }
}
