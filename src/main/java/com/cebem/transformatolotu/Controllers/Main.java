package com.cebem.transformatolotu.Controllers;

import javax.sound.midi.MidiSystem;

import com.cebem.transformatolotu.Services.zeldaService;
import com.cebem.transformatolotu.model.Game;
import com.cebem.transformatolotu.model.Data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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

    @GetMapping("/zelda")
    public String verJuego(@RequestParam String name){
        Game c = zService.getGameFromAPI(name);
        String mnsj  ="";
        for (Data data : c.data) {
            mnsj+= data.name + "-" + data.released_date + "<br/>";
        }
        return mnsj;
    }
}
