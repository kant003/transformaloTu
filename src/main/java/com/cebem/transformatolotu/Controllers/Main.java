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
            mnsj+= data.name + "-" + data.released_date + "<br/>";
        }
        return mnsj;
    }
}
