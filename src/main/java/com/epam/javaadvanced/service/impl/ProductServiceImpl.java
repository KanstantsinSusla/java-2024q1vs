package com.epam.javaadvanced.service.impl;

import com.epam.javaadvanced.model.Product;
import com.epam.javaadvanced.repository.ProductRepository;
import com.epam.javaadvanced.service.ProductService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Log4j2
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepository productRepository;

    @Override
    public Product addProduct(Product product) {
        log.info("Saving product: {}", product.getName());
        return productRepository.save(product);
    }
}
