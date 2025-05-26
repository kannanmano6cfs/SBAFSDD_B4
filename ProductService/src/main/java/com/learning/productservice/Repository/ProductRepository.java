package com.learning.productservice.Repository;

import com.learning.productservice.Model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product,Integer> {
    //Method for custom method name
    Optional<Product> findByPrdname(String name);

    //Method for filtering
    Page<Product> findByPrdnameContainingIgnoreCase(String name, Pageable pageable);
}
