package com.learning.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import com.learning.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{

}
