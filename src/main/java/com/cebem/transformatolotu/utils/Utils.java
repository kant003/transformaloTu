package com.cebem.transformatolotu.utils;

public class Utils {
  
    public static String isParImpar(String number) {
        if( !number.matches("[+-]?\\d*(\\.\\d+)?")) return "No ha introducido un numero entero";
        return (Integer.parseInt(number) % 2 == 0) ? "El numero es par" : "El numero es impar";
        
        
    }
}
