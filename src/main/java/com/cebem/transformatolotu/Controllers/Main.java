package com.cebem.transformatolotu.Controllers;

import java.util.Map;

import javax.sound.midi.MidiSystem;

import com.cebem.transformatolotu.Services.zeldaService;
import com.cebem.transformatolotu.model.Game;
import com.cebem.transformatolotu.model.Data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Main {

    @Autowired
    zeldaService zService;

    @GetMapping("/")
    public String Bienvenida(){
        return "Bienvenido al buscador Zelda";
    }

    @PostMapping("/zelda")
    public String verJuego(@RequestParam Map<String, String> body){
        String gamename =  body.get("game");
        Game c = zService.getGameFromAPI(gamename);
        String mnsj  ="";
        for (Data data : c.data) {
            mnsj+= "<h3> Nombre Completo :  </h3>" +"<h3 style='color:blue;'>" + data.name  + "</h3>"+ "      "+ "<h3> Fecha Publicación : </h3>" +"<h3 style='color:blue;'>" + data.released_date +"</h3>" +"<br/>";
        } 

        if(c.data.size() == 0){
            return "<h3> Juego no encontrado </h3>";
        }else{
            return mnsj;
        }

        
    }
}
