package com.cebem.transformatolotu.services;

import com.cebem.transformatolotu.models.BPokemon;
import com.cebem.transformatolotu.models.Type;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class PokemonAdvantageService {
    @Autowired
    RestTemplate restTemplate;

    public BPokemon getPokemonFromApi(String pName){
        
        String url = "https://pokeapi.co/api/v2/pokemon/"+pName;
        BPokemon bpokemon = restTemplate.getForObject(url, BPokemon.class);
        return bpokemon;
    }

    public Type getTypeFromApi(String urlType){
        Type type = restTemplate.getForObject(urlType, Type.class);
        return type;
    }
}
