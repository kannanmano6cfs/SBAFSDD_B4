package com.learning.excontainerdemo.Controller;

import com.learning.excontainerdemo.Model.Prod;
import com.learning.excontainerdemo.Repository.demoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class demoController {

    @Autowired
    private demoRepository repo;

    @GetMapping("/api")
    public String hello() {
        return "Hello World! This is from Container in Docker Desktop";
    }

    @PostMapping("/new")
    public ResponseEntity<String> newDemo(@RequestBody Prod prod) {
        repo.save(prod);
        return ResponseEntity.status(201).body("New product added");
    }

    @GetMapping("/prods")
    public Iterable<Prod> getAll() {
        Iterable<Prod> prods = repo.findAll();
        return prods;
    }
}
