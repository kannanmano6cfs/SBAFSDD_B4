package com.learning.servicea.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class serviceAController {

    @Autowired
    private Environment env;

    @GetMapping("/servicea")
    public String servicea() {
        return "Hello!! This is from service A on port: "+env.getProperty("server.port");
    }
}
