package com.learning.productservice.Controller;


import com.learning.productservice.Exception.ProductNotFoundException;
import com.learning.productservice.Model.Product;
import com.learning.productservice.Repository.ProductRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api")
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    //@GetMapping("/")
    @RequestMapping(path="/", method= RequestMethod.GET)
    public String Welcome() {
        return "Welcome to the Product Service";
    }

    @GetMapping("/v1/count")
    public ResponseEntity<String> count() {
        long ct=productRepository.count();
        return new ResponseEntity<>("Number of products is "+ct, HttpStatus.OK);
    }

    //For Unit Testing
    @GetMapping("/v2/count")
    public long count1(){
        return productRepository.count();
    }

    @GetMapping("/products/v1")
    @Cacheable(value="allproducts")
    public Iterable<Product> getProducts() {
        return productRepository.findAll();
    }

    //Example for Exception handling and Path Variable
    @GetMapping("/product/{id}")
    public Product getProduct(@PathVariable int id) {
        Optional<Product> product=productRepository.findById(id);
        return product.orElseThrow(()-> new ProductNotFoundException(id));
    }

    @GetMapping("/product/v1")
    public Product getProduct1(@RequestParam int id) {
       Optional<Product> product=productRepository.findById(id);
       return product.orElse(null);
    }

    @GetMapping("/product/v2")
    public Product getProduct2(@RequestParam String name) {
        Optional<Product> product=productRepository.findByPrdname(name);
        return product.orElse(null);
    }

    //Pagination
    @GetMapping("/products/v2")
    public Page<Product> getProducts3(@PageableDefault(size=2) Pageable pageable) {
        return productRepository.findAll(pageable);
    }

    //Filtering
    @GetMapping("/search")
    public ResponseEntity<Page<Product>> getProducts4(@RequestParam String name, Pageable pageable) {
        return ResponseEntity.ok(productRepository.findByPrdnameContainingIgnoreCase(name, pageable));
    }

    //Post Methods in Rest
    @PostMapping("/new/v1")
    @CacheEvict(value = "allproducts", allEntries = true)
    public ResponseEntity<String> add() {
        Product product=new Product();
        product.setPrdname("Apple 14");
        product.setPrdprice(80000.00);
        product.setPrddesc("Apple smart phone device");
        productRepository.save(product);
        return new ResponseEntity<>("Product added successfully", HttpStatus.OK);
    }

    //Validation implementation
    @PostMapping("/new/v2")
    public ResponseEntity<String> add2(@Valid @RequestBody Product product) {
        productRepository.save(product);
        return new ResponseEntity<>("Product added successfully", HttpStatus.OK);
    }

    //Put Methods in Rest
    @PutMapping("/edit/{id}")
    public ResponseEntity<String> edit(@PathVariable int id, @RequestBody Product product) {
        Product product1=productRepository.findById(id).orElseThrow();
        product1.setPrdname(product.getPrdname());
        product1.setPrdprice(product.getPrdprice());
        product1.setPrddesc(product.getPrddesc());
        productRepository.save(product1);
        return new ResponseEntity<>("Product updated successfully", HttpStatus.OK);
    }

    //Delete Method in Rest
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable int id) {
        productRepository.deleteById(id);
        return new ResponseEntity<>("Product deleted successfully", HttpStatus.OK);
    }

    @DeleteMapping("/deleteall")
    public ResponseEntity<String> deleteAll() {
        productRepository.deleteAll();
        return new ResponseEntity<>("All Products deleted successfully", HttpStatus.OK);
    }
}
