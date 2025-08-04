package com.br.jozias.bookservice.controller;


import com.br.jozias.bookservice.dto.ExchangeDTO;
import com.br.jozias.bookservice.enviroment.InstanceInformationService;
import com.br.jozias.bookservice.model.Book;
import com.br.jozias.bookservice.proxy.ExchangeFeignClient;
import com.br.jozias.bookservice.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.Map;

@RestController
@RequestMapping("book-service")
public class BookController {

    @Autowired
    private InstanceInformationService instanceInformationService;

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private ExchangeFeignClient exchangeFeignClient;


    @GetMapping(value = "/{id}/{currency}" )
    public Book findBook(@PathVariable Long id, @PathVariable String currency) {
        final String porta = instanceInformationService.retrieveServerPort();
        final Book book = bookRepository.findById(id).orElseThrow(() -> new RuntimeException("Book Not Found"));
        book.setEnvironment(porta);
        book.setCurrency(currency);

        final Map<String, String> params = Map.of(
                "amount", book.getPrice().toString(),
                "from", "USD",
                "to", currency
        );
// exemplo utilizando rest template
//        var response = new RestTemplate().getForEntity(
//                "http://localhost:8000/exchange-service/exchange-service/{amount}/{from}/{to}",
//                ExchangeDTO.class,
//                params
//        );

        final ExchangeDTO exchange = exchangeFeignClient.getExchange(BigDecimal.valueOf(book.getPrice()), "USD", currency);

        book.setEnvironment(exchange.getEnvironment());
        book.setPrice(exchange.getConvertedValue().doubleValue());
        return book;
    }

}
