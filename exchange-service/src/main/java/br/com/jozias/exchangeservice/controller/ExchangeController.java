package br.com.jozias.exchangeservice.controller;

import br.com.jozias.exchangeservice.enviroment.InstanceInformationService;
import br.com.jozias.exchangeservice.model.Exchange;
import br.com.jozias.exchangeservice.repository.ExchangeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.crossstore.ChangeSetPersister;
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
    private final ExchangeRepository exchangeRepository;


    @GetMapping("{amount}/{from}/{to}")
    public Exchange getExchange(
            @PathVariable BigDecimal amount,
            @PathVariable String from,
            @PathVariable String to) {

        final Exchange exchange = exchangeRepository.findByFromAndTo(from, to).orElseThrow(
                () -> new RuntimeException("Not Suported Exchange"));

        final BigDecimal conversionFactor = exchange.getConversionFactor();
        final BigDecimal covertedValue = conversionFactor.multiply(amount);

        exchange.setConvertedValue(covertedValue);
        exchange.setEnvironment("PORT: " + instanceInformationService.retrieveServerPort());
        return exchange;
    }
}
