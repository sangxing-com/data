package com.cst.finance.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/home")
public class HomeController {

    @Value("${server.port}")
    String port;

    @RequestMapping("/index")
    public String index() {
        return "Hello world ,port:" + port;
    }
}
