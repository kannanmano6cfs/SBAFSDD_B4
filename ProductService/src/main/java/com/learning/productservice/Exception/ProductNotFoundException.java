package com.learning.productservice.Exception;

public class ProductNotFoundException extends RuntimeException {
    public ProductNotFoundException(int id) {
        super("Product with  id " + id + " not found");
    }
}
