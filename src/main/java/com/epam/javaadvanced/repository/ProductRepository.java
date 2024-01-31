package com.epam.javaadvanced.repository;

import com.epam.javaadvanced.model.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product, Long> {
}
