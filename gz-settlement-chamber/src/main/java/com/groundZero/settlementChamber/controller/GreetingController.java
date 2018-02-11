package com.groundZero.settlementChamber.controller;

import com.groundZero.settlementChamber.model.Greeting;
import java.util.concurrent.atomic.AtomicLong;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {

    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/greeting")
    public Greeting greeting(@RequestParam("name") String name) {
        return new Greeting(counter.incrementAndGet(), String.format("Hello, %s!", name));
    }
}
