package com.cebem.transformatolotu.utils;

import com.cebem.transformatolotu.models.BPokemon;
import com.cebem.transformatolotu.models.PokemonType;

public class Utils {
  
    public static String isParImpar(String number) {
        if( !number.matches("[+-]?\\d*(\\.\\d+)?")) return "No ha introducido un numero entero";
        return (Integer.parseInt(number) % 2 == 0) ? "El numero es par" : "El numero es impar";
        
        
    }

    public static String getTypeUrl(BPokemon pokemon, int index) {
		PokemonType pokemonType = pokemon.types.get(index);
		
		return pokemonType.type.url;
	}
    public static int sumaNums (String cadena) {
				
        String cadena1 = cadena;
        String[] nums = cadena1.split(",");
        int suma=0;
        for(String num: nums) {
            suma+= Integer.parseInt(num);
        }
        return suma;
    }
}
