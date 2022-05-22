package com.cebem.transformatolotu.services;

import java.util.ArrayList;
import java.util.Random;

import com.cebem.transformatolotu.models.CharacterAnime;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class AnimeService {
    @Autowired
    RestTemplate restTemplate;

    public CharacterAnime getPhotoCharacter() {
        Random r = new Random();
        Integer randomId = 1 + r.nextInt(200);
        String url = "https://api.jikan.moe/v4/characters/" + randomId;
        return restTemplate.getForObject(url, CharacterAnime.class);

    }
    
}
