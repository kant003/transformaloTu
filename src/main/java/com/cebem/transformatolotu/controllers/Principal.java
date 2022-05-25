package com.cebem.transformatolotu.controllers;

import java.util.ArrayList;

import com.cebem.transformatolotu.models.BPokemon;
import com.cebem.transformatolotu.models.CharacterAnime;
import com.cebem.transformatolotu.models.Data;
import com.cebem.transformatolotu.models.NamedApiResource;
import com.cebem.transformatolotu.models.Type;
import com.cebem.transformatolotu.services.AnimeService;
import com.cebem.transformatolotu.services.PokemonAdvantageService;
import com.cebem.transformatolotu.utils.Utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Principal {
    @Autowired
    AnimeService animeService;

    @Autowired
    PokemonAdvantageService pokemonAdvantageService;

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

    @GetMapping("/pokemonAdvantage/{pokemonA}/{pokemonB}")
    public String PokemonAdvantage(@PathVariable String pokemonA, @PathVariable String pokemonB){

       BPokemon pkmnA = pokemonAdvantageService.getPokemonFromApi(pokemonA);
       String urlType1A = Utils.getTypeUrl(pkmnA,0);
       Type type1A = pokemonAdvantageService.getTypeFromApi(urlType1A);
       int pointsA=0;

       BPokemon pkmnB = pokemonAdvantageService.getPokemonFromApi(pokemonB);
       String urlType1B = Utils.getTypeUrl(pkmnB,0);
       Type type1B = pokemonAdvantageService.getTypeFromApi(urlType1B);
       int pointsB = 0;

       //atk1A vs def1B
       for(NamedApiResource defTypes : type1B.damage_relations.double_damage_from){
           if (type1A.name.equals(defTypes.name)){
               pointsA++;
           }
       }
       for(NamedApiResource defTypes : type1B.damage_relations.half_damage_from){
           if (type1A.name.equals(defTypes.name)){
               pointsA--;
           }
       }
       for(NamedApiResource defTypes : type1B.damage_relations.no_damage_from){
           if (type1A.name.equals(defTypes.name)){
               pointsA-=2;
           }
       }

       //atk1A vs def2B
       if(pkmnB.types.size() > 1){
           String urlType2B = Utils.getTypeUrl(pkmnB,1);
           Type type2B = pokemonAdvantageService.getTypeFromApi(urlType2B);
       
           for(NamedApiResource defTypes : type2B.damage_relations.double_damage_from){
               if (type1A.name.equals(defTypes.name)){
                   pointsA++;
               }
           }
           for(NamedApiResource defTypes : type2B.damage_relations.half_damage_from){
               if (type1A.name.equals(defTypes.name)){
                   pointsA--;
               }
           }
           for(NamedApiResource defTypes : type2B.damage_relations.no_damage_from){
               if (type1A.name.equals(defTypes.name)){
                   pointsA-=2;
               }
           }
       }

       //atk2A vs def1B
       if(pkmnA.types.size() > 1){
           String urlType2A = Utils.getTypeUrl(pkmnA,1);
           Type type2A = pokemonAdvantageService.getTypeFromApi(urlType2A);
       
           for(NamedApiResource defTypes : type1B.damage_relations.double_damage_from){
               if (type2A.name.equals(defTypes.name)){
                   pointsA++;
               }
           }
           for(NamedApiResource defTypes : type1B.damage_relations.half_damage_from){
               if (type2A.name.equals(defTypes.name)){
                   pointsA--;
               }
           }
           for(NamedApiResource defTypes : type1B.damage_relations.no_damage_from){
               if (type2A.name.equals(defTypes.name)){
                   pointsA-=2;
               }
           }

       //atk2A vs def2B
           if(pkmnB.types.size()>1){
               String urlType2B = Utils.getTypeUrl(pkmnB,1);
               Type type2B = pokemonAdvantageService.getTypeFromApi(urlType2B);

               for(NamedApiResource defTypes : type2B.damage_relations.double_damage_from){
                   if (type2A.name.equals(defTypes.name)){
                       pointsA++;
                   }
               }
               for(NamedApiResource defTypes : type2B.damage_relations.half_damage_from){
                   if (type2A.name.equals(defTypes.name)){
                       pointsA--;
                   }
               }
               for(NamedApiResource defTypes : type2B.damage_relations.no_damage_from){
                   if (type2A.name.equals(defTypes.name)){
                       pointsA-=2;
                   }
               }
           }

       }

      //atk1B vs def1A
      for(NamedApiResource defTypes : type1A.damage_relations.double_damage_from){
       if (type1B.name.equals(defTypes.name)){
           pointsB++;
       }
   }
   for(NamedApiResource defTypes : type1A.damage_relations.half_damage_from){
       if (type1B.name.equals(defTypes.name)){
           pointsB--;
       }
   }
   for(NamedApiResource defTypes : type1A.damage_relations.no_damage_from){
       if (type1B.name.equals(defTypes.name)){
           pointsB-=2;
       }
   }

   //atk1B vs def2A
   if(pkmnA.types.size() > 1){
       String urlType2A = Utils.getTypeUrl(pkmnA,1);
       Type type2A = pokemonAdvantageService.getTypeFromApi(urlType2A);
   
       for(NamedApiResource defTypes : type2A.damage_relations.double_damage_from){
           if (type1B.name.equals(defTypes.name)){
               pointsB++;
           }
       }
       for(NamedApiResource defTypes : type2A.damage_relations.half_damage_from){
           if (type1B.name.equals(defTypes.name)){
               pointsB--;
           }
       }
       for(NamedApiResource defTypes : type2A.damage_relations.no_damage_from){
           if (type1B.name.equals(defTypes.name)){
               pointsB-=2;
           }
       }
   }

   //atk2B vs def1A
   if(pkmnB.types.size() > 1){
       String urlType2B = Utils.getTypeUrl(pkmnB,1);
       Type type2B = pokemonAdvantageService.getTypeFromApi(urlType2B);
   
       for(NamedApiResource defTypes : type1A.damage_relations.double_damage_from){
           if (type2B.name.equals(defTypes.name)){
               pointsB++;
           }
       }
       for(NamedApiResource defTypes : type1A.damage_relations.half_damage_from){
           if (type2B.name.equals(defTypes.name)){
               pointsB--;
           }
       }
       for(NamedApiResource defTypes : type1A.damage_relations.no_damage_from){
           if (type2B.name.equals(defTypes.name)){
               pointsB-=2;
           }
       }

   //atk2B vs def2A
       if(pkmnA.types.size()>1){
           String urlType2A = Utils.getTypeUrl(pkmnA,1);
           Type type2A = pokemonAdvantageService.getTypeFromApi(urlType2A);

           for(NamedApiResource defTypes : type2A.damage_relations.double_damage_from){
               if (type2B.name.equals(defTypes.name)){
                   pointsB++;
               }
           }
           for(NamedApiResource defTypes : type2A.damage_relations.half_damage_from){
               if (type2B.name.equals(defTypes.name)){
                   pointsB--;
               }
           }
           for(NamedApiResource defTypes : type2A.damage_relations.no_damage_from){
               if (type2B.name.equals(defTypes.name)){
                   pointsB-=2;
               }
           }
       }

   }

   if(pointsA > pointsB)
       return pokemonA+" tiene ventaja sobre "+pokemonB;
   else if (pointsB > pointsA)
       return pokemonB+" tiene ventaja sobre "+pokemonA;

       return "No existe ventaja clara";
   }
}
