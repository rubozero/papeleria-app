package com.papeleria.my_app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PapeleriaController {

    // Landing page
    @GetMapping("/")
    public String landing() {
        return "index";
    }

    // Aquí puedes agregar otros métodos generales si los necesitas
}
