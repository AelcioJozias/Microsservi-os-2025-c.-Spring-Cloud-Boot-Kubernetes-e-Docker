package com.br.jozias.bookservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("book-service/test")
public class ControllerTest {

    @GetMapping
    public String test(){
        return "entao ta chamaando esse??" +
                "" +
                "testando se vai chamar essa rota, devido a modificacao que " +
                "fizemos na classe ApiGatewayConfig do projeto api-gateway." +
                "Que alteramos a maneira que chamamos o servico no gateway";
    }
}
