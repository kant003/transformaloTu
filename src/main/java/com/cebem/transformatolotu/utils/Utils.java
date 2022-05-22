package com.cebem.transformatolotu.utils;

public class Utils {
    public static String stringShuffle(String texto) {
		char[] cadena = texto.toCharArray();
		for(int i = cadena.length-1; i>0; i--) {
			if(Math.random()<0.7) {
				char aux = cadena[i];
				int random = (int) (Math.random()*(i+1));
				cadena[i] = cadena[random];
				cadena[random] = aux;
			}
		}
		return new String(cadena);	
	}
}
