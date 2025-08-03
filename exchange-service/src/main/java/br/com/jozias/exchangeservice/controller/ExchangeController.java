package br.com.jozias.exchangeservice.controller;

import br.com.jozias.exchangeservice.enviroment.InstanceInformationService;
import br.com.jozias.exchangeservice.model.Exchange;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
@RequestMapping(value = "/exchange-service", produces = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
public class ExchangeController {

    private final InstanceInformationService instanceInformationService;

    @GetMapping("/exchange-service/{amount}/{from}/{to}")
    public Exchange getExchange(
            @PathVariable BigDecimal amount,
            @PathVariable String from,
            @PathVariable String to) {
        return new Exchange(
                1L,
                "USD",
                "BRL",
                BigDecimal.ONE,
                BigDecimal.ONE,
                instanceInformationService.retrieveServerPort()
        );
    }
}
