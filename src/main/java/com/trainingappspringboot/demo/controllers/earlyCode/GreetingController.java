package com.trainingappspringboot.demo.controllers.earlyCode;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@RestController // we are telling Spring to automatically create a REST controller,
public class GreetingController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/greeting")
    @ResponseBody
    public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
        System.out.println("greeting controller");
        return new Greeting(counter.incrementAndGet(), String.format(template, name)); // in the case of @RestController, new Greeting is converted into JSON to be used in the view.

    }

}
