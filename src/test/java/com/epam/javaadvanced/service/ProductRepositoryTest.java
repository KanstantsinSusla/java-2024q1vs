package com.epam.javaadvanced.service;

import com.epam.javaadvanced.model.Product;
import com.epam.javaadvanced.repository.ProductRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace.*;

@RunWith(SpringRunner.class)
@ActiveProfiles(value = "test")
@DataJpaTest
@AutoConfigureTestDatabase(replace = NONE)
public class ProductRepositoryTest {

    @Autowired
    private ProductRepository productRepository;

    @Test
    public void addProductTest() {
        final String productName = "Product1";

        Product product = new Product();
        product.setName(productName);

        Product savedProduct = productRepository.save(product);

        assertNotNull(savedProduct);
        assertEquals(productName, savedProduct.getName());
    }
}
