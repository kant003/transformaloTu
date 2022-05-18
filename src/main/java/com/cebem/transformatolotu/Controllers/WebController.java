package com.cebem.transformatolotu.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WebController {
    @RequestMapping("/formularioZelda")
    public String getFormularioGato(Model model){
        return "formularioZelda";
    }
}
