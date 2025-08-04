package com.br.jozias.bookservice.proxy;

import com.br.jozias.bookservice.dto.ExchangeDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.math.BigDecimal;

@FeignClient(name = "exchange-service", url = "localhost:8000")
public interface ExchangeFeignClient {

    @GetMapping("/exchange-service/{amount}/{from}/{to}")
    public ExchangeDTO getExchange(
            @PathVariable BigDecimal amount,
            @PathVariable String from,
            @PathVariable String to);
}
