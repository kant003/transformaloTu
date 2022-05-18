package com.cebem.transformatolotu.Services;
import java.util.ArrayList;

import com.cebem.transformatolotu.model.Game;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class zeldaService {
    @Autowired
    RestTemplate restTemplate ;

    public Game getGameFromAPI(String n){
        
        String url = "https://zelda.fanapis.com/api/games?name=" + n;
        
        Game game = restTemplate.getForObject(url, Game.class);
        return game;
    }
}
