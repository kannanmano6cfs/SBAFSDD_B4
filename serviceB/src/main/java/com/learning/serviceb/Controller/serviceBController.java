package com.learning.serviceb.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class serviceBController {

    @GetMapping("/serviceb")
    public String serviceb() {
        return "Hello!! This is from service B";
    }
}
