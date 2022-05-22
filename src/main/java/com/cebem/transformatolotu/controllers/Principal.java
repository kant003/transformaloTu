package com.cebem.transformatolotu.controllers;

import java.util.ArrayList;

import com.cebem.transformatolotu.models.CharacterAnime;
import com.cebem.transformatolotu.models.Data;
import com.cebem.transformatolotu.services.AnimeService;
import com.cebem.transformatolotu.utils.Utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Principal {
    @Autowired
    AnimeService animeService;

    @GetMapping("/charactersAnime/random")
    public String getAnimeCharacterRandom() {
        CharacterAnime animePerson = animeService.getPhotoCharacter();

        return "<img src='" + animePerson.data.images.jpg.image_url + "'/>" + "<p>" + "\n" +
                animePerson.data.name
                + "\n\t" + animePerson.data.mal_id + "</p>";
    }

    @GetMapping("/isparimpar/{number}")
    public String count(@PathVariable String number) {
        return Utils.isParImpar(number);

    }

}
