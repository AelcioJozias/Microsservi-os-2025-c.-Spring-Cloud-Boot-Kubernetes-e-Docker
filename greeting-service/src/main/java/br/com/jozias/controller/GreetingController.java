package br.com.jozias.controller;

import br.com.jozias.config.GreetingConfig;
import br.com.jozias.model.Greeting;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class GreetingController {

    private final String template = "%s, %s!";
    private final AtomicLong counter = new AtomicLong();
    private final GreetingConfig greetingConfig;

    public GreetingController(final GreetingConfig greetingConfig) {
        this.greetingConfig = greetingConfig;
    }


    // http://localhost:8080/greeting?name=Leandro
    @RequestMapping("/greeting")
    public Greeting greeting(@RequestParam(value = "name", defaultValue = "") String name) {
        if(name.isEmpty()){
            name = greetingConfig.getDefaultValue();
        }
        return  new Greeting(counter.incrementAndGet(), String.format(template, greetingConfig.getGreeting(), name));
    }
}
