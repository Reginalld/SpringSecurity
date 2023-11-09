package com.uniamerica.projetoSpringSecurity2.Controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/")
public class TestController {

    @GetMapping
    public String teste(){
        return "<h1>Teste</h1>";

    }

    @GetMapping("/livre")
    public String rotalivre(){
        return "<h2>Rota libertada</h2>";
    }

}