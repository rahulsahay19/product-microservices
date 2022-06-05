package com.microservices.myview.productservice.repository;

import com.microservices.myview.productservice.model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductRepository extends MongoRepository<Product, String> {
}
